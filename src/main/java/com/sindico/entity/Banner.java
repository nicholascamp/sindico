/*
 * 
 */
package com.sindico.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Banner.
 */
@Entity
@Table(name = "BANNER")
public class Banner {

	/** The codigo. */
	@Id
	@GeneratedValue
	private Long	id;

	/** The data. */
	private Date	data;

	/** The arquivo img. */
	private String	arquivoImg;

	/** The descricao. */
	private String	descricao;

	/** The margin up. */
	private float	marginUp;

	/** The margin left. */
	private float	marginLeft;

	/** The link. */
	private String	link;

	/** The contador. */
	private int		contador;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Sets the data.
	 * 
	 * @param data
	 *            the new data
	 */
	public void setData(final Date data) {
		this.data = data;
	}

	/**
	 * Gets the arquivo img.
	 * 
	 * @return the arquivo img
	 */
	public String getArquivoImg() {
		return arquivoImg;
	}

	/**
	 * Sets the arquivo img.
	 * 
	 * @param arquivoImg
	 *            the new arquivo img
	 */
	public void setArquivoImg(final String arquivoImg) {
		this.arquivoImg = arquivoImg;
	}

	/**
	 * Gets the descricao.
	 * 
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Sets the descricao.
	 * 
	 * @param descricao
	 *            the new descricao
	 */
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Gets the margin up.
	 * 
	 * @return the margin up
	 */
	public float getMarginUp() {
		return marginUp;
	}

	/**
	 * Sets the margin up.
	 * 
	 * @param marginUp
	 *            the new margin up
	 */
	public void setMarginUp(final float marginUp) {
		this.marginUp = marginUp;
	}

	/**
	 * Gets the margin left.
	 * 
	 * @return the margin left
	 */
	public float getMarginLeft() {
		return marginLeft;
	}

	/**
	 * Sets the margin left.
	 * 
	 * @param marginLeft
	 *            the new margin left
	 */
	public void setMarginLeft(final float marginLeft) {
		this.marginLeft = marginLeft;
	}

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the link.
	 * 
	 * @param link
	 *            the new link
	 */
	public void setLink(final String link) {
		this.link = link;
	}

	/**
	 * Gets the contador.
	 * 
	 * @return the contador
	 */
	public int getContador() {
		return contador;
	}

	/**
	 * Sets the contador.
	 * 
	 * @param contador
	 *            the new contador
	 */
	public void setContador(final int contador) {
		this.contador = contador;
	}

}
