package com.sindico.entity;

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

/**
 * The Class Cotacao.
 */
@Entity
@Table(name = "COTACAO")
public class Cotacao {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "COTACAO_ID")
	private int codigo;

	/** The data. */
	@Column(name = "DATA")
	private Date data;

	/** The subcategoria. */
	@ManyToOne
	@JoinColumn(name = "SUBCATEGORIA_ID")
	private Subcategoria subcategoria;

	/** The status. */
	@Column(name = "STATUS")
	private char status; // a = aberto, t = trabalho e f = fechado

	/** The aprovada. */
	@Column(name = "APROVADA")
	private boolean aprovada;

	/** The usuarios. */
	@ManyToMany
	@JoinTable(name = "COTACAO_USUARIO", joinColumns = @JoinColumn(name = "COTACAO_ID"), inverseJoinColumns = @JoinColumn(name = "USUARIO_ID"))
	private Collection<Usuario> usuarios = new ArrayList<Usuario>();

	/** The administradora. */
	@ManyToOne
	@JoinColumn(name = "ADMINISTRADORA_ID")
	private Administradora administradora;

	/** The gerente admin. */
	@ManyToOne
	@JoinColumn(name = "GERENTE_ID")
	private GerenteAdministradora gerenteAdmin;

	/** The fornecedores. */
	@ManyToMany
	@JoinTable(name = "COTACAO_FORNECEDOR", joinColumns = @JoinColumn(name = "COTACAO_ID"), inverseJoinColumns = @JoinColumn(name = "FORNECEDOR_ID"))
	private Collection<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	/** The fornecedor vencedor. */
	@ManyToOne
	@JoinColumn(name = "FORNECEDOR_ID")
	private Fornecedor fornecedorVencedor;

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
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Sets the data.
	 * 
	 * @param data
	 *            the new data
	 */
	public void setData(final Date data) {
		this.data = data;
	}

	/**
	 * Gets the subcategoria.
	 * 
	 * @return the subcategoria
	 */
	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	/**
	 * Sets the subcategoria.
	 * 
	 * @param subcategoria
	 *            the new subcategoria
	 */
	public void setSubcategoria(final Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status
	 *            the new status
	 */
	public void setStatus(final char status) {
		this.status = status;
	}

	/**
	 * Checks if is aprovada.
	 * 
	 * @return true, if is aprovada
	 */
	public boolean isAprovada() {
		return aprovada;
	}

	/**
	 * Sets the aprovada.
	 * 
	 * @param aprovada
	 *            the new aprovada
	 */
	public void setAprovada(final boolean aprovada) {
		this.aprovada = aprovada;
	}

	/**
	 * Gets the usuarios.
	 * 
	 * @return the usuarios
	 */
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Sets the usuarios.
	 * 
	 * @param usuarios
	 *            the new usuarios
	 */
	public void setUsuarios(final Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * Gets the administradora.
	 * 
	 * @return the administradora
	 */
	public Administradora getAdministradora() {
		return administradora;
	}

	/**
	 * Sets the administradora.
	 * 
	 * @param administradora
	 *            the new administradora
	 */
	public void setAdministradora(final Administradora administradora) {
		this.administradora = administradora;
	}

	/**
	 * Gets the gerente admin.
	 * 
	 * @return the gerente admin
	 */
	public GerenteAdministradora getGerenteAdmin() {
		return gerenteAdmin;
	}

	/**
	 * Sets the gerente admin.
	 * 
	 * @param gerenteAdmin
	 *            the new gerente admin
	 */
	public void setGerenteAdmin(final GerenteAdministradora gerenteAdmin) {
		this.gerenteAdmin = gerenteAdmin;
	}

	/**
	 * Gets the fornecedores.
	 * 
	 * @return the fornecedores
	 */
	public Collection<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	/**
	 * Sets the fornecedores.
	 * 
	 * @param fornecedores
	 *            the new fornecedores
	 */
	public void setFornecedores(final Collection<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	/**
	 * Gets the fornecedor vencedor.
	 * 
	 * @return the fornecedor vencedor
	 */
	public Fornecedor getFornecedorVencedor() {
		return fornecedorVencedor;
	}

	/**
	 * Sets the fornecedor vencedor.
	 * 
	 * @param fornecedorVencedor
	 *            the new fornecedor vencedor
	 */
	public void setFornecedorVencedor(final Fornecedor fornecedorVencedor) {
		this.fornecedorVencedor = fornecedorVencedor;
	}

}
