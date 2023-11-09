package br.com.spring.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.spring.banco.model.Tarefa;
import br.com.spring.banco.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/criar")
    public Tarefa criaTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @GetMapping
    public Iterable<Tarefa> consultaTarefas() {
    	return tarefaRepository.findTarefas();
    }

    @GetMapping("/exibir/{id}")
    public Tarefa exibeTarefa(@PathVariable Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    @PutMapping("/atualizar/{id}")
    public Tarefa atualizaTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        if (tarefaRepository.existsById(id)) {
            tarefa.setIdTarefa(id);
            return tarefaRepository.save(tarefa);
        } else {
            return null;
        }
    }

    @DeleteMapping("/remover/{id}")
    public void removeTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}
