package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	
	@Column
	private Prioridade prioridade;
	
	@Column
	private Status status;
	
	@Column
	private String observacoes;
	
	@Column
	private String titulo;

	@Column
	private BigDecimal valor;

	@Column
	private Integer idTecnico;

	@Column
	private Integer idCliente;   
	
	@Transient
	private String nomeTecnico;

	@Transient
	private String nomeCliente;
	
	
	public Chamado() {
		super();
	}

	public Chamado(Integer idChamado, Prioridade prioridade, Status status, String observacoes, String titulo,
			BigDecimal valor, Integer idTecnico, Integer idCliente) {
		super();
		this.idChamado = idChamado;
		this.prioridade = prioridade;
		this.status = status;
		this.observacoes = observacoes;
		this.titulo = titulo;
		this.valor = valor;
		this.idTecnico = idTecnico;
		this.idCliente = idCliente;
	}

	public Integer getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Integer idChamado) {
		this.idChamado = idChamado;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
  
	
}
