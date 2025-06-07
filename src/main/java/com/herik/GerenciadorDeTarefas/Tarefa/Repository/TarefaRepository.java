package com.herik.GerenciadorDeTarefas.Tarefa.Repository;

import com.herik.GerenciadorDeTarefas.Tarefa.Model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
