package com.fabio.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.projeto.entidade.Faturamento;
import com.fabio.projeto.repositories.FaturamentoRepository;

@Service
public class FaturamentoService {

	@Autowired
	private FaturamentoRepository repository;

	public Faturamento findById(Integer id) {
		Optional<Faturamento> obj = repository.findById(id);
		return obj.orElse(null);

	}

	public List<Faturamento> findAll() {
		return repository.findAll();
	}

	public Faturamento create(Faturamento faturamento) {
		Faturamento novoFaturamento = new Faturamento();
		return repository.save(faturamento);
	}

	public void delete(Integer id) {
		Faturamento obj = findById(id);
		repository.deleteById(id);
	}

}
