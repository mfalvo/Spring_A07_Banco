package com.spring.banco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.spring.banco.model.Carro;

//Interface que estende (herança) CrudRepository para a entidade Carro

/**
 *  CrudRepository é uma interface genérica que fornece métodos CRUD (Create, Read, Update, Delete) básicos para entidades. 
 *  Ele estende a interface  Repository e,  por  padrão,  herda  métodos  comuns,  como save,  findById,  delete,  findAll, 
 *  entre outros, permitindo realizar operações básicas em um banco de dados.
 *
 *	Por exemplo, suponha que você tenha uma entidade chamada Carro.  Ao  estender  a interface CrudRepository<Carro, Long>,
 *  você pode acessar métodos prontos para serem usados:
 *
 *	save(Carro carro): Salva um novo carro no banco de dados ou atualiza um carro existente.
 *	findById(Long id): Busca um carro pelo seu ID.
 *	delete(Carro carro): Remove um carro do banco de dados.
 *	findAll(): Retorna todos os carros existentes.
 */
public interface CarroRepository extends CrudRepository<Carro, Long> {
	
	// Define a consulta personalizada para encontrar carros pelo nome
    @Query("SELECT c FROM Carro c WHERE c.nome LIKE %:nome%")
	Iterable<Carro> findByNome(String nome);
}
