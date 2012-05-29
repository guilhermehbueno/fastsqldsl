package com.fastsql.sql.builder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idUsuario")
	private String idUsuario;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="status")
	private String status;
	
	@Column(name="observacao")
	private String observacao;
	
	@Column(name="id_origem")
	private String origemId;
	
	@Column(name="origem")
	private String origemNome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;

	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getOrigemId() {
		return origemId;
	}
	public void setOrigemId(String origemId) {
		this.origemId = origemId;
	}
	public String getOrigemNome() {
		return origemNome;
	}
	public void setOrigemNome(String origemNome) {
		this.origemNome = origemNome;
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
