package com.fastsql.sql.builder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idEndereco")
	private String idEndereco;
	
	@Column(name="idUsuario")
	private String idUsuario;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="tipoEndereco")
	private String tipoEndereco;
	
	@Column(name="identificacao")
	private String identificacao;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sobreNome")
	private String sobreNome;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="pais")
	private String pais;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="referencia")
	private String referencia;

	public String getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", idUsuario="
				+ idUsuario + ", cep=" + cep + ", tipoEndereco=" + tipoEndereco
				+ ", identificacao=" + identificacao + ", nome=" + nome
				+ ", sobreNome=" + sobreNome + ", endereco=" + endereco
				+ ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", pais="
				+ pais + ", telefone=" + telefone + ", referencia="
				+ referencia + "]";
	}
}
