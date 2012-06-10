/**
 * 
 */
package com.sindico.entity;

import java.util.Date;

import com.sindico.enums.TipoUsuario;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioSimples.
 * 
 * @author Lucas
 */
public class UsuarioSimples {

	/** The id. */
	private Long		id;

	/** The nome. */
	private String		nome;

	/** The telefone. */
	private String		telefone;

	/** The celular. */
	private String		celular;

	/** The data cadastro. */
	private Date		dataCadastro	= new Date();

	/** The data nascimento. */
	private Date		dataNascimento;

	/** The email. */
	private String		email;

	/** The recebe cotacao. */
	private boolean		recebeCotacao;

	/** The tipo. */
	private TipoUsuario	tipo;

	/** The qtade cotacoes. */
	private int			qtadeCotacoes;

	/** The admin. */
	private boolean		admin			= false;

	public UsuarioSimples(final Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.telefone = usuario.getTelefone();
		this.celular = usuario.getCelular();
		this.dataCadastro = usuario.getDataCadastro();
		this.dataNascimento = usuario.getDataNascimento();
		this.email = usuario.getEmail();
		this.recebeCotacao = usuario.isRecebeCotacao();
		this.tipo = usuario.getTipo();
		this.qtadeCotacoes = usuario.getCotacoes().size();
		this.admin = usuario.isAdmin();
	}

	/**
	 * 
	 */
	public UsuarioSimples() {
	}

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
	public TipoUsuario getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 * 
	 * @param tipo
	 *            the new tipo
	 */
	public void setTipo(final TipoUsuario tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the qtade cotacoes.
	 * 
	 * @return the qtade cotacoes
	 */
	public int getQtadeCotacoes() {
		return qtadeCotacoes;
	}

	/**
	 * Sets the qtade cotacoes.
	 * 
	 * @param qtadeCotacoes
	 *            the new qtade cotacoes
	 */
	public void setQtadeCotacoes(final int qtadeCotacoes) {
		this.qtadeCotacoes = qtadeCotacoes;
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
	 * Checks if is admin.
	 * 
	 * @return true, if is admin
	 */
	public boolean isAdmin() {
		return admin;
	}

}
