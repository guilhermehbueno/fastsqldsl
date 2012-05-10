package com.fastsql.sql.builder.model.test;

import javax.persistence.Column;
import javax.persistence.Id;

public class Usuario {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="idade")
	private int idade;
	
	@Column(name="sobrenome")
	private String sobrenome;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}
	
	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
	
}
