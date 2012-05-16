package br.com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {
	@Id @GeneratedValue
	@Column(name="CATEGORIA_ID")
	private int codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@OneToMany(mappedBy="categoria")
	Collection<Subcategoria> subcategorias = new ArrayList<Subcategoria>();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
