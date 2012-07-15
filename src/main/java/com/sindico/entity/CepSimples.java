/**
 * 
 */
package com.sindico.entity;

/**
 * The Class CepSimples.
 */
public class CepSimples {

	/** The uf. */
	private String	uf;

	/** The cidade. */
	private String	cidade;

	/** The bairro. */
	private String	bairro;

	/** The tipo_logradouro. */
	private String	tipo_logradouro;

	/** The logradouro. */
	private String	logradouro;

	private Integer	numero;

	private String	cep;

	/**
	 * Instantiates a new cep simples.
	 * 
	 * @param cep
	 *            the cep
	 */
	public CepSimples(final Cep cep) {
		this.uf = cep.getUf();
		this.cidade = cep.getCidade();
		this.bairro = cep.getBairro();
		this.tipo_logradouro = cep.getTipo_logradouro();
		this.logradouro = cep.getLogradouro();
	}

	/**
	 * Gets the uf.
	 * 
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * Sets the uf.
	 * 
	 * @param uf
	 *            the new uf
	 */
	public void setUf(final String uf) {
		this.uf = uf;
	}

	/**
	 * Gets the cidade.
	 * 
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Sets the cidade.
	 * 
	 * @param cidade
	 *            the new cidade
	 */
	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Gets the bairro.
	 * 
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Sets the bairro.
	 * 
	 * @param bairro
	 *            the new bairro
	 */
	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Gets the tipo_logradouro.
	 * 
	 * @return the tipo_logradouro
	 */
	public String getTipo_logradouro() {
		return tipo_logradouro;
	}

	/**
	 * Sets the tipo_logradouro.
	 * 
	 * @param tipo_logradouro
	 *            the new tipo_logradouro
	 */
	public void setTipo_logradouro(final String tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
	}

	/**
	 * Gets the logradouro.
	 * 
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Sets the logradouro.
	 * 
	 * @param logradouro
	 *            the new logradouro
	 */
	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(final Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(final String cep) {
		this.cep = cep;
	}

}
