package com.herik.GerenciadorDeTarefas.Tarefa.DTO;

import com.herik.GerenciadorDeTarefas.Tarefa.Enums.Status;
import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioInputDTO;
import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaOutputDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Status status;
    private UsuarioModel usuario;

}
