package com.herik.GerenciadorDeTarefas.Tarefa.Mapper;

import com.herik.GerenciadorDeTarefas.Tarefa.DTO.TarefaInputDTO;
import com.herik.GerenciadorDeTarefas.Tarefa.Model.TarefaModel;
import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class TarefaInputMapper {

    public TarefaModel map(TarefaInputDTO tarefaInputDTO, UsuarioModel usuarioModel) {
        return new TarefaModel(
                tarefaInputDTO.getId(),
                tarefaInputDTO.getTitulo(),
                tarefaInputDTO.getDescricao(),
                tarefaInputDTO.getStatus(),
                usuarioModel
        );
    }

    public TarefaInputDTO map(TarefaModel tarefaModel) {
        return new TarefaInputDTO(
                tarefaModel.getId(),
                tarefaModel.getTitulo(),
                tarefaModel.getDescricao(),
                tarefaModel.getStatus(),
                tarefaModel.getUsuario().getId()
        );
    }

}
