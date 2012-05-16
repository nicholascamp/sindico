package br.com.sindico.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Endereco.
 */
@Embeddable
@Table (name="ENDERECO")
public class Endereco {

	/** The bairro. */
	@Column (name="BAIRRO")
	private String	bairro;

	/** The cep. */
	@Column(name="CEP")
	private String	cep;

	/** The cidade. */
	@Column(name="CIDADE")
	private String	cidade;

	/** The complemento. */
	@Column(name="COMPLEMENTO")
	private String	complemento;

	/** The endereco. */
	@Column(name="RUA")
	private String	endereco;

	/** The estado. */
	@Column(name="ESTADO")
	private String	estado;

	/** The numero. */
	@Column(name="NUMERO")
	private int		numero;

	/**
	 * Gets the bairro.
	 * 
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Gets the cep.
	 * 
	 * @return the cep
	 */
	public String getCep() {
		return cep;
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
	 * Gets the complemento.
	 * 
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Gets the endereco.
	 * 
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Gets the estado.
	 * 
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Gets the numero.
	 * 
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
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
	 * Sets the cep.
	 * 
	 * @param cep
	 *            the new cep
	 */
	public void setCep(final String cep) {
		this.cep = cep;
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
	 * Sets the complemento.
	 * 
	 * @param complemento
	 *            the new complemento
	 */
	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Sets the endereco.
	 * 
	 * @param endereco
	 *            the new endereco
	 */
	public void setEndereco(final String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Sets the estado.
	 * 
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(final String estado) {
		this.estado = estado;
	}

	/**
	 * Sets the numero.
	 * 
	 * @param numero
	 *            the new numero
	 */
	public void setNumero(final int numero) {
		this.numero = numero;
	}
}
