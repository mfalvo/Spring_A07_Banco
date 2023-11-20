// TarefaDTOImpl
package br.com.spring.banco.dto;

import br.com.spring.banco.model.Tarefa;

// Implementação da Interface TarefaDTO
public class TarefaDTOImpl implements TarefaDTO {
    private Long idTarefa;
    private String titulo;
    private Tarefa.Estado estado;

    // Construtor correspondente à consulta JPQL
    public TarefaDTOImpl(Long idTarefa, String titulo, Tarefa.Estado estado) {
        this.idTarefa = idTarefa;
        this.titulo = titulo;
        this.estado = estado;
    }

    @Override
    public Long getIdTarefa() {
        return idTarefa;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public Tarefa.Estado getEstado() {
        return estado;
    }
}
