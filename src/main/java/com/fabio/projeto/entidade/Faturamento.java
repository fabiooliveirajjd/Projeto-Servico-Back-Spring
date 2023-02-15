package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faturamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFaturamento;

	private BigDecimal valorTotal;

	private Integer idTecnico;

	private Integer idCliente;

	private Date dataInicioFaturamento;

	private Date dataFimFaturamento;

	@Transient
	private String nomeCliente;

	@Transient
	private String nomeTecnico;

}