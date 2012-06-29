package com.fastsql.sql.builder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="pagina")
public class Pagina {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="idPagina")
	private String id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="tituloResumido")
	private String tituloResumido;
	
	@Column(name="conteudo")
	private String conteudo;
	
	@Column(name="conteudoResumido")
	private String conteudoResumido;
	
	@Enumerated
	@Column(name="status")
	private PaginaStatusEnum status;
	
	@Enumerated
	@Column(name="tipo")
	private PaginaTipoEnum tipo;
	
	@Column(name="pai")
	private Pagina pai;
	
	@OneToMany
	@JoinColumn(table="pagina", referencedColumnName="pai")
	private List<Pagina> paginas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTituloResumido() {
		return tituloResumido;
	}

	public void setTituloResumido(String tituloResumido) {
		this.tituloResumido = tituloResumido;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getConteudoResumido() {
		return conteudoResumido;
	}

	public void setConteudoResumido(String conteudoResumido) {
		this.conteudoResumido = conteudoResumido;
	}

	public Pagina getPai() {
		return pai;
	}

	public void setPai(Pagina pai) {
		this.pai = pai;
	}

	public PaginaStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PaginaStatusEnum status) {
		this.status = status;
	}

	public PaginaTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(PaginaTipoEnum tipo) {
		this.tipo = tipo;
	}
	
	public List<Pagina> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Pagina [id=" + id + ", titulo=" + titulo + ", tituloResumido="
				+ tituloResumido + ", conteudo=" + conteudo
				+ ", conteudoResumido=" + conteudoResumido + ", status="
				+ status + ", tipo=" + tipo + ", pai=" + pai + "]";
	}
}
