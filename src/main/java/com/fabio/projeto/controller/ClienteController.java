package com.fabio.projeto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabio.projeto.entidade.Cliente;
import com.fabio.projeto.repositories.ClienteRepository;
import com.fabio.projeto.services.ClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/clientes") // localhost:8080/tecnicos
public class ClienteController {

	@Autowired
	private ClienteService service;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/teste/{nome}")
	public ResponseEntity<List<Cliente>> buscarPorNome(@PathVariable String nome) {
		List<Cliente> listClientes = this.clienteRepository.buscarPorNome(nome);
		return ResponseEntity.ok(listClientes);
	}

//	@GetMapping(value = "/teste1")
//	public ResponseEntity<List<Cliente>> buscarNome(@RequestParam("nome") String nome) {
//		List<Cliente> listClientes = this.clienteRepository.buscarNome(nome);
//		return ResponseEntity.ok().body(listClientes);
//	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> listClientes = this.service.findAll();
		return ResponseEntity.ok().body(listClientes);
	}

	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		Cliente novoCliente = this.service.create(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoCliente.getIdCliente()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Cliente obj = this.service.update(id, cliente);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
