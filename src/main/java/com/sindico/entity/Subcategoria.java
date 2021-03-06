package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 * The Class Subcategoria.
 */
@Entity
@Table(name = "SUBCATEGORIA")
public class Subcategoria {

	@Id
	@GeneratedValue
	@Column(name = "SUBCATEGORIA_ID")
	private Long					id;

	/** The categoria. */
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_ID")
	@NotNull(message = "Subcategoria deve pertencer a uma Categoria")
	private Categoria				categoria;

	/** The title. */
	@Column(name = "TITLE", length = 200, nullable = false, unique = true)
	private String					title;

	@ManyToMany(mappedBy = "subcategorias")
	private Collection<Fornecedor>	fornecedores	= new ArrayList<Fornecedor>();

	@OneToMany(mappedBy = "subcategoria")
	private Collection<Cotacao>		cotacoes		= new ArrayList<Cotacao>();

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the categoria.
	 * 
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Sets the categoria.
	 * 
	 * @param categoria
	 *            the new categoria
	 */
	public void setCategoria(final Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	public void setFornecedores(final Collection<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Collection<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(final Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.title;
	}

}
