package com.sindico.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.NotNull;

import com.sindico.enums.Estado;
import com.sindico.enums.TipoPredio;

// TODO: Auto-generated Javadoc
/**
 * The Class Predio.
 */
@Entity
@Table(name = "PREDIO")
public class Predio implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long					serialVersionUID	= -3889143352236301499L;

	/** The id. */
	@Id
	@GeneratedValue
	private Long								id;

	/** The arquivo foto. */
	@Column(name = "ARQUIVO_FOTO")
	private String								arquivoFoto;

	/** The cnpj. */
	@Column(name = "CNPJ", length = 11, unique = true, nullable = false)
	@NotNull(message = "Predio deve ter um CNPJ")
	private String								cnpj;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date								dataCadastro;

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

	/** The nome. */
	@Column(name = "NOME", nullable = false, length = 120)
	@NotNull(message = "Prédio deve ter um nome")
	private String								nome;

	/** The numero apartamentos. */
	@Column(name = "NUMERO_APARTAMENTOS")
	private int									numeroApartamentos;

	/** The tipo. */
	@Column(name = "TIPO")
	private TipoPredio							tipo;

	/** The gerente. */
	@ManyToOne
	@JoinColumn(name = "GERENTE_ID")
	private GerenteAdministradora				gerente;

	/** The gerente recebe cotacao. */
	@Column(name = "GERENTE_COTACAO")
	private boolean								gerenteRecebeCotacao;

	@Transient
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "predio", fetch = FetchType.EAGER)
	private final Collection<Usuario>			usuarios			= new ArrayList<Usuario>();

	@OneToMany(mappedBy = "predio")
	private final Collection<RespostaCotacao>	respostasCotacao	= new ArrayList<RespostaCotacao>();

	@OneToMany(mappedBy = "predio")
	private Collection<Cotacao>					cotacoes			= new ArrayList<Cotacao>();

	/**
	 * Instantiates a new predio.
	 */
	public Predio() {
		super();
		this.dataCadastro = new Date();
	}

	/**
	 * @param cep2
	 */
	public Predio(final CepSimples cep) {
		this.estado = Estado.fromEstado(cep.getUf());
		this.cidade = cep.getCidade();
		this.bairro = cep.getBairro();
		this.endereco = cep.getTipo_logradouro() + " " + cep.getLogradouro();
		this.numero = cep.getNumero();
		this.cep = cep.getCep();
		this.nome = "Sem nome";
		this.dataCadastro = new Date();
		this.cnpj = "0000000000";

	}

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
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	public TipoPredio getTipo() {
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
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
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
	public void setTipo(final TipoPredio tipo) {
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
	 * Sets the endereco.
	 * 
	 * @param endereco
	 *            the new endereco
	 */
	public void setEndereco(final String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the endereco.
	 * 
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public Collection<RespostaCotacao> getRespostasCotacao() {
		return respostasCotacao;
	}

	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(final Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

}
