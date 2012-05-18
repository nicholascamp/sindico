package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private int codigo;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;

	/** The nome. */
	@Column(name = "NOME")
	private String nome;

	/** The nome principal. */
	@Column(name = "NOME_PRINCIPAL")
	private String nomePrincipal; // REVER AMBIGUIDADE COM NOME

	/** The logo. */
	@Column(name = "LOGO")
	private String logo;

	/** The enderecos. */
	@ElementCollection
	@JoinTable(name = "ENDERECO", joinColumns = @JoinColumn(name = "ENDERECO_ID"))
	private Collection<Endereco> enderecos = new ArrayList<Endereco>();

	/** The cnpj. */
	@Column(name = "CNPJ")
	private String cnpj;

	/** The subcategorias. */
	@ManyToMany
	@JoinTable(name = "FORNECEDOR_SUBCATEGORIA", joinColumns = @JoinColumn(name = "FORNECEDOR_ID"), inverseJoinColumns = @JoinColumn(name = "SUBCATEGORIA_ID"))
	private Collection<Subcategoria> subcategorias = new ArrayList<Subcategoria>();

	/** The estrelas. */
	@Column(name = "ESTRELAS")
	private int estrelas;

	/** The anunciante. */
	@Column(name = "ANUNCIANTE")
	private boolean anunciante;

	/** The aprovado. */
	@Column(name = "APROVADO")
	private boolean aprovado;

	/** The telefone. */
	@Column(name = "TELEFONE")
	private String telefone;

	/** The telefone comercial. */
	@Column(name = "TELEFONE_COMERCIAL")
	private String telefoneComercial;

	/** The celular. */
	@Column(name = "CELULAR")
	private String celular;

	/** The fax. */
	@Column(name = "FAX")
	private String fax;

	/** The slogan. */
	@Column(name = "SLOGAN")
	private String slogan;

	/** The descricao. */
	@Column(name = "DESCRICAO")
	private String descricao;

	/** The title. */
	@Column(name = "TITLE")
	private String title;

	/** The email. */
	@ElementCollection
	private Collection<String> email = new ArrayList<String>();

	/** The recebe cotacao email1. */
	@Column(name = "RECEBE_COTACAO_EMAIL1")
	private boolean recebeCotacaoEmail1;

	/** The recebe news email1. */
	@Column(name = "RECEBE_NEWS_EMAIL1")
	private boolean recebeNewsEmail1;

	/** The recebe cotacao email2. */
	@Column(name = "RECEBE_COTACAO_EMAIL2")
	private boolean recebeCotacaoEmail2;

	/** The recebe news email2. */
	@Column(name = "RECEBE_NEWS_EMAIL2")
	private boolean recebeNewsEmail2;

	/** The recebe cotacao email3. */
	@Column(name = "RECEBE_COTACAO_EMAIL3")
	private boolean recebeCotacaoEmail3;

	/** The recebe news email3. */
	@Column(name = "RECEBE_NEWS_EMAIL3")
	private boolean recebeNewsEmail3;

	/** The cotacoes. */
	@ManyToMany(mappedBy = "fornecedores")
	private Collection<Cotacao> cotacoes = new ArrayList<Cotacao>();

	/** The cotacoes vencedoras. */
	@OneToMany(mappedBy = "fornecedorVencedor")
	private Collection<Cotacao> cotacoesVencedoras = new ArrayList<Cotacao>();

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
	public void setCotacoesVencedoras(final Collection<Cotacao> cotacoesVencedoras) {
		this.cotacoesVencedoras = cotacoesVencedoras;
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
	 * Sets the codigo.
	 * 
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(final int codigo) {
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
	 * Gets the telefone comercial.
	 * 
	 * @return the telefone comercial
	 */
	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	/**
	 * Sets the telefone comercial.
	 * 
	 * @param telefoneComercial
	 *            the new telefone comercial
	 */
	public void setTelefoneComercial(final String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
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
	 * Gets the fax.
	 * 
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the fax.
	 * 
	 * @param fax
	 *            the new fax
	 */
	public void setFax(final String fax) {
		this.fax = fax;
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
	public Collection<String> getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(final Collection<String> email) {
		this.email = email;
	}

	/**
	 * Checks if is recebe cotacao email1.
	 * 
	 * @return true, if is recebe cotacao email1
	 */
	public boolean isRecebeCotacaoEmail1() {
		return recebeCotacaoEmail1;
	}

	/**
	 * Sets the recebe cotacao email1.
	 * 
	 * @param recebeCotacaoEmail1
	 *            the new recebe cotacao email1
	 */
	public void setRecebeCotacaoEmail1(final boolean recebeCotacaoEmail1) {
		this.recebeCotacaoEmail1 = recebeCotacaoEmail1;
	}

	/**
	 * Checks if is recebe news email1.
	 * 
	 * @return true, if is recebe news email1
	 */
	public boolean isRecebeNewsEmail1() {
		return recebeNewsEmail1;
	}

	/**
	 * Sets the recebe news email1.
	 * 
	 * @param recebeNewsEmail1
	 *            the new recebe news email1
	 */
	public void setRecebeNewsEmail1(final boolean recebeNewsEmail1) {
		this.recebeNewsEmail1 = recebeNewsEmail1;
	}

	/**
	 * Checks if is recebe cotacao email2.
	 * 
	 * @return true, if is recebe cotacao email2
	 */
	public boolean isRecebeCotacaoEmail2() {
		return recebeCotacaoEmail2;
	}

	/**
	 * Sets the recebe cotacao email2.
	 * 
	 * @param recebeCotacaoEmail2
	 *            the new recebe cotacao email2
	 */
	public void setRecebeCotacaoEmail2(final boolean recebeCotacaoEmail2) {
		this.recebeCotacaoEmail2 = recebeCotacaoEmail2;
	}

	/**
	 * Checks if is recebe news email2.
	 * 
	 * @return true, if is recebe news email2
	 */
	public boolean isRecebeNewsEmail2() {
		return recebeNewsEmail2;
	}

	/**
	 * Sets the recebe news email2.
	 * 
	 * @param recebeNewsEmail2
	 *            the new recebe news email2
	 */
	public void setRecebeNewsEmail2(final boolean recebeNewsEmail2) {
		this.recebeNewsEmail2 = recebeNewsEmail2;
	}

	/**
	 * Checks if is recebe cotacao email3.
	 * 
	 * @return true, if is recebe cotacao email3
	 */
	public boolean isRecebeCotacaoEmail3() {
		return recebeCotacaoEmail3;
	}

	/**
	 * Sets the recebe cotacao email3.
	 * 
	 * @param recebeCotacaoEmail3
	 *            the new recebe cotacao email3
	 */
	public void setRecebeCotacaoEmail3(final boolean recebeCotacaoEmail3) {
		this.recebeCotacaoEmail3 = recebeCotacaoEmail3;
	}

	/**
	 * Checks if is recebe news email3.
	 * 
	 * @return true, if is recebe news email3
	 */
	public boolean isRecebeNewsEmail3() {
		return recebeNewsEmail3;
	}

	/**
	 * Sets the recebe news email3.
	 * 
	 * @param recebeNewsEmail3
	 *            the new recebe news email3
	 */
	public void setRecebeNewsEmail3(final boolean recebeNewsEmail3) {
		this.recebeNewsEmail3 = recebeNewsEmail3;
	}

}
