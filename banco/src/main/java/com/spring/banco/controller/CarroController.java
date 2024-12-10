package com.spring.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banco.model.Carro;
import com.spring.banco.repository.CarroRepository;

@RestController
//Mapeia esta classe de controle para o caminho '/carros'
@RequestMapping("/carros")
public class CarroController {

	// Injeção de dependência do repositório de carros
	@Autowired
	private CarroRepository carroRepository;

	// Endpoint para buscar todos os carros
	@GetMapping
	public Iterable<Carro> buscaCarros() {
		return carroRepository.findAll();
	}

	// Endpoint para buscar carro por ID
	@GetMapping("/{id}")
	public Carro buscaCarroPorId(@PathVariable Long id) {
		return carroRepository.findById(id).orElse(null);
	}

	// Endpoint para buscar carro por nome
	@GetMapping("/nome/{nome}")
	public Iterable<Carro> buscaCarroPorNome(@PathVariable String nome) {
		return carroRepository.findByNome(nome);
	}
	
	// Endpoint para buscar carro por nome
	@GetMapping("/cor/{cor}")
	public Iterable<Carro> buscaCarroPorCor(@PathVariable String cor) {
		return carroRepository.findByCor(cor);
	}

	// Endpoint para adicionar um novo carro
	@PostMapping
	public Carro adicionaCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}

	// Endpoint para atualizar um carro existente
	@PutMapping("/{id}")
	public Carro atualizaCarro(@PathVariable Long id, @RequestBody Carro carro) {
		// Define o ID do carro a ser atualizado
		carro.setId(id);

		// Salva o carro atualizado no repositório
		return carroRepository.save(carro);
	}

	// Endpoint para deletar um carro pelo ID
	@DeleteMapping("/{id}")
	public void deletaCarro(@PathVariable Long id) {
		// Remove o carro com o ID fornecido do repositório
		carroRepository.deleteById(id);
	}
}
