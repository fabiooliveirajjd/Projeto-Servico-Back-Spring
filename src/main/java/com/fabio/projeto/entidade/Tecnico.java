package com.fabio.projeto.entidade;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTecnico;

	@Column
	private String nome;

//	@CPF
	@Column(unique = true)
	private String cpf;

	@Column(unique = true)
	private String email;

	@Column
	private String senha;

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public Tecnico() {
		super();
	}

	

	public Tecnico(Integer idTecnico, String nome) {
		super();
		this.idTecnico = idTecnico;
		this.nome = nome;
	}



	public Tecnico(Integer idTecnico, String nome, String cpf, String email, String senha) {
		super();
		this.idTecnico = idTecnico;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;

	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}