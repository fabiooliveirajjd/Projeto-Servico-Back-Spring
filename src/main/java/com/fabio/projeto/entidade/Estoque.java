package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fabio.projeto.enuns.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Estoque implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstoque;
	
	@Column
	private String descricao;
	
	@Column
	private Integer quantidade;
	
	@Column
	private BigDecimal valorCompra;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCompra = LocalDate.now();
	
	@Column
	private Tipo tipo;

	public Estoque() {
		super();
	}

	public Estoque(Integer idEstoque, String descricao, Integer quantidade, BigDecimal valorCompra, Tipo tipo) {
		super();
		this.idEstoque = idEstoque;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorCompra = valorCompra;
		this.tipo = tipo;
	}

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCompra, descricao, idEstoque, quantidade, tipo, valorCompra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		return Objects.equals(dataCompra, other.dataCompra) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(idEstoque, other.idEstoque) && Objects.equals(quantidade, other.quantidade)
				&& tipo == other.tipo && Objects.equals(valorCompra, other.valorCompra);
	}

	
	
}
