package com.herik.GerenciadorDeTarefas.Tarefa.DTO;

import com.herik.GerenciadorDeTarefas.Tarefa.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaInputDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Status status;
    private Long usuario_id;

}
