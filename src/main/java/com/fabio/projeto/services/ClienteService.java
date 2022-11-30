package com.fabio.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.projeto.entidade.Cliente;
import com.fabio.projeto.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElse(null);

	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(Cliente cliente) {
		Cliente novoCliente = new Cliente();
		return repository.save(cliente);
	}

	public Cliente update(Integer id, Cliente cliente) {
		Cliente oldObj = findById(id);
		oldObj = new Cliente();
		return repository.save(cliente);
	}

		public void delete(Integer id) {
			Cliente obj = findById(id);
			repository.deleteById(id);
			
		}
	}

