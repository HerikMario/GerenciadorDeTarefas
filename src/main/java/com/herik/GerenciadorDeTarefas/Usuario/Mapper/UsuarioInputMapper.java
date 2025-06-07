package com.herik.GerenciadorDeTarefas.Usuario.Mapper;

import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioInputDTO;
import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInputMapper {

    public UsuarioModel map(UsuarioInputDTO usuarioInputDTO) {
        return new UsuarioModel(
                usuarioInputDTO.getId(),
                usuarioInputDTO.getNome(),
                usuarioInputDTO.getEmail(),
                null
        );
    }

    public UsuarioInputDTO map(UsuarioModel usuarioModel) {
        return new UsuarioInputDTO(
                usuarioModel.getId(),
                usuarioModel.getNome(),
                usuarioModel.getEmail()
        );
    }

}
