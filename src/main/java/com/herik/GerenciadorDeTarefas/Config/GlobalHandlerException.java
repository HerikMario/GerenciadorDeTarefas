package com.herik.GerenciadorDeTarefas.Config;

import com.herik.GerenciadorDeTarefas.Exception.TarefaNotFoundException;
import com.herik.GerenciadorDeTarefas.Exception.UsuarioAlreadyExistsException;
import com.herik.GerenciadorDeTarefas.Exception.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler
    public ResponseEntity<String> handleTarefaNotFound(TarefaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleUsuarioNotFound(UsuarioNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleUsuarioAlreadyExists(UsuarioAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

}
