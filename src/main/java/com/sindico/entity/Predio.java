package com.sindico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Predio.
 */
@Entity
@Table(name = "PREDIO")
public class Predio {

	/** The arquivo foto. */
	@Column(name = "ARQUIVO_FOTO")
	private String					arquivoFoto;			// REVER

	/** The cnpj. */
	@Column(name = "CNPJ", length = 20, unique = true, nullable = false)
	@NotNull(message="Predio deve ter um CNPJ")
	private String					cnpj;

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "PREDIO_ID")
	private int						codigo;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date					dataCadastro;

	/** The endereco. */
	@Embedded
	@JoinTable(name = "ENDERECO")
	private Endereco				endereco;

	/** The nome. */
	@Column(name = "NOME", nullable = false, length = 120)
	@NotNull(message="Prédio deve ter um nome")
	private String					nome;

	/** The numero apartamentos. */
	@Column(name = "NUMERO_APARTAMENTOS")
	private int						numeroApartamentos;

	/** The tipo. */
	@Column(name = "TIPO")
	private char					tipo;

	/** The gerente. */
	@ManyToOne
	@JoinColumn(name = "GERENTE_ID") // TODOO PREDIO TEM UM GERENTE???
	private GerenteAdministradora	gerente;

	/** The gerente recebe cotacao. */
	@Column(name = "GERENTE_COTACAO")
	private boolean					gerenteRecebeCotacao;

	/**
	 * Gets the arquivo foto.
	 * 
	 * @return the arquivo foto
	 */
	public String getArquivoFoto() {
		return arquivoFoto;
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
	 * Gets the data cadastro.
	 * 
	 * @return the data cadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
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
	 * Sets the arquivo foto.
	 * 
	 * @param arquivoFoto
	 *            the new arquivo foto
	 */
	public void setArquivoFoto(final String arquivoFoto) {
		this.arquivoFoto = arquivoFoto;
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
	 * Sets the data cadastro.
	 * 
	 * @param dataCadastro
	 *            the new data cadastro
	 */
	public void setDataCadastro(final Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	/**
	 * Gets the gerente.
	 * 
	 * @return the gerente
	 */
	public GerenteAdministradora getGerente() {
		return gerente;
	}

	/**
	 * Sets the gerente.
	 * 
	 * @param gerente
	 *            the new gerente
	 */
	public void setGerente(final GerenteAdministradora gerente) {
		this.gerente = gerente;
	}

	/**
	 * Checks if is gerente recebe cotacao.
	 * 
	 * @return true, if is gerente recebe cotacao
	 */
	public boolean isGerenteRecebeCotacao() {
		return gerenteRecebeCotacao;
	}

	/**
	 * Sets the gerente recebe cotacao.
	 * 
	 * @param gerenteRecebeCotacao
	 *            the new gerente recebe cotacao
	 */
	public void setGerenteRecebeCotacao(final boolean gerenteRecebeCotacao) {
		this.gerenteRecebeCotacao = gerenteRecebeCotacao;
	}

}
