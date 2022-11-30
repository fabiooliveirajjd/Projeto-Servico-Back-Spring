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

import com.fabio.projeto.entidade.Tecnico;
import com.fabio.projeto.services.TecnicoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/tecnicos") // localhost:8080/tecnicos
public class TecnicoController {

	@Autowired
	private TecnicoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
		Tecnico obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Tecnico>> findAll(){
		List<Tecnico> listTecnico = this.service.findAll();
		return ResponseEntity.ok().body(listTecnico);
		}

	@PostMapping
	public ResponseEntity<Tecnico> create(@RequestBody Tecnico tecnico){
		Tecnico novoTecnico = this.service.create(tecnico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(novoTecnico.getIdTecnico()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tecnico> update(@PathVariable Integer id,@RequestBody Tecnico tecnico){
	Tecnico obj  = this.service.update(id, tecnico);
	return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Tecnico> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}





















