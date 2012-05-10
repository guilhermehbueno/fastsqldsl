package com.fastsql.sql.builder.model.test;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="menu")
public class Menu {
	
	@Id
	private int id;
	
	@Column(name="label")
	private String label;
	
	@Column(name="link")
	private String link;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private MenuStatusEnum status;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo")
	private MenuTipoEnum tipo;
	
	@OneToMany
	@JoinColumn(table="menu", referencedColumnName="pai")
	private List<Menu> menu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public MenuStatusEnum getStatus() {
		return status;
	}

	public void setStatus(MenuStatusEnum status) {
		this.status = status;
	}

	public MenuTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(MenuTipoEnum tipo) {
		this.tipo = tipo;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
}
