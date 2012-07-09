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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.NotNull;

import com.sindico.enums.Status;

// TODO: Auto-generated Javadoc
/**
 * The Class Cotacao.
 */
@Entity
@Table(name = "COTACAO")
public class Cotacao {

	@Id
	@GeneratedValue
	@Column(name = "COTACAO_ID")
	private Long					id;

	/** The data. */
	@Column(name = "DATA")
	private Date					data;

	/** The data atualizacao. */
	@Column(name = "DATA_ATUALIZACAO")
	private Date					dataAtualizacao;

	/** The subcategoria. */
	@ManyToOne
	@JoinColumn(name = "SUBCATEGORIA_ID")
	@NotNull
	private Subcategoria			subcategoria;

	/** The status. */
	@Column(name = "STATUS")
	private Status					status;

	/** The impropria. */
	@Column(name = "IMPROPRIA")
	private boolean					impropria;

	/** The usuario. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario					usuario;

	/** The gerente admin. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GERENTE_ID")
	private GerenteAdministradora	gerenteAdmin;

	/** The fornecedores. */
	@ManyToMany
	@JoinTable(name = "COTACAO_FORNECEDOR")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Fornecedor>	fornecedores	= new ArrayList<Fornecedor>();

	/** The fornecedor vencedor. */
	@ManyToOne
	@JoinColumn(name = "FORNECEDOR_ID")
	private Fornecedor				fornecedorVencedor;

	/** The titulo. */
	@Column(name = "TITULO", nullable = false)
	private String					titulo;
	
	@OneToOne
	@JoinColumn(name = "RESPOSTA_COTACAO_VENCEDORA")
	private RespostaCotacao respostaCotacaoVencedora;

	@OneToMany(mappedBy = "cotacao")
	private Collection<RespostaCotacao> respostasCotacao = new ArrayList<RespostaCotacao>();
	
	public RespostaCotacao getRespostaCotacaoVencedora() {
		return respostaCotacaoVencedora;
	}

	public void setRespostaCotacaoVencedora(RespostaCotacao respostaCotacaoVencedora) {
		this.respostaCotacaoVencedora = respostaCotacaoVencedora;
	}

	public Collection<RespostaCotacao> getRespostasCotacao() {
		return respostasCotacao;
	}

	public void setRespostasCotacao(Collection<RespostaCotacao> respostasCotacao) {
		this.respostasCotacao = respostasCotacao;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the data atualizacao.
	 * 
	 * @return the data atualizacao
	 */
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	/**
	 * Sets the data atualizacao.
	 * 
	 * @param dataAtualizacao
	 *            the new data atualizacao
	 */
	public void setDataAtualizacao(final Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
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
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
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

	/**
	 * Checks if is impropria.
	 * 
	 * @return true, if is impropria
	 */
	public boolean isImpropria() {
		return impropria;
	}

	/**
	 * Sets the impropria.
	 * 
	 * @param impropria
	 *            the new impropria
	 */
	public void setImpropria(final boolean impropria) {
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
