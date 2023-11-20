package br.com.spring.banco.dto;

import br.com.spring.banco.model.Tarefa;

// Interface DTO
public interface TarefaDTO {
	Long getIdTarefa();
    String getTitulo();
    Tarefa.Estado getEstado();
}
