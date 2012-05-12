package br.com.sindico.entity;

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

@Entity
@Table(name="FORNECEDOR")
public class Fornecedor {
	
	@Id @GeneratedValue
	@Column(name="FORNECEDOR_ID")
	private int codigo;
	
	@Column(name="DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="NOME_PRINCIPAL")
	private String nomePrincipal; // REVER AMBIGUIDADE COM NOME
	
	@Column(name="LOGO")
	private String logo;
	
	@ElementCollection
	@JoinTable(name="ENDERECO", joinColumns=@JoinColumn(name="ENDERECO_ID"))
	private Collection<Endereco> enderecos =  new ArrayList<Endereco>();
	
	@Column(name="CNPJ")
	private String cnpj;
	
	@ManyToMany
	@JoinTable(name="FORNECEDOR_SUBCATEGORIA", joinColumns=@JoinColumn(name="FORNECEDOR_ID"), 
			inverseJoinColumns=@JoinColumn(name="SUBCATEGORIA_ID"))
	private Collection<Subcategoria> subcategorias = new ArrayList<Subcategoria>();
	
	@Column(name="ESTRELAS")
	private int estrelas;
	
	@Column(name="ANUNCIANTE")
	private boolean anunciante;
	
	@Column(name="APROVADO")
	private boolean aprovado;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="TELEFONE_COMERCIAL")
	private String telefoneComercial;
	
	@Column(name="CELULAR")
	private String celular;
	
	@Column(name="FAX")
	private String fax;
	
	@Column(name="SLOGAN")
	private String slogan;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="TITLE")
	private String title;
	
	@ElementCollection
	private Collection<String> email = new ArrayList<String>();
	
	@Column(name="RECEBE_COTACAO_EMAIL1")
	private boolean recebeCotacaoEmail1;
	
	@Column(name="RECEBE_NEWS_EMAIL1")
	private boolean recebeNewsEmail1;
	
	@Column(name="RECEBE_COTACAO_EMAIL2")
	private boolean recebeCotacaoEmail2;
	
	@Column(name="RECEBE_NEWS_EMAIL2")
	private boolean recebeNewsEmail2;
	
	@Column(name="RECEBE_COTACAO_EMAIL3")
	private boolean recebeCotacaoEmail3;
	
	@Column(name="RECEBE_NEWS_EMAIL3")
	private boolean recebeNewsEmail3;
	
	@ManyToMany(mappedBy="fornecedores")
	private Collection<Cotacao> cotacoes = new ArrayList<Cotacao>();
	
	@OneToMany(mappedBy="fornecedorVencedor")
	private Collection<Cotacao> cotacoesVencedoras = new ArrayList<Cotacao>();

	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public Collection<Cotacao> getCotacoesVencedoras() {
		return cotacoesVencedoras;
	}

	public void setCotacoesVencedoras(Collection<Cotacao> cotacoesVencedoras) {
		this.cotacoesVencedoras = cotacoesVencedoras;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePrincipal() {
		return nomePrincipal;
	}

	public void setNomePrincipal(String nomePrincipal) {
		this.nomePrincipal = nomePrincipal;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Collection<Subcategoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(Collection<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public boolean isAnunciante() {
		return anunciante;
	}

	public void setAnunciante(boolean anunciante) {
		this.anunciante = anunciante;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<String> getEmail() {
		return email;
	}

	public void setEmail(Collection<String> email) {
		this.email = email;
	}

	public boolean isRecebeCotacaoEmail1() {
		return recebeCotacaoEmail1;
	}

	public void setRecebeCotacaoEmail1(boolean recebeCotacaoEmail1) {
		this.recebeCotacaoEmail1 = recebeCotacaoEmail1;
	}

	public boolean isRecebeNewsEmail1() {
		return recebeNewsEmail1;
	}

	public void setRecebeNewsEmail1(boolean recebeNewsEmail1) {
		this.recebeNewsEmail1 = recebeNewsEmail1;
	}

	public boolean isRecebeCotacaoEmail2() {
		return recebeCotacaoEmail2;
	}

	public void setRecebeCotacaoEmail2(boolean recebeCotacaoEmail2) {
		this.recebeCotacaoEmail2 = recebeCotacaoEmail2;
	}

	public boolean isRecebeNewsEmail2() {
		return recebeNewsEmail2;
	}

	public void setRecebeNewsEmail2(boolean recebeNewsEmail2) {
		this.recebeNewsEmail2 = recebeNewsEmail2;
	}

	public boolean isRecebeCotacaoEmail3() {
		return recebeCotacaoEmail3;
	}

	public void setRecebeCotacaoEmail3(boolean recebeCotacaoEmail3) {
		this.recebeCotacaoEmail3 = recebeCotacaoEmail3;
	}

	public boolean isRecebeNewsEmail3() {
		return recebeNewsEmail3;
	}

	public void setRecebeNewsEmail3(boolean recebeNewsEmail3) {
		this.recebeNewsEmail3 = recebeNewsEmail3;
	}
	
	

}
