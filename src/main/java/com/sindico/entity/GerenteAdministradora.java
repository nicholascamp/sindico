package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class GerenteAdministradora.
 */
@Entity
@Table(name = "GERENTE_ADMINISTRADORA")
public class GerenteAdministradora {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "GERENTE_ID")
	private int					codigo;

	/** The administradora. */
	@ManyToOne
	@JoinColumn(name = "ADMINISTRADORA_ID")
	private Administradora		administradora;

	/** The predios. */
	@OneToMany(mappedBy = "gerente")
	private Collection<Predio>	predios		= new ArrayList<Predio>();

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date				dataCadastro;

	/** The nome. */
	@Column(name = "NOME")
	private String				nome;

	/** The sobrenome. */
	@Column(name = "SOBRENOME")
	private String				sobrenome;

	/** The email. */
	@Column(name = "EMAIL")
	private String				email;

	/** The telefone. */
	@Column(name = "TELEFONE")
	private String				telefone;

	/** The celular. */
	@Column(name = "CELULAR")
	private String				celular;

	/** The fax. */
	@Column(name = "FAX")
	private String				fax;

	/** The telefone comercial. */
	@Column(name = "TELEFONE_COMERCIAL")
	private String				telefoneComercial;

	/** The recebe cotacao predios. */
	// @OneToMany(mappedBy = "gerenteRecebeCotacao")
	// private Collection<Boolean> recebeCotacaoPredios; // TIRAR
	// DUVIDA
	// E
	// REVER

	/** The recebe email mkt. */
	@Column(name = "RECEBE_EMAIL_MKT")
	private boolean				recebeEmailMkt;

	/** The senha. */
	@Column(name = "SENHA")
	private String				senha;

	/** The cotacoes. */
	@OneToMany(mappedBy = "gerenteAdmin")
	private Collection<Cotacao>	cotacoes	= new ArrayList<Cotacao>();

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
	 * Gets the administradora.
	 * 
	 * @return the administradora
	 */
	public Administradora getAdministradora() {
		return administradora;
	}

	/**
	 * Sets the administradora.
	 * 
	 * @param administradora
	 *            the new administradora
	 */
	public void setAdministradora(final Administradora administradora) {
		this.administradora = administradora;
	}

	/**
	 * Gets the predios.
	 * 
	 * @return the predios
	 */
	public Collection<Predio> getPredios() {
		return predios;
	}

	/**
	 * Sets the predios.
	 * 
	 * @param predios
	 *            the new predios
	 */
	public void setPredios(final Collection<Predio> predios) {
		this.predios = predios;
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

	/**
	 * Gets the sobrenome.
	 * 
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Sets the sobrenome.
	 * 
	 * @param sobrenome
	 *            the new sobrenome
	 */
	public void setSobrenome(final String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(final String email) {
		this.email = email;
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

	// /**
	// * Gets the recebe cotacao predios.
	// *
	// * @return the recebe cotacao predios
	// */
	// public Collection<Boolean> getRecebeCotacaoPredios() {
	// return recebeCotacaoPredios;
	// }
	//
	// /**
	// * Sets the recebe cotacao predios.
	// *
	// * @param recebeCotacaoPredios
	// * the new recebe cotacao predios
	// */
	// public void setRecebeCotacaoPredios(
	// final Collection<Boolean> recebeCotacaoPredios) {
	// this.recebeCotacaoPredios = recebeCotacaoPredios;
	// }

	/**
	 * Checks if is recebe email mkt.
	 * 
	 * @return true, if is recebe email mkt
	 */
	public boolean isRecebeEmailMkt() {
		return recebeEmailMkt;
	}

	/**
	 * Sets the recebe email mkt.
	 * 
	 * @param recebeEmailMkt
	 *            the new recebe email mkt
	 */
	public void setRecebeEmailMkt(final boolean recebeEmailMkt) {
		this.recebeEmailMkt = recebeEmailMkt;
	}

	/**
	 * Gets the senha.
	 * 
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Sets the senha.
	 * 
	 * @param senha
	 *            the new senha
	 */
	public void setSenha(final String senha) {
		this.senha = senha;
	}

}
