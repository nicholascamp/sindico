package br.com.sindico.entity;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Predio.
 */
public class Predio {

	/** The caminho foto. */
	private String		caminhoFoto;		// REVER

	/** The cnpj. */
	private String		cnpj;

	/** The codigo. */
	private int			codigo;

	/** The data de cadastro. */
	private Date		dataDeCadastro;

	/** The endereco. */
	private Endereco	endereco;

	/** The nome. */
	private String		nome;

	/** The numero apartamentos. */
	private int			numeroApartamentos;

	/** The tipo. */
	private char		tipo;

	/**
	 * Gets the caminho foto.
	 * 
	 * @return the caminho foto
	 */
	public String getCaminhoFoto() {
		return caminhoFoto;
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
	 * Gets the endereco.
	 * 
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
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
	 * Gets the numero apartamentos.
	 * 
	 * @return the numero apartamentos
	 */
	public int getNumeroApartamentos() {
		return numeroApartamentos;
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
	 * Sets the caminho foto.
	 * 
	 * @param caminhoFoto
	 *            the new caminho foto
	 */
	public void setCaminhoFoto(final String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
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
	 * Sets the endereco.
	 * 
	 * @param endereco
	 *            the new endereco
	 */
	public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
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
	 * Sets the numero apartamentos.
	 * 
	 * @param numeroApartamentos
	 *            the new numero apartamentos
	 */
	public void setNumeroApartamentos(final int numeroApartamentos) {
		this.numeroApartamentos = numeroApartamentos;
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
