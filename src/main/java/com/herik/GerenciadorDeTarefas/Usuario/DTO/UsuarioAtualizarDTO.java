package com.herik.GerenciadorDeTarefas.Usuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAtualizarDTO {

    private Long id;
    private String nome;
    private String email;
    private List<Long> tarefas_id;

}
