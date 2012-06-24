package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.NotNull;

/**
 * The Class GerenteAdministradora.
 */
@Entity
@Table(name = "GERENTE_ADMINISTRADORA")
public class GerenteAdministradora {

	@Id
	@GeneratedValue
	@Column(name = "GERENTE_ID")
	private Long				id;

	/** The administradora. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADMINISTRADORA_ID")
	@NotNull(message = "Gerente deve pertencer a uma Administradora")
	private Administradora		administradora;

	/** The predios. */
	@OneToMany(mappedBy = "gerente")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Predio>	predios		= new ArrayList<Predio>();

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date				dataCadastro;

	/** The nome. */
	@Column(name = "NOME", length = 50, nullable = false)
	@NotNull(message = "Gerente deve ter um nome")
	private String				nome;

	/** The email. */
	@Column(name = "EMAIL", length = 60, nullable = false, unique = true)
	@NotNull(message = "Gerente deve ter um email")
	private String				email;

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20)
	private String				telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String				celular;

	/** The recebe email mkt. */
	@Column(name = "RECEBE_EMAIL_MKT")
	private boolean				recebeEmailMkt;

	/** The senha. */
	@Column(name = "SENHA", length = 20)
	private String				senha;

	/** The cotacoes. */
	@OneToMany(mappedBy = "gerenteAdmin", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
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

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
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
