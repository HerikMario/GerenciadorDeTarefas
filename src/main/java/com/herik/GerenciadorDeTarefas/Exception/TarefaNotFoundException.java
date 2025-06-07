package com.herik.GerenciadorDeTarefas.Exception;

public class TarefaNotFoundException extends RuntimeException {
    public TarefaNotFoundException(Long id) {
        super("Tarefa de id " + id + " não encontrada");
    }
}
