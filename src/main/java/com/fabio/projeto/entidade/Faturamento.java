package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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

	@Column
	private Date dataInicioFaturamento;

	@Column
	private Date dataFimFaturamento;

	@Transient
	private String nomeCliente;

	@Transient
	private String nomeTecnico;

	public Faturamento() {
		super();
	}

	public Faturamento(Integer idFaturamento, BigDecimal valorTotal, Integer idTecnico, Integer idCliente,
			Date dataInicioFaturamento, Date dataFimFaturamento) {
		super();
		this.idFaturamento = idFaturamento;
		this.valorTotal = valorTotal;
		this.idTecnico = idTecnico;
		this.idCliente = idCliente;
		this.dataInicioFaturamento = dataInicioFaturamento;
		this.dataFimFaturamento = dataFimFaturamento;
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

	public Date getDataInicioFaturamento() {
		return dataInicioFaturamento;
	}

	public void DataInicioFaturamento(Date dataInicioFaturamento) {
		this.dataInicioFaturamento = dataInicioFaturamento;
	}

	public Date getDataFimFaturamento() {
		return dataFimFaturamento;
	}

	public void DataFimFaturamento(Date dataFimFaturamento) {
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