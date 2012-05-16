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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Administradora.
 */
@Entity
@Table (name="ADMINISTRADORA")
public class Administradora {
	@Id @GeneratedValue
	@Column (name="ADMINISTRADORA_ID")
	private int codigo;
	
	@Column(name="DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column(name="CNJPJ", length=20)
	private String cnpj;
	
	@ElementCollection
	@JoinTable (name="ENDERECO", joinColumns=@JoinColumn(name="ADMINISTRADORA_ID"))
	private Collection<Endereco> enderecos = new ArrayList<Endereco>();
	
	@Column (name="TELEFONE", length=20)
	private String telefone;
	
	@Column (name="CELULAR", length=20)
	private String celular;
	
	@Column (name="FAX", length=20)
	private String fax;
	
	@Column (name="TELEFONE_COMERCIAL", length=20)
	private String telefoneComercial;
	
	@OneToMany (mappedBy="administradora")
	private Collection<GerenteAdministradora> gerentes = new ArrayList<GerenteAdministradora>();
	
	@OneToMany (mappedBy="administradora")
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
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

	public Collection<GerenteAdministradora> getGerentes() {
		return gerentes;
	}

	public void setGerentes(Collection<GerenteAdministradora> gerentes) {
		this.gerentes = gerentes;
	}
	
	
}
