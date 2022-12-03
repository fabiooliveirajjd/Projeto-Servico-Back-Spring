package com.fabio.projeto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabio.projeto.entidade.Estoque;
import com.fabio.projeto.services.EstoqueService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/estoques")
public class EstoqueController {

	@Autowired
	private EstoqueService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estoque> findById(@PathVariable Integer id) {
		Estoque obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Estoque>> findAll() {
		List<Estoque> listEstoque = this.service.findAll();
		return ResponseEntity.ok().body(listEstoque);
	}

	@PostMapping
	public ResponseEntity<Estoque> create(@RequestBody Estoque estoque) {
		Estoque novoEstoque = this.service.create(estoque);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoEstoque.getIdEstoque()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Estoque> update(@PathVariable Integer id,@RequestBody Estoque estoque){
		Estoque obj  = this.service.update(id, estoque);
	return ResponseEntity.ok().body(obj);
	}

}
