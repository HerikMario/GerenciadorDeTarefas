package com.herik.GerenciadorDeTarefas.Usuario.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.herik.GerenciadorDeTarefas.Tarefa.Model.TarefaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "tarefas")
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<TarefaModel> tarefas;

}
