package br.com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="COTACAO")
public class Cotacao {
	@Id @GeneratedValue
	@Column(name="COTACAO_ID")
	private int codigo;
	
	@Column(name="DATA")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="SUBCATEGORIA_ID")
	private Subcategoria subcategoria;
	
	@Column(name="STATUS")
	private char status; // a = aberto, t = trabalho e f = fechado
	
	@Column(name="APROVADA")
	private boolean aprovada;
	
	@ManyToMany
	@JoinTable(name="COTACAO_USUARIO", joinColumns=@JoinColumn(name="COTACAO_ID"),
			inverseJoinColumns=@JoinColumn(name="USUARIO_ID"))
	private Collection<Usuario> usuarios = new ArrayList<Usuario>();
	
	@ManyToOne
	@JoinColumn(name="ADMINISTRADORA_ID")
	private Administradora administradora;
	
	@ManyToOne
	@JoinColumn(name="GERENTE_ID")
	private GerenteAdministradora gerenteAdmin;
	
	@ManyToMany
	@JoinTable(name="COTACAO_FORNECEDOR", joinColumns=@JoinColumn(name="COTACAO_ID"),
			inverseJoinColumns=@JoinColumn(name="FORNECEDOR_ID"))
	private Collection<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	@ManyToOne
	@JoinColumn(name="FORNECEDOR_ID")
	private Fornecedor fornecedorVencedor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public boolean isAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Administradora getAdministradora() {
		return administradora;
	}

	public void setAdministradora(Administradora administradora) {
		this.administradora = administradora;
	}

	public GerenteAdministradora getGerenteAdmin() {
		return gerenteAdmin;
	}

	public void setGerenteAdmin(GerenteAdministradora gerenteAdmin) {
		this.gerenteAdmin = gerenteAdmin;
	}

	public Collection<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Collection<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor getFornecedorVencedor() {
		return fornecedorVencedor;
	}

	public void setFornecedorVencedor(Fornecedor fornecedorVencedor) {
		this.fornecedorVencedor = fornecedorVencedor;
	}

}
