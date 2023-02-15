package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fabio.projeto.enuns.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstoque;

	private String descricao;

	private Integer quantidade;

	private BigDecimal valorCompra;

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCompra = LocalDate.now();

	private Tipo tipo;
}
