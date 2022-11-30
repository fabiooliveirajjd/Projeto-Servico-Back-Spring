package com.fabio.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.projeto.entidade.Tecnico;
import com.fabio.projeto.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);

	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(Tecnico tecnico) {
		Tecnico novoTecnico = new Tecnico();
		return repository.save(tecnico);
	}

	public Tecnico update(Integer id, Tecnico tecnico) {
		Tecnico oldObj = findById(id);
		oldObj = new Tecnico();
		return repository.save(tecnico);
	}

		public void delete(Integer id) {
			Tecnico obj = findById(id);
			repository.deleteById(id);
			
		}

		
	}

