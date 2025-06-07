package com.herik.GerenciadorDeTarefas.Usuario.Controller;

import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioAtualizarDTO;
import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioInputDTO;
import com.herik.GerenciadorDeTarefas.Usuario.DTO.UsuarioOutputDTO;
import com.herik.GerenciadorDeTarefas.Usuario.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioInputDTO usuarioInputDTO) {
        UsuarioOutputDTO usuarioOutputDTO = usuarioService.criarUsuario(usuarioInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O usuário " + usuarioOutputDTO.getNome() + " foi criado!");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        List<UsuarioOutputDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioAtualizarDTO usuarioAtualizado){
        UsuarioOutputDTO usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        return ResponseEntity.status(HttpStatus.OK)
                .body("O usuário " + usuario.getNome() + " foi atualizado conforme os parâmetros concedidos!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuário de id " + id + " deletado com sucesso!");
    }

}
