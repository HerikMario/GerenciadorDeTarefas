package com.herik.GerenciadorDeTarefas.Tarefa.Mapper;

import com.herik.GerenciadorDeTarefas.Tarefa.DTO.TarefaOutputDTO;
import com.herik.GerenciadorDeTarefas.Tarefa.Model.TarefaModel;
import org.springframework.stereotype.Component;

@Component
public class TarefaOutputMapper {

    public TarefaModel map(TarefaOutputDTO tarefaOutputDTO) {
        return new TarefaModel(
                tarefaOutputDTO.getId(),
                tarefaOutputDTO.getTitulo(),
                tarefaOutputDTO.getDescricao(),
                tarefaOutputDTO.getStatus(),
                tarefaOutputDTO.getUsuario()
        );
    }

    public TarefaOutputDTO map(TarefaModel tarefaModel) {
        return new TarefaOutputDTO(
                tarefaModel.getId(),
                tarefaModel.getTitulo(),
                tarefaModel.getDescricao(),
                tarefaModel.getStatus(),
                tarefaModel.getUsuario()
        );
    }

}
