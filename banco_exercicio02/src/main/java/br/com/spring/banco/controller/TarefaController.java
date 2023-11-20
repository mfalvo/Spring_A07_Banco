package br.com.spring.banco.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.spring.banco.dto.TarefaDTO;
import br.com.spring.banco.model.Tarefa;
import br.com.spring.banco.model.Tarefa.Prioridade;
import br.com.spring.banco.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/criar")
    public Tarefa criaTarefa(@RequestBody Tarefa tarefa) {
    	tarefa.setDataCriacao(new Date());
    	tarefa.setEstado(Tarefa.Estado.A_FAZER);
    	tarefa.setPrioridade(Prioridade.MEDIA);
    	
        return tarefaRepository.save(tarefa);
    }

    @GetMapping
    public Iterable<Tarefa> consultaTarefas() {
        System.out.println(tarefaRepository.findTarefas());
    	return tarefaRepository.findTarefas();
    }
    
    @GetMapping("/DTO")
    public Iterable<TarefaDTO> consultaTarefasDTO() {
        System.out.println(tarefaRepository.findTarefasDTO());
    	return tarefaRepository.findTarefasDTO();
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
    
    @PutMapping("/finalizar/{id}")
    public Tarefa finalizaTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        if (tarefaRepository.existsById(id)) {
            tarefa.setIdTarefa(id);
            tarefa.setEstado(Tarefa.Estado.CONCLUIDA);
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
