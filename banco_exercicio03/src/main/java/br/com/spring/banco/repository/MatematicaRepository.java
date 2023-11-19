package br.com.spring.banco.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.spring.banco.model.Matematica;


public interface MatematicaRepository extends CrudRepository<Matematica, Long> {
	
	/**
	 * Pageable é uma interface fornecida pelo Spring Framework para suportar paginação em consultas.
	 * Ele é comumente usado em métodos de consulta em repositórios Spring Data JPA para permitir a 
	 * recuperação de um subconjunto paginado de resultados.
 	 *
	 * Quando você utiliza Pageable como parâmetro em um método de consulta, você pode especificar 
	 * detalhes sobre a paginação, como o número da página, o tamanho da página, a ordenação, etc. 
	 * Isso é útil quando você tem grandes conjuntos de dados e deseja recuperar apenas uma parte de cada vez.
	 *	
	 * Aqui estão alguns dos métodos importantes disponíveis em Pageable:
	 *	
	 * getPageNumber(): Retorna o número da página a ser recuperada (começando do zero).
	 * getPageSize(): Retorna o tamanho da página, ou seja, o número máximo de itens na página.
	 * getSort(): Retorna a configuração de ordenação para a página.
	 * 
	 * Ao usar Pageable em consultas JPA, o Spring Data JPA se encarrega de traduzir essas informações 
	 * de paginação para as cláusulas SQL adequadas, garantindo que apenas os resultados necessários 
	 * sejam recuperados do banco de dados.
	 */
	@Query("SELECT m FROM Matematica m")
	Page<Matematica> findOperacoes(Pageable pageable);
	
}
