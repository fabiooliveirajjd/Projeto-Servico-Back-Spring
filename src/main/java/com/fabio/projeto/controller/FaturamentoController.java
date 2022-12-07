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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabio.projeto.entidade.Faturamento;
import com.fabio.projeto.services.FaturamentoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/faturamentos")
public class FaturamentoController {

	@Autowired
	private FaturamentoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Faturamento> findById(@PathVariable Integer id) {
		Faturamento obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Faturamento>> findAll() {
		List<Faturamento> listFaturamento = this.service.findAll();
		return ResponseEntity.ok().body(listFaturamento);
	}

	@PostMapping
	public ResponseEntity<Faturamento> create(@RequestBody Faturamento faturamento) {
		Faturamento novoFaturamento = this.service.create(faturamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoFaturamento.getIdFaturamento()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Faturamento> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
