package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Administradora.
 */
@Entity
@Table(name = "ADMINISTRADORA")
public class Administradora {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "ADMINISTRADORA_ID")
	private int codigo;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;

	/** The cnpj. */
	@Column(name = "CNJPJ", length = 20)
	private String cnpj;

	/** The enderecos. */
	@ElementCollection
	@JoinTable(name = "ENDERECO", joinColumns = @JoinColumn(name = "ADMINISTRADORA_ID"))
	private Collection<Endereco> enderecos = new ArrayList<Endereco>();

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20)
	private String telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String celular;

	/** The fax. */
	@Column(name = "FAX", length = 20)
	private String fax;

	/** The telefone comercial. */
	@Column(name = "TELEFONE_COMERCIAL", length = 20)
	private String telefoneComercial;

	/** The gerentes. */
	@OneToMany(mappedBy = "administradora")
	private Collection<GerenteAdministradora> gerentes = new ArrayList<GerenteAdministradora>();

	/** The cotacoes. */
	@OneToMany(mappedBy = "administradora")
	private Collection<Cotacao> cotacoes = new ArrayList<Cotacao>();

	/**
	 * Gets the cotacoes.
	 * 
	 * @return the cotacoes
	 */
	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	/**
	 * Sets the cotacoes.
	 * 
	 * @param cotacoes
	 *            the new cotacoes
	 */
	public void setCotacoes(final Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
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
	 * Gets the data cadastro.
	 * 
	 * @return the data cadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * Sets the data cadastro.
	 * 
	 * @param dataCadastro
	 *            the new data cadastro
	 */
	public void setDataCadastro(final Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * Gets the cnpj.
	 * 
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Sets the cnpj.
	 * 
	 * @param cnpj
	 *            the new cnpj
	 */
	public void setCnpj(final String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Gets the enderecos.
	 * 
	 * @return the enderecos
	 */
	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * Sets the enderecos.
	 * 
	 * @param enderecos
	 *            the new enderecos
	 */
	public void setEnderecos(final Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * Gets the telefone.
	 * 
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 * 
	 * @param telefone
	 *            the new telefone
	 */
	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Gets the celular.
	 * 
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Sets the celular.
	 * 
	 * @param celular
	 *            the new celular
	 */
	public void setCelular(final String celular) {
		this.celular = celular;
	}

	/**
	 * Gets the fax.
	 * 
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the fax.
	 * 
	 * @param fax
	 *            the new fax
	 */
	public void setFax(final String fax) {
		this.fax = fax;
	}

	/**
	 * Gets the telefone comercial.
	 * 
	 * @return the telefone comercial
	 */
	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	/**
	 * Sets the telefone comercial.
	 * 
	 * @param telefoneComercial
	 *            the new telefone comercial
	 */
	public void setTelefoneComercial(final String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	/**
	 * Gets the gerentes.
	 * 
	 * @return the gerentes
	 */
	public Collection<GerenteAdministradora> getGerentes() {
		return gerentes;
	}

	/**
	 * Sets the gerentes.
	 * 
	 * @param gerentes
	 *            the new gerentes
	 */
	public void setGerentes(final Collection<GerenteAdministradora> gerentes) {
		this.gerentes = gerentes;
	}

}
