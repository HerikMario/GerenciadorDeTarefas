package com.herik.GerenciadorDeTarefas.Tarefa.Service;

import com.herik.GerenciadorDeTarefas.Exception.TarefaNotFoundException;
import com.herik.GerenciadorDeTarefas.Exception.UsuarioNotFoundException;
import com.herik.GerenciadorDeTarefas.Tarefa.DTO.TarefaInputDTO;
import com.herik.GerenciadorDeTarefas.Tarefa.DTO.TarefaOutputDTO;
import com.herik.GerenciadorDeTarefas.Tarefa.Mapper.TarefaInputMapper;
import com.herik.GerenciadorDeTarefas.Tarefa.Mapper.TarefaOutputMapper;
import com.herik.GerenciadorDeTarefas.Tarefa.Model.TarefaModel;
import com.herik.GerenciadorDeTarefas.Tarefa.Repository.TarefaRepository;
import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import com.herik.GerenciadorDeTarefas.Usuario.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TarefaInputMapper tarefaInputMapper;
    private final TarefaOutputMapper tarefaOutputMapper;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository, TarefaInputMapper tarefaInputMapper, TarefaOutputMapper tarefaOutputMapper) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
        this.tarefaInputMapper = tarefaInputMapper;
        this.tarefaOutputMapper = tarefaOutputMapper;
    }

    // Métodos específicos

    public TarefaOutputDTO criarTarefa(TarefaInputDTO tarefa) {
        UsuarioModel usuarioModel = usuarioRepository.findById(tarefa.getUsuario_id())
                .orElseThrow(() -> new UsuarioNotFoundException(tarefa.getUsuario_id()));
        return tarefaOutputMapper.map(tarefaRepository.save(tarefaInputMapper.map(tarefa, usuarioModel)));
    }

    public List<TarefaOutputDTO> listarTarefas() {
        List<TarefaModel> tarefasModel = tarefaRepository.findAll();
        List<TarefaOutputDTO> tarefasOutputDTO = new ArrayList<>();
        for (TarefaModel tarefaModel : tarefasModel) {
            tarefasOutputDTO.add(tarefaOutputMapper.map(tarefaModel));
        }
        return tarefasOutputDTO;
    }

    public TarefaOutputDTO alterarTarefa(Long id, TarefaInputDTO tarefaAtualizada) {
        TarefaModel tarefaModel = tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNotFoundException(id));

        UsuarioModel usuarioModel = usuarioRepository.findById(tarefaAtualizada.getUsuario_id())
                .orElseThrow(() -> new UsuarioNotFoundException(tarefaAtualizada.getUsuario_id()));

        tarefaModel.setUsuario(usuarioModel);
        tarefaModel.setDescricao(tarefaAtualizada.getDescricao());
        tarefaModel.setTitulo(tarefaAtualizada.getTitulo());
        tarefaModel.setStatus(tarefaAtualizada.getStatus());

        return tarefaOutputMapper.map(tarefaRepository.save(tarefaModel));
    }

    public void deletarTarefa(Long id) {
        boolean exists = tarefaRepository.existsById(id);
        if(exists) {
            tarefaRepository.deleteById(id);
        } else {
            throw new TarefaNotFoundException(id);
        }
    }

}
