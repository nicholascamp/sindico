package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

import com.sindico.enums.Estado;

// TODO: Auto-generated Javadoc
/**
 * The Class Fornecedor.
 */
@Entity
@Table(name = "FORNECEDOR")
public class Fornecedor {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "FORNECEDOR_ID")
	private Long						codigo;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date						dataCadastro;

	/** The nome. */
	@Column(name = "NOME", nullable = false, length = 100)
	@NotNull(message = "Fornecedor necessita de um nome")
	private String						nome;

	/** The nome principal. */
	@Column(name = "NOME_PRINCIPAL", nullable = false)
	private String						nomePrincipal;

	/** The logo. */
	@Column(name = "LOGO")
	private String						logo;

	/** The bairro. */
	@Column(name = "BAIRRO", nullable = false, length = 100)
	private String						bairro;

	/** The cep. */
	@Column(name = "CEP", nullable = false, length = 10)
	private String						cep;

	/** The cidade. */
	@Column(name = "CIDADE", nullable = false, length = 100)
	private String						cidade;

	/** The endereco. */
	@Column(name = "RUA", nullable = false)
	private String						endereco;

	/** The estado. */
	@Column(name = "ESTADO", nullable = false, length = 2)
	private Estado						estado;

	/** The numero. */
	@Column(name = "NUMERO", nullable = false)
	private int							numero;

	/** The cnpj. */
	@Column(name = "CNPJ", length = 20, nullable = false, unique = true)
	@NotNull(message = "Fornecedor necessita de um CNPJ")
	private String						cnpj;

	/** The subcategorias. */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "FORNECEDOR_SUBCATEGORIA", joinColumns = @JoinColumn(
			name = "FORNECEDOR_ID"), inverseJoinColumns = @JoinColumn(
			name = "SUBCATEGORIA_ID"))
	private Collection<Subcategoria>	subcategorias		= new ArrayList<Subcategoria>();

	/** The estrelas. */
	@Column(name = "ESTRELAS")
	private int							estrelas;

	/** The anunciante. */
	@Column(name = "ANUNCIANTE")
	private boolean						anunciante;

	/** The aprovado. */
	@Column(name = "APROVADO")
	private boolean						aprovado;

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20, nullable = false)
	@NotNull(message = "Fornecedor necessita de um telefone")
	private String						telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String						celular;

	/** The slogan. */
	@Column(name = "SLOGAN")
	private String						slogan;

	/** The descricao. */
	@Column(name = "DESCRICAO")
	private String						descricao;

	/** The title. */
	@Column(name = "TITLE")
	private String						title;

	/** The email. */
	@Column(name = "email")
	private String						email;

	/** The recebe cotacao email. */
	@Column(name = "RECEBE_COTACAO_EMAIL")
	private boolean						recebeCotacaoEmail;

	/** The recebe news email. */
	@Column(name = "RECEBE_NEWS_EMAIL")
	private boolean						recebeNewsEmail;

	/** The cotacoes. */
	@ManyToMany(mappedBy = "fornecedores")
	private Collection<Cotacao>			cotacoes			= new ArrayList<Cotacao>();

	/** The cotacoes vencedoras. */
	@OneToMany(mappedBy = "fornecedorVencedor")
	private Collection<Cotacao>			cotacoesVencedoras	= new ArrayList<Cotacao>();

	/**
	 * Instantiates a new fornecedor.
	 */
	public Fornecedor() {
		super();
		this.dataCadastro = new Date();
	}

	/**
	 * Gets the cotacoes.
	 * 
	 * @return the cotacoes
	 */
	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	/**
	 * Sets the cotacoes.
	 * 
	 * @param cotacoes
	 *            the new cotacoes
	 */
	public void setCotacoes(final Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	/**
	 * Gets the cotacoes vencedoras.
	 * 
	 * @return the cotacoes vencedoras
	 */
	public Collection<Cotacao> getCotacoesVencedoras() {
		return cotacoesVencedoras;
	}

	/**
	 * Sets the cotacoes vencedoras.
	 * 
	 * @param cotacoesVencedoras
	 *            the new cotacoes vencedoras
	 */
	public void setCotacoesVencedoras(
			final Collection<Cotacao> cotacoesVencedoras) {
		this.cotacoesVencedoras = cotacoesVencedoras;
	}

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
	 * Gets the nome principal.
	 * 
	 * @return the nome principal
	 */
	public String getNomePrincipal() {
		return nomePrincipal;
	}

	/**
	 * Sets the nome principal.
	 * 
	 * @param nomePrincipal
	 *            the new nome principal
	 */
	public void setNomePrincipal(final String nomePrincipal) {
		this.nomePrincipal = nomePrincipal;
	}

	/**
	 * Gets the logo.
	 * 
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Sets the logo.
	 * 
	 * @param logo
	 *            the new logo
	 */
	public void setLogo(final String logo) {
		this.logo = logo;
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
	 * Gets the subcategorias.
	 * 
	 * @return the subcategorias
	 */
	public Collection<Subcategoria> getSubcategorias() {
		return subcategorias;
	}

	/**
	 * Sets the subcategorias.
	 * 
	 * @param subcategorias
	 *            the new subcategorias
	 */
	public void setSubcategorias(final Collection<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	/**
	 * Gets the estrelas.
	 * 
	 * @return the estrelas
	 */
	public int getEstrelas() {
		return estrelas;
	}

	/**
	 * Sets the estrelas.
	 * 
	 * @param estrelas
	 *            the new estrelas
	 */
	public void setEstrelas(final int estrelas) {
		this.estrelas = estrelas;
	}

	/**
	 * Checks if is anunciante.
	 * 
	 * @return true, if is anunciante
	 */
	public boolean isAnunciante() {
		return anunciante;
	}

	/**
	 * Sets the anunciante.
	 * 
	 * @param anunciante
	 *            the new anunciante
	 */
	public void setAnunciante(final boolean anunciante) {
		this.anunciante = anunciante;
	}

	/**
	 * Checks if is aprovado.
	 * 
	 * @return true, if is aprovado
	 */
	public boolean isAprovado() {
		return aprovado;
	}

	/**
	 * Sets the aprovado.
	 * 
	 * @param aprovado
	 *            the new aprovado
	 */
	public void setAprovado(final boolean aprovado) {
		this.aprovado = aprovado;
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
	 * Gets the slogan.
	 * 
	 * @return the slogan
	 */
	public String getSlogan() {
		return slogan;
	}

	/**
	 * Sets the slogan.
	 * 
	 * @param slogan
	 *            the new slogan
	 */
	public void setSlogan(final String slogan) {
		this.slogan = slogan;
	}

	/**
	 * Gets the descricao.
	 * 
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Sets the descricao.
	 * 
	 * @param descricao
	 *            the new descricao
	 */
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(final String email) {
		this.email = email;
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
	 * Checks if is recebe cotacao email.
	 * 
	 * @return true, if is recebe cotacao email
	 */
	public boolean isRecebeCotacaoEmail() {
		return recebeCotacaoEmail;
	}

	/**
	 * Sets the recebe cotacao email.
	 * 
	 * @param recebeCotacaoEmail
	 *            the new recebe cotacao email
	 */
	public void setRecebeCotacaoEmail(final boolean recebeCotacaoEmail) {
		this.recebeCotacaoEmail = recebeCotacaoEmail;
	}

	/**
	 * Checks if is recebe news email.
	 * 
	 * @return true, if is recebe news email
	 */
	public boolean isRecebeNewsEmail() {
		return recebeNewsEmail;
	}

	/**
	 * Sets the recebe news email.
	 * 
	 * @param recebeNewsEmail
	 *            the new recebe news email
	 */
	public void setRecebeNewsEmail(final boolean recebeNewsEmail) {
		this.recebeNewsEmail = recebeNewsEmail;
	}

}
