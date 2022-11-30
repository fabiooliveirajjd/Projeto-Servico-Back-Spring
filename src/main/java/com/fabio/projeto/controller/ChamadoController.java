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

import com.fabio.projeto.entidade.Chamado;
import com.fabio.projeto.entidade.Cliente;
import com.fabio.projeto.entidade.Tecnico;
import com.fabio.projeto.services.ChamadoService;
import com.fabio.projeto.services.ClienteService;
import com.fabio.projeto.services.TecnicoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/chamados") // localhost:8080/chamados
public class ChamadoController {

	@Autowired
	private ChamadoService service;

	@Autowired
	private TecnicoService tecService;

	@Autowired
	private ClienteService cliService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Chamado> findById(@PathVariable Integer id) {
		Chamado obj = this.service.findById(id);
		return ResponseEntity.ok().body((obj));
	}

	@GetMapping
	public ResponseEntity<List<Chamado>> findAll() {
		List<Chamado> listChamado = this.service.findAll();
		
		for (Chamado item : listChamado) {
			
			Tecnico tec = tecService.findById(item.getTecnico().getIdTecnico());
			Cliente cliente = cliService.findById(item.getCliente().getIdCliente());
			
			item.setNomeCliente(cliente.getNome());
			item.setNomeTecnico(tec.getNome());
		}
		
		return ResponseEntity.ok().body(listChamado);
	}

	@PostMapping
	public ResponseEntity<Chamado> create(@RequestBody Chamado chamado) {
		Chamado novoChamado = this.service.create(chamado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoChamado.getIdChamado()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Chamado> update(@PathVariable Integer id, @RequestBody Chamado chamado) {
		Chamado obj = this.service.update(id, chamado);
		return ResponseEntity.ok().body((obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Chamado> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
}
