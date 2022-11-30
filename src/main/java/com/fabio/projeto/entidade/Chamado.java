package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fabio.projeto.enuns.Prioridade;
import com.fabio.projeto.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idChamado;

	@Column
	private Prioridade prioridade;

	@Column
	private Status status;

	@Column
	private String observacoes;

	@Column
	private String titulo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column
	private LocalDate dataAbertura = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column
	private LocalDate dataFechamento;

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Transient
	private String nomeCliente;
	
	@Transient
	private String nomeTecnico;

	@Column
	private BigDecimal valor;

	public Chamado() {
		super();
	}

	public Chamado(Chamado chamado) {
		this.idChamado = chamado.idChamado;
		this.prioridade = chamado.prioridade;
		this.status = chamado.status;
		this.observacoes = chamado.observacoes;
		this.titulo = chamado.titulo;
		this.dataAbertura = chamado.dataAbertura;
		this.dataFechamento = chamado.dataFechamento;
		this.tecnico = chamado.tecnico;
		this.cliente = chamado.cliente;
		this.nomeCliente = chamado.cliente.getNome();
		this.nomeTecnico = chamado.tecnico.getNome();
		this.valor = chamado.valor;
	}

	public Integer getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Integer idChamado) {
		this.idChamado = idChamado;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
