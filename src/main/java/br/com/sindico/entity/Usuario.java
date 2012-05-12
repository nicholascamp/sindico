package br.com.sindico.entity;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
public class Usuario {

	/** The celular. */
	private Telefone	celular;

	/** The codigo. */
	private int			codigo;

	/** The data de cadastro. */
	private Date		dataDeCadastro;

	/** The data de nascimento. */
	private Date		dataDeNascimento;

	/** The email. */
	private String		email;

	/** The nome. */
	private String		nome;

	/** The recebe cotacao. */
	private boolean		recebeCotacao;

	/** The recebe email marketing. */
	private boolean		recebeEmailMarketing;

	/** The senha. */
	private String		senha;

	/** The telefone. */
	private Telefone	telefone;

	/** The tipo. */
	private char		tipo;					// s = sindico, c = conselho, m
												// = morador e z = zelador

	/**
	 * Gets the celular.
	 * 
	 * @return the celular
	 */
	public Telefone getCelular() {
		return celular;
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
	 * Gets the data de cadastro.
	 * 
	 * @return the data de cadastro
	 */
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	/**
	 * Gets the data de nascimento.
	 * 
	 * @return the data de nascimento
	 */
	public Date getDataDeNascimento() {
		return dataDeNascimento;
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
	 * Gets the nome.
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
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
	 * Gets the telefone.
	 * 
	 * @return the telefone
	 */
	public Telefone getTelefone() {
		return telefone;
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
	 * Checks if is recebe cotacao.
	 * 
	 * @return true, if is recebe cotacao
	 */
	public boolean isRecebeCotacao() {
		return recebeCotacao;
	}

	/**
	 * Checks if is recebe email marketing.
	 * 
	 * @return true, if is recebe email marketing
	 */
	public boolean isRecebeEmailMarketing() {
		return recebeEmailMarketing;
	}

	/**
	 * Sets the celular.
	 * 
	 * @param celular
	 *            the new celular
	 */
	public void setCelular(final Telefone celular) {
		this.celular = celular;
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
	 * Sets the data de cadastro.
	 * 
	 * @param dataDeCadastro
	 *            the new data de cadastro
	 */
	public void setDataDeCadastro(final Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	/**
	 * Sets the data de nascimento.
	 * 
	 * @param dataDeNascimento
	 *            the new data de nascimento
	 */
	public void setDataDeNascimento(final Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
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
	 * Sets the nome.
	 * 
	 * @param nome
	 *            the new nome
	 */
	public void setNome(final String nome) {
		this.nome = nome;
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
	 * Sets the recebe email marketing.
	 * 
	 * @param recebeEmailMarketing
	 *            the new recebe email marketing
	 */
	public void setRecebeEmailMarketing(final boolean recebeEmailMarketing) {
		this.recebeEmailMarketing = recebeEmailMarketing;
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
	 * Sets the telefone.
	 * 
	 * @param telefone
	 *            the new telefone
	 */
	public void setTelefone(final Telefone telefone) {
		this.telefone = telefone;
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

}
