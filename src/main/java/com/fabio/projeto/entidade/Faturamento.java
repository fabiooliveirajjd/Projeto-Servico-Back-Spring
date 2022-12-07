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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Faturamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFaturamento;

	@Column
	private BigDecimal valorTotal;

	@Column
	private Integer idTecnico;

	@Column
	private Integer idCliente;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicioFaturamento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFimFaturamento;

	@Transient
	private String nomeCliente;

	@Transient
	private String nomeTecnico;

	public Faturamento() {
		super();
	}

	public Faturamento(Integer idFaturamento, BigDecimal valorTotal, Integer idTecnico, Integer idCliente,
			String nomeCliente, String nomeTecnico) {
		super();
		this.idFaturamento = idFaturamento;
		this.valorTotal = valorTotal;
		this.idTecnico = idTecnico;
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.nomeTecnico = nomeTecnico;
	}

	public Integer getIdFaturamento() {
		return idFaturamento;
	}

	public void setIdFaturamento(Integer idFaturamento) {
		this.idFaturamento = idFaturamento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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

	public LocalDate getDataInicioFaturamento() {
		return dataInicioFaturamento;
	}

	public void setDataInicioFaturamento(LocalDate dataInicioFaturamento) {
		this.dataInicioFaturamento = dataInicioFaturamento;
	}

	public LocalDate getDataFimFaturamento() {
		return dataFimFaturamento;
	}

	public void setDataFimFaturamento(LocalDate dataFimFaturamento) {
		this.dataFimFaturamento = dataFimFaturamento;
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

}
