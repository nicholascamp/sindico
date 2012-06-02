package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Administradora.
 */
@Entity
@Table(name = "ADMINISTRADORA")
public class Administradora {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "ADMINISTRADORA_ID")
	private Long								codigo;

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

	/** The enderecos. */
	@Embedded
	@JoinTable(name = "ENDERECO")
	private Collection<Endereco>				enderecos	= new ArrayList<Endereco>();

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20)
	private String								telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String								celular;
	/** The gerentes. */
	@Transient
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "administradora", fetch = FetchType.EAGER)
	private Collection<GerenteAdministradora>	gerentes	= new ArrayList<GerenteAdministradora>();

	/**
	 * Gets the codigo.
	 * 
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 * 
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
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
	 * Gets the enderecos.
	 * 
	 * @return the enderecos
	 */
	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * Sets the enderecos.
	 * 
	 * @param enderecos
	 *            the new enderecos
	 */
	public void setEnderecos(final Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
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
