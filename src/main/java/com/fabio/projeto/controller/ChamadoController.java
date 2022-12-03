package com.fabio.projeto.controller;

import java.net.URI;
import java.time.LocalDate;
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
import com.fabio.projeto.enuns.Status;
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
		Chamado obj = ((ChamadoService) this.service).findById(id);

		Tecnico tec = tecService.findById(obj.getIdTecnico());
		Cliente cliente = cliService.findById(obj.getIdCliente());

		obj.setNomeCliente(cliente.getNome());
		obj.setNomeTecnico(tec.getNome());

		return ResponseEntity.ok().body((obj));
	}

	@GetMapping
	public ResponseEntity<List<Chamado>> findAll() {
		List<Chamado> listChamado = this.service.findAll();

		for (Chamado item : listChamado) {

			Tecnico tec = tecService.findById(item.getIdTecnico());
			Cliente cliente = cliService.findById(item.getIdCliente());

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
		if (chamado.getStatus().equals(Status.ENCERRADO)) {
			chamado.setDataFechamento(LocalDate.now());
		}

		Chamado obj = this.service.update(id, chamado);

		Tecnico tec = tecService.findById(obj.getIdTecnico());
		Cliente cliente = cliService.findById(obj.getIdCliente());

		obj.setNomeCliente(cliente.getNome());
		obj.setNomeTecnico(tec.getNome());

		return ResponseEntity.ok().body((obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Chamado> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
