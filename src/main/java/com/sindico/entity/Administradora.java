package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

import com.sindico.enums.Estado;

// TODO: Auto-generated Javadoc
/**
 * The Class Administradora.
 */
@Entity
@Table(name = "ADMINISTRADORA")
public class Administradora {

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "ADMINISTRADORA_ID")
	private Long								id;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date								dataCadastro;

	/** The nome. */
	@Column(name = "NOME", length = 60, nullable = false)
	@NotNull(message = "A Administradora necessita de um nome")
	private String								nome;

	/** The cnpj. */
	@Column(name = "CNPJ", length = 20, unique = true)
	private String								cnpj;

	/** The bairro. */
	@Column(name = "BAIRRO", nullable = false, length = 100)
	private String								bairro;

	/** The cep. */
	@Column(name = "CEP", nullable = false, length = 10)
	private String								cep;

	/** The cidade. */
	@Column(name = "CIDADE", nullable = false, length = 100)
	private String								cidade;

	/** The endereco. */
	@Column(name = "RUA", nullable = false)
	private String								endereco;

	/** The estado. */
	@Column(name = "ESTADO", nullable = false, length = 2)
	private Estado								estado;

	/** The numero. */
	@Column(name = "NUMERO", nullable = false)
	private int									numero;

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20)
	private String								telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String								celular;
	/** The gerentes. */
	@OneToMany(mappedBy = "administradora", fetch = FetchType.EAGER)
	private Collection<GerenteAdministradora>	gerentes	= new ArrayList<GerenteAdministradora>();

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
	 * Gets the cnpj.
	 * 
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
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
	 * Gets the cep.
	 * 
	 * @return the cep
	 */
	public String getCep() {
		return cep;
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
	 * Gets the endereco.
	 * 
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
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
	 * Gets the estado.
	 * 
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 * 
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(final Estado estado) {
		this.estado = estado;
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
	 * Sets the numero.
	 * 
	 * @param numero
	 *            the new numero
	 */
	public void setNumero(final int numero) {
		this.numero = numero;
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
	 * Gets the gerentes.
	 * 
	 * @return the gerentes
	 */
	public Collection<GerenteAdministradora> getGerentes() {
		return gerentes;
	}

	/**
	 * Sets the gerentes.
	 * 
	 * @param gerentes
	 *            the new gerentes
	 */
	public void setGerentes(final Collection<GerenteAdministradora> gerentes) {
		this.gerentes = gerentes;
	}

}
