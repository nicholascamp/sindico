/**
 * 
 */
package com.sindico.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class Cep.
 */
@XmlRootElement(name = "webservicecep")
public class Cep {

	/** The resultado. */
	private String resultado;

	/** The resultado_txt. */
	private String resultado_txt;

	/** The uf. */
	private String uf;

	/** The cidade. */
	private String cidade;

	/** The bairro. */
	private String bairro;

	/** The tipo_logradouro. */
	private String tipo_logradouro;

	/** The logradouro. */
	private String logradouro;

	/**
	 * Gets the resultado.
	 * 
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * Sets the resultado.
	 * 
	 * @param resultado
	 *            the new resultado
	 */
	public void setResultado(final String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Gets the resultado_txt.
	 * 
	 * @return the resultado_txt
	 */
	public String getResultado_txt() {
		return resultado_txt;
	}

	/**
	 * Sets the resultado_txt.
	 * 
	 * @param resultado_txt
	 *            the new resultado_txt
	 */
	public void setResultado_txt(final String resultado_txt) {
		this.resultado_txt = resultado_txt;
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

}
