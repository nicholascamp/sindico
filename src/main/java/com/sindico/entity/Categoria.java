package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Categoria.
 */
@Entity
@Table(name = "CATEGORIA")
public class Categoria {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "CATEGORIA_ID")
	private int codigo;

	/** The nome. */
	@Column(name = "NOME")
	private String nome;

	/** The subcategorias. */
	@OneToMany(mappedBy = "categoria")
	Collection<Subcategoria> subcategorias = new ArrayList<Subcategoria>();

	public Collection<Subcategoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(Collection<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	/**
	 * Gets the codigo.
	 * 
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 * 
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the nome.
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 * 
	 * @param nome
	 *            the new nome
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

}
