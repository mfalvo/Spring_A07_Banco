package br.com.spring.banco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.banco.dto.TarefaDTO;
import br.com.spring.banco.model.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    
	@Query("SELECT t.idTarefa as idTarefa, t.titulo as titulo, t.estado as estado FROM Tarefa t")
	Iterable<Tarefa> findTarefas();

	// O resultado do JPQL cria objetos do tipo TarefaDTOImpl
	@Query("SELECT new br.com.spring.banco.dto.TarefaDTOImpl(t.idTarefa, t.titulo, t.estado) FROM Tarefa t")
	Iterable<TarefaDTO> findTarefasDTO();
}
