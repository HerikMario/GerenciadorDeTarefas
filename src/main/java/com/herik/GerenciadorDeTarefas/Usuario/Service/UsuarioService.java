package com.herik.GerenciadorDeTarefas.Usuario.Service;

import com.herik.GerenciadorDeTarefas.Exception.TarefaNotFoundException;
import com.herik.GerenciadorDeTarefas.Exception.UsuarioAlreadyExistsException;
import com.herik.GerenciadorDeTarefas.Exception.UsuarioNotFoundException;
import com.herik.GerenciadorDeTarefas.Tarefa.Model.TarefaModel;
import com.herik.GerenciadorDeTarefas.Tarefa.Repository.TarefaRepository;
import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioAtualizarDTO;
import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioInputDTO;
import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioOutputDTO;
import com.herik.GerenciadorDeTarefas.Usuario.Mapper.UsuarioInputMapper;
import com.herik.GerenciadorDeTarefas.Usuario.Mapper.UsuarioOutputMapper;
import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import com.herik.GerenciadorDeTarefas.Usuario.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TarefaRepository tarefaRepository;
    private final UsuarioOutputMapper usuarioOutputMapper;
    private final UsuarioInputMapper usuarioInputMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, TarefaRepository tarefaRepository, UsuarioOutputMapper usuarioOutputMapper, UsuarioInputMapper usuarioInputMapper) {
        this.usuarioRepository = usuarioRepository;
        this.tarefaRepository = tarefaRepository;
        this.usuarioOutputMapper = usuarioOutputMapper;
        this.usuarioInputMapper = usuarioInputMapper;
    }

    // Métodos específicos

    public UsuarioOutputDTO criarUsuario(UsuarioInputDTO usuarioInputDTO) {
        UsuarioModel usuarioModel = usuarioRepository.save(usuarioInputMapper.map(usuarioInputDTO));
        return usuarioOutputMapper.map(usuarioModel);
    }

    public List<UsuarioOutputDTO> listarUsuarios() {
        List<UsuarioModel> usuariosModel = usuarioRepository.findAll();
        List<UsuarioOutputDTO> usuariosOutputDTO = new ArrayList<>();
        for (UsuarioModel usuarioModel : usuariosModel) {
            usuariosOutputDTO.add(usuarioOutputMapper.map(usuarioModel));
        }
        return usuariosOutputDTO;
    }

    public UsuarioOutputDTO atualizarUsuario(Long id, UsuarioAtualizarDTO usuarioAtualizado) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        List<TarefaModel> tarefas = new ArrayList<>();

        for (Long idDaVez : usuarioAtualizado.getTarefas_id()) {
            TarefaModel tarefa = tarefaRepository.findById(idDaVez)
                            .orElseThrow(() -> new TarefaNotFoundException(idDaVez));
            tarefas.add(tarefa);
        }

        // Remove vínculos antigos
        for (TarefaModel tarefa : usuario.getTarefas()) {
            tarefa.setUsuario(null);
        }

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setTarefas(tarefas);

        for (TarefaModel tarefaModel : usuario.getTarefas()) {
            tarefaModel.setUsuario(usuario);
        }

        return usuarioOutputMapper.map(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id){
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        for (TarefaModel tarefa : usuarioModel.getTarefas()) {
            tarefaRepository.deleteById(tarefa.getId());
        }

        usuarioRepository.deleteById(id);
    }

}
