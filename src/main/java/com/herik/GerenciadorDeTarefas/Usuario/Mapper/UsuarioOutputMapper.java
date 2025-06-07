package com.herik.GerenciadorDeTarefas.Usuario.Mapper;

import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioOutputDTO;
import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioOutputMapper {

    public UsuarioModel map(UsuarioOutputDTO usuarioOutputDTO) {
        return new UsuarioModel(
                usuarioOutputDTO.getId(),
                usuarioOutputDTO.getNome(),
                usuarioOutputDTO.getEmail(),
                usuarioOutputDTO.getTarefas()
        );
    }

    public UsuarioOutputDTO map(UsuarioModel usuarioModel) {
        return new UsuarioOutputDTO(
                usuarioModel.getId(),
                usuarioModel.getNome(),
                usuarioModel.getEmail(),
                usuarioModel.getTarefas()
        );
    }

}
