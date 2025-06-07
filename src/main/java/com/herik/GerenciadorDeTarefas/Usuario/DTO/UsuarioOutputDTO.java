package com.herik.GerenciadorDeTarefas.Usuario.DTO;

import com.herik.GerenciadorDeTarefas.Tarefa.Model.TarefaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioOutputDTO {

    private Long id;
    private String nome;
    private String email;
    private List<TarefaModel> tarefas;

}
