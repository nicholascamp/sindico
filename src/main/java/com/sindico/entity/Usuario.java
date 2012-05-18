package com.sindico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario {

	/** The codigo. */
	@Id
	@GeneratedValue
	private Long	id;

	/** The nome. */
	@Column(name = "NOME", length = 20)
	private String	nome;

	/** The sobrenome. */
	@Column(name = "SOBRENOME", length = 45)
	private String	sobrenome;

	/** The senha. */
	@Column(name = "SENHA", length = 10)
	private String	senha;

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20)
	private String	telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String	celular;

	/** The fax. */
	@Column(name = "FAX", length = 20)
	private String	fax;

	/** The telefone comercial. */
	@Column(name = "TELEFONE_COMERCIAL", length = 20)
	private String	telefoneComercial;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date	dataCadastro;

	/** The data nascimento. */
	@Column(name = "DATA_NASCIMENTO")
	private Date	dataNascimento;

	/** The email. */
	@Column(name = "EMAIL", length = 50)
	private String	email;

	/** The recebe cotacao. */
	@Column(name = "RECEBE_COTACAO")
	private boolean	recebeCotacao;

	/** The tipo. */
	@Column(name = "TIPO")
	private char	tipo;				// s
										// =
										// sindico,
										// c
										// =
										// conselho,
										// m
										// =
										// morador
										// e
										// z
										// =
										// zelador

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
	 * Gets the data nascimento.
	 * 
	 * @return the data nascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Sets the data nascimento.
	 * 
	 * @param dataNascimento
	 *            the new data nascimento
	 */
	public void setDataNascimento(final Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	 * Checks if is recebe cotacao.
	 * 
	 * @return true, if is recebe cotacao
	 */
	public boolean isRecebeCotacao() {
		return recebeCotacao;
	}

	/**
	 * Sets the recebe cotacao.
	 * 
	 * @param recebeCotacao
	 *            the new recebe cotacao
	 */
	public void setRecebeCotacao(final boolean recebeCotacao) {
		this.recebeCotacao = recebeCotacao;
	}

	/**
	 * Gets the tipo.
	 * 
	 * @return the tipo
	 */
	public char getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 * 
	 * @param tipo
	 *            the new tipo
	 */
	public void setTipo(final char tipo) {
		this.tipo = tipo;
	}

	// /** The cotacoes. */
	// @ManyToMany(mappedBy = "usuarios")
	// private Collection<Cotacao> cotacoes = new ArrayList<Cotacao>();

}
