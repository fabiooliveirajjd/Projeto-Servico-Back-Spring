package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fabio.projeto.enuns.Prioridade;
import com.fabio.projeto.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

	private Prioridade prioridade;

	private Status status;

	private String observacoes;

	private String titulo;

	private BigDecimal valor;

	private Integer idTecnico;

	private Integer idCliente;

	@Transient
	private String nomeTecnico;

	@Transient
	private String nomeCliente;
}
