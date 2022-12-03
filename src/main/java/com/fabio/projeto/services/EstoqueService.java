package com.fabio.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.projeto.entidade.Estoque;
import com.fabio.projeto.repositories.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repository;

	public Estoque findById(Integer id) {
		Optional<Estoque> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Estoque> findAll() {
		return repository.findAll();
	}

	public Estoque create(Estoque estoque) {
		Estoque novoEstoque = new Estoque();
		return repository.save(estoque);
	}

	public Estoque update(Integer id, Estoque estoque) {
		Estoque oldObj = findById(id);
		oldObj = new Estoque();
		return repository.save(estoque);
	}

}
