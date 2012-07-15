package com.sindico.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Categoria.
 */
@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -7373446708020048049L;

	@Id
	@GeneratedValue
	@Column(name = "CATEGORIA_ID")
	private Long				id;

	/** The nome. */
	@Column(name = "NOME", length = 100, nullable = false, unique = true)
	@NotNull(message = "A Categorira necessita de um nome")
	private String				nome;

	/** The subcategorias. */
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
	Collection<Subcategoria>	subcategorias		= new ArrayList<Subcategoria>();

	/**
	 * Gets the subcategorias.
	 * 
	 * @return the subcategorias
	 */
	public Collection<Subcategoria> getSubcategorias() {
		return subcategorias;
	}

	/**
	 * Sets the subcategorias.
	 * 
	 * @param subcategorias
	 *            the new subcategorias
	 */
	public void setSubcategorias(final Collection<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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
