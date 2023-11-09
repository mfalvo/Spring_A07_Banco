package br.com.spring.banco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.spring.banco.model.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    
	@Query("SELECT t.idTarefa, t.titulo, t.estado FROM Tarefa t")
	Iterable<Tarefa> findTarefas();
}
