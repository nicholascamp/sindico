package br.com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GERENTE_ADMINISTRADORA")
public class GerenteAdministradora {
	@Id @GeneratedValue
	@Column(name="GERENTE_ID")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="ADMINISTRADORA_ID")
	private Administradora administradora;
	
	@OneToMany (mappedBy="gerente")
	private Collection<Predio> predios = new ArrayList<Predio>();
	
	@Column(name="DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SOBRENOME")
	private String sobrenome;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="CELULAR")
	private String celular;
	
	@Column(name="FAX")
	private String fax;
	
	@Column(name="TELEFONE_COMERCIAL")
	private String telefoneComercial;
	
	@OneToMany(mappedBy="gerenteRecebeCotacao")
	private Collection<Boolean> recebeCotacaoPredios; // TIRAR DUVIDA E REVER
	
	@Column(name="RECEBE_EMAIL_MKT")
	private boolean recebeEmailMkt;
	
	@Column(name="SENHA")
	private String senha;
	
	@OneToMany(mappedBy="gerenteAdmin")
	private Collection<Cotacao> cotacoes = new ArrayList<Cotacao>();

	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Administradora getAdministradora() {
		return administradora;
	}

	public void setAdministradora(Administradora administradora) {
		this.administradora = administradora;
	}

	public Collection<Predio> getPredios() {
		return predios;
	}

	public void setPredios(Collection<Predio> predios) {
		this.predios = predios;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public Collection<Boolean> getRecebeCotacaoPredios() {
		return recebeCotacaoPredios;
	}

	public void setRecebeCotacaoPredios(Collection<Boolean> recebeCotacaoPredios) {
		this.recebeCotacaoPredios = recebeCotacaoPredios;
	}

	public boolean isRecebeEmailMkt() {
		return recebeEmailMkt;
	}

	public void setRecebeEmailMkt(boolean recebeEmailMkt) {
		this.recebeEmailMkt = recebeEmailMkt;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
