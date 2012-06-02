package com.sindico.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 * The Class Subcategoria.
 */
@Entity
@Table(name = "SUBCATEGORIA")
public class Subcategoria {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "SUBCATEGORIA_ID")
	private Long		codigo;

	/** The categoria. */
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_ID")
	@NotNull(message = "Subcategoria deve pertencer a uma Categoria")
	private Categoria	categoria;

	/** The title. */
	@Column(name = "TITLE", length = 200, nullable = false, unique = true)
	private String		title;

	/**
	 * Gets the codigo.
	 * 
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 * 
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
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

}
