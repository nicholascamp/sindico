package br.com.sindico.entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Telefone.
 */
public class Telefone {

	/** The codigo pais. */
	private String	codigoPais;

	/** The ddd. */
	private String	ddd;

	/** The numero. */
	private String	numero;

	/** The tipo. */
	private char	tipo;		// c = celular, n = normal, m = comercial

	/**
	 * Gets the codigo pais.
	 * 
	 * @return the codigo pais
	 */
	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * Gets the ddd.
	 * 
	 * @return the ddd
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * Gets the numero.
	 * 
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
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
	 * Sets the codigo pais.
	 * 
	 * @param codigoPais
	 *            the new codigo pais
	 */
	public void setCodigoPais(final String codigoPais) {
		this.codigoPais = codigoPais;
	}

	/**
	 * Sets the ddd.
	 * 
	 * @param ddd
	 *            the new ddd
	 */
	public void setDdd(final String ddd) {
		this.ddd = ddd;
	}

	/**
	 * Sets the numero.
	 * 
	 * @param numero
	 *            the new numero
	 */
	public void setNumero(final String numero) {
		this.numero = numero;
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
