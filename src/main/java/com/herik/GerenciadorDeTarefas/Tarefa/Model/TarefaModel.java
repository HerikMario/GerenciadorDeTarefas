package com.herik.GerenciadorDeTarefas.Tarefa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.herik.GerenciadorDeTarefas.Tarefa.Enums.Status;
import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private UsuarioModel usuario;

}
