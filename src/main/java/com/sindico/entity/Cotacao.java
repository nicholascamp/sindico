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

import org.hibernate.validator.NotNull;

import com.sindico.enums.Status;

// TODO: Auto-generated Javadoc
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
	private int						codigo;

	/** The data. */
	@Column(name = "DATA")
	private Date					data;

	/** The subcategoria. */
	@ManyToOne(optional=false)
	@JoinColumn(name = "SUBCATEGORIA_ID")
	@NotNull(message="É necessário definir uma subcategoria")
	private Subcategoria			subcategoria;

	/** The status. */
	@Column(name = "STATUS")
	private Status					status;

	/** The aprovada. */
	@Column(name = "IMPROPRIA")
	private boolean					impropria;

	/** The usuario. */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario					usuario;

	/** The gerente admin. */
	@ManyToOne
	@JoinColumn(name = "GERENTE_ID")
	private GerenteAdministradora	gerenteAdmin;

	/** The fornecedores. */
	@ManyToMany
	@JoinTable(name = "COTACAO_FORNECEDOR", joinColumns = @JoinColumn(
			name = "COTACAO_ID"), inverseJoinColumns = @JoinColumn(
			name = "FORNECEDOR_ID"))
	@NotNull
	private Collection<Fornecedor>	fornecedores	= new ArrayList<Fornecedor>();

	/** The fornecedor vencedor. */
	@ManyToOne
	@JoinColumn(name = "FORNECEDOR_ID")
	private Fornecedor				fornecedorVencedor;
	
	@Column(name="TITULO", columnDefinition="TEXT", nullable=false)
	private String titulo;
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status
	 *            the new status
	 */
	public void setStatus(final Status status) {
		this.status = status;
	}

	

	public boolean isImpropria() {
		return impropria;
	}

	public void setImpropria(boolean impropria) {
		this.impropria = impropria;
	}

	/**
	 * Gets the usuario.
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 * 
	 * @param usuario
	 *            the new usuario
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
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
