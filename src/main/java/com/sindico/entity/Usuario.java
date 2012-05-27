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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.NotNull;

import com.sindico.enums.TipoUsuario;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 4246251615358359325L;

	/** The codigo. */
	@Id
	@GeneratedValue
	private Long				id;

	/** The nome. */
	@Column(name = "NOME", length = 60, nullable = false)
	@NotNull(message = "Usuário deve ter um nome")
	private String				nome;

	/** The senha. */
	@Column(name = "SENHA", length = 20, nullable = false)
	@NotNull(message = "Usuário deve ter uma senha")
	private String				senha;

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20)
	private String				telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String				celular;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date				dataCadastro;

	/** The data nascimento. */
	@Column(name = "DATA_NASCIMENTO")
	private Date				dataNascimento;

	/** The email. */
	@Column(name = "EMAIL", length = 50, nullable = false, unique = true)
	@NotNull(message = "Usuário deve possuir um email")
	private String				email;

	/** The recebe cotacao. */
	@Column(name = "RECEBE_COTACAO")
	private boolean				recebeCotacao;

	/** The tipo. */
	@Column(name = "TIPO")
	private TipoUsuario			tipo;

	/** The cotacoes. */
	@Transient
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Collection<Cotacao>	cotacoes			= new ArrayList<Cotacao>();

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
	}

	/**
	 * Instantiates a new usuario.
	 * 
	 * @param nome
	 *            the nome
	 * @param senha
	 *            the senha
	 * @param email
	 *            the email
	 */
	public Usuario(final String nome, final String senha, final String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
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
	 * Gets the senha.
	 * 
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Sets the senha.
	 * 
	 * @param senha
	 *            the new senha
	 */
	public void setSenha(final String senha) {
		this.senha = senha;
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
	 * Gets the data nascimento.
	 * 
	 * @return the data nascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Sets the data nascimento.
	 * 
	 * @param dataNascimento
	 *            the new data nascimento
	 */
	public void setDataNascimento(final Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	 * Checks if is recebe cotacao.
	 * 
	 * @return true, if is recebe cotacao
	 */
	public boolean isRecebeCotacao() {
		return recebeCotacao;
	}

	/**
	 * Sets the recebe cotacao.
	 * 
	 * @param recebeCotacao
	 *            the new recebe cotacao
	 */
	public void setRecebeCotacao(final boolean recebeCotacao) {
		this.recebeCotacao = recebeCotacao;
	}

	/**
	 * Gets the tipo.
	 * 
	 * @return the tipo
	 */
	public TipoUsuario getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 * 
	 * @param tipo
	 *            the new tipo
	 */
	public void setTipo(final TipoUsuario tipo) {
		this.tipo = tipo;
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

}
