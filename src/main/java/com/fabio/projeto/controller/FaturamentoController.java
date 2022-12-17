package com.fabio.projeto.controller;

import java.math.BigDecimal;
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

import com.fabio.projeto.entidade.Cliente;
import com.fabio.projeto.entidade.Faturamento;
import com.fabio.projeto.entidade.Tecnico;
import com.fabio.projeto.repositories.ChamadoRepository;
import com.fabio.projeto.services.ClienteService;
import com.fabio.projeto.services.FaturamentoService;
import com.fabio.projeto.services.TecnicoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/faturamentos")
public class FaturamentoController {

	@Autowired
	private FaturamentoService service;

	@Autowired
	private ChamadoRepository chamdoRepository;

	@Autowired
	private TecnicoService tecnicoService;

	@Autowired
	private ClienteService clienteService;

	private BigDecimal valorTotal;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Faturamento> findById(@PathVariable Integer id) {
		Faturamento obj = this.service.findById(id);
		;

		Tecnico tec = tecnicoService.findById(obj.getIdTecnico());
		Cliente cliente = clienteService.findById(obj.getIdCliente());

		obj.setNomeCliente(cliente.getNome());
		obj.setNomeTecnico(tec.getNome());

		return ResponseEntity.ok().body((obj));
	}

	@GetMapping
	public ResponseEntity<List<Faturamento>> findAll() {
		List<Faturamento> listFaturamento = this.service.findAll();

		for (Faturamento faturamento : listFaturamento) {
			Tecnico tecnico = tecnicoService.findById(faturamento.getIdTecnico());
			Cliente cliente = clienteService.findById(faturamento.getIdCliente());

			faturamento.setNomeTecnico(tecnico.getNome());
			faturamento.setNomeCliente(cliente.getNome());
		}

		return ResponseEntity.ok().body(listFaturamento);
	}

	public ResponseEntity<BigDecimal> calcular(@RequestBody Faturamento faturamento) {
		valorTotal = new BigDecimal(0);
		List<BigDecimal> list = this.chamdoRepository.calcular(faturamento.getIdTecnico(), faturamento.getIdCliente(),
				faturamento.getDataInicioFaturamento(), faturamento.getDataFimFaturamento());

		for (BigDecimal item : list) {
			valorTotal = valorTotal.add(item);
		}
		return ResponseEntity.ok().body(valorTotal);
	}

	@PostMapping
	public ResponseEntity<Faturamento> create(@RequestBody Faturamento faturamento) {
		calcular(faturamento);
		faturamento.setValorTotal(valorTotal);
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

	public BigDecimal getValorCalculado() {
		return valorTotal;
	}

	public void setValorCalculado(BigDecimal valorCalculado) {
		this.valorTotal = valorCalculado;
	}

}
