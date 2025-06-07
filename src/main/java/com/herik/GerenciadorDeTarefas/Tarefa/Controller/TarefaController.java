package com.herik.GerenciadorDeTarefas.Tarefa.Controller;

import com.herik.GerenciadorDeTarefas.Tarefa.DTO.TarefaInputDTO;
import com.herik.GerenciadorDeTarefas.Tarefa.DTO.TarefaOutputDTO;
import com.herik.GerenciadorDeTarefas.Tarefa.Service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "http://localhost:5500")
public class TarefaController {

    TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarTarefa(@RequestBody TarefaInputDTO tarefa) {
        TarefaOutputDTO tarefaOutputDTO = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A tarefa " + tarefa.getTitulo() + " foi criada!");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarTarefas() {
        List<TarefaOutputDTO> tarefas = tarefaService.listarTarefas();
        return ResponseEntity.status(HttpStatus.OK)
                .body(tarefas);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarTarefa(@PathVariable Long id, @RequestBody TarefaInputDTO tarefaAtualizada) {
        TarefaOutputDTO tarefaOutputDTO = tarefaService.alterarTarefa(id, tarefaAtualizada);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Tarefa " + tarefaAtualizada.getTitulo() + " atualizada!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("A tarefa de id " + id + " foi deletada!");
    }

}
