package br.com.sindico.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Predio.
 */
@Entity
@Table(name="PREDIO")
public class Predio {

	/** The caminho foto. */
	@Column(name="ARQUIVO_FOTO")
	private String		arquivoFoto;		// REVER

	/** The cnpj. */
	@Column(name="CNPJ")
	private String		cnpj;

	/** The codigo. */
	@Id @GeneratedValue
	@Column(name="PREDIO_ID")
	private int			codigo;

	/** The data de cadastro. */
	@Column(name="DATA_CADASTRO")
	private Date		dataDeCadastro;

	/** The endereco. */
	@Embedded
	@JoinTable(name="ENDERECO")
	private Endereco	endereco;

	/** The nome. */
	@Column(name="NOME")
	private String		nome;

	/** The numero apartamentos. */
	@Column(name="NUMERO_APARTAMENTOS")
	private int			numeroApartamentos;

	/** The tipo. */
	@Column(name="TIPO")
	private char		tipo;
	
	@ManyToOne
	@JoinColumn(name="GERENTE_ID")
	private GerenteAdministradora gerente;
	
	@ManyToOne
	@JoinColumn(name="GERENTE_ID")
	private boolean gerenteRecebeCotacao;

	/**
	 * Gets the caminho foto.
	 * 
	 * @return the caminho foto
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

	public GerenteAdministradora getGerente() {
		return gerente;
	}

	public void setGerente(GerenteAdministradora gerente) {
		this.gerente = gerente;
	}

	public boolean isGerenteRecebeCotacao() {
		return gerenteRecebeCotacao;
	}

	public void setGerenteRecebeCotacao(boolean gerenteRecebeCotacao) {
		this.gerenteRecebeCotacao = gerenteRecebeCotacao;
	}
	
	

}
