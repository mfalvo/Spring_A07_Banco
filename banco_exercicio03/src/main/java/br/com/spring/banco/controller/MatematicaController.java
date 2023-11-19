package br.com.spring.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.banco.model.Matematica;
import br.com.spring.banco.repository.MatematicaRepository;

@RestController
@RequestMapping("/math")
public class MatematicaController {
	
	@Autowired
	private MatematicaRepository matematicaRepository;

	@GetMapping("/adicao/{num1}/{num2}")
	public Matematica adicao(@PathVariable double num1, @PathVariable double num2) {
	    Matematica matematica = new Matematica();
	    matematica.setNumero1(num1);
	    matematica.setNumero2(num2);
	    matematica.setOperacao("adicao");
	    matematica.setResultado(num1+num2);
	    return matematicaRepository.save(matematica);
	}
	
	@GetMapping("/subtracao/{num1}/{num2}")
	public Matematica subtracao(@PathVariable double num1, @PathVariable double num2) {
	    Matematica matematica = new Matematica();
	    matematica.setNumero1(num1);
	    matematica.setNumero2(num2);
	    matematica.setOperacao("subtracao");
	    matematica.setResultado(num1-num2);
	    return matematicaRepository.save(matematica);
	}
	
	@GetMapping("/divisao/{num1}/{num2}")
	public Matematica divisao(@PathVariable double num1, @PathVariable double num2) {
	    Matematica matematica = new Matematica();
	    matematica.setNumero1(num1);
	    matematica.setNumero2(num2);
	    matematica.setOperacao("divisao");
	    matematica.setResultado(num1/num2);
	    return matematicaRepository.save(matematica);
	}
	
	@GetMapping("/multiplicacao/{num1}/{num2}")
	public Matematica multiplicacao(@PathVariable double num1, @PathVariable double num2) {
	    Matematica matematica = new Matematica();
	    matematica.setNumero1(num1);
	    matematica.setNumero2(num2);
	    matematica.setOperacao("multiplicacao");
	    matematica.setResultado(num1*num2);
	    return matematicaRepository.save(matematica);
	}
	
	@GetMapping("/historico")
	public Iterable<Matematica> getHistorico(){
		return matematicaRepository.findAll();
	}
	
	@GetMapping("/historico/{qtd}")
	public Iterable<Matematica> getHistorico(@PathVariable int qtd){
		/**
		 * PageRequest.of(0, qtd): Isso está criando um objeto PageRequest para representar a solicitação 
		 * de uma página específica de resultados. No caso, está pedindo a primeira página (índice 0) com
		 * um número específico de itens por página, que é determinado pelo valor de qtd.
		 */
		return matematicaRepository.findOperacoes(PageRequest.of(0, qtd));
	}
}
