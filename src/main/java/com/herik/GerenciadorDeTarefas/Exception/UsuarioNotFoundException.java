package com.herik.GerenciadorDeTarefas.Exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super("Usuario de id " + id + " não encontrado!");
    }
}
