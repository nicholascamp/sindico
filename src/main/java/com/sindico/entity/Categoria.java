package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.NotNull;

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
	private int					codigo;

	/** The nome. */
	@Column(name = "NOME", length = 100, nullable=false, unique= true)
	@NotNull(message="A Categorira necessita de um nome")
	private String				nome;

	/** The subcategorias. */
	@Transient
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
	Collection<Subcategoria>	subcategorias	= new ArrayList<Subcategoria>();

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
