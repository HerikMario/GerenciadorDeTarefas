package com.herik.GerenciadorDeTarefas.Exception;

public class UsuarioAlreadyExistsException extends RuntimeException {
    public UsuarioAlreadyExistsException(Long id) {
        super("O usuário de id " + id + " já existe!");
    }
}
