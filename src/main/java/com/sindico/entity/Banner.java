/*
 * 
 */
package com.sindico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Banner.
 */
@Entity
@Table(name = "BANNER")
public class Banner {

	@Id
	@GeneratedValue
	private Long			id;

	/** The data. */
	@Column(name = "DATA")
	private Date			data;

	/** The arquivo img. */
	@Column(name = "ARQUIVO_IMG")
	private String			arquivoImg;

	/** The descricao. */
	@Column(name = "DESCRICAO", nullable = false)
	private String			descricao;

	/** The margin up. */
	@Column(name = "MARGIN_X", nullable = false)
	private float			marginX;

	/** The margin left. */
	@Column(name = "MARGIN_Y", nullable = false)
	private float			marginY;

	/** The link. */
	@Column(name = "LINK", nullable = false)
	private String			link;

	/** The contador. */
	@Column(name = "CONTADOR")
	private int				contador;

	@ManyToOne
	@JoinColumn(name = "SUBCATEGORIA_ID")
	private Subcategoria	subcategoria;

	@Column(name = "TIPO")
	private char			tipo;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public String getArquivoImg() {
		return arquivoImg;
	}

	public void setArquivoImg(final String arquivoImg) {
		this.arquivoImg = arquivoImg;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public float getMarginX() {
		return marginX;
	}

	public void setMarginX(final float marginX) {
		this.marginX = marginX;
	}

	public float getMarginY() {
		return marginY;
	}

	public void setMarginY(final float marginY) {
		this.marginY = marginY;
	}

	public String getLink() {
		return link;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(final int contador) {
		this.contador = contador;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(final Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(final char tipo) {
		this.tipo = tipo;
	}

}