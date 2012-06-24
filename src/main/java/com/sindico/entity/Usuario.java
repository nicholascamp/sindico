package com.sindico.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import org.hibernate.validator.Email;
import org.hibernate.validator.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.sindico.enums.TipoUsuario;

/**
 * The Class Usuario.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable, UserDetails {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 4246251615358359325L;

	@Id
	@GeneratedValue
	private Long				id;

	/** The nome. */
	@Column(name = "NOME", length = 60, nullable = false)
	@NotNull(message = "Usuário deve ter um nome")
	private String				nome;

	/** The senha. */
	@Column(name = "PASSWORD", nullable = false)
	@NotNull(message = "Usuário deve ter uma senha")
	private String				password;

	/** The username. */
	@Column(name = "USERNAME", nullable = false, unique = true)
	@NotNull(message = "Usuário deve ter um login")
	private String				username;

	/** The telefone. */
	@Column(name = "TELEFONE", length = 20)
	private String				telefone;

	/** The celular. */
	@Column(name = "CELULAR", length = 20)
	private String				celular;

	/** The data cadastro. */
	@Column(name = "DATA_CADASTRO")
	private Date				dataCadastro		= new Date();

	/** The data nascimento. */
	@Column(name = "DATA_NASCIMENTO")
	private Date				dataNascimento;

	/** The email. */
	@Column(name = "EMAIL", length = 50, nullable = false, unique = true)
	@NotNull(message = "Usuário deve possuir um email")
	@Email
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

	/** The admin. */
	@Column(name = "ADMIN")
	private boolean				admin				= false;

	/**
	 * Instantiates a new usuario.
	 * 
	 * @param nome
	 *            the nome
	 * @param password
	 *            the password
	 * @param email
	 *            the email
	 */
	public Usuario(final String nome, final String password, final String email) {
		this.nome = nome;
		this.password = password;
		this.email = email;
	}

	/**
	 * 
	 */
	public Usuario() {
		super();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getAuthorities
	 * ()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		if (isAdmin()) {
			authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		} else {
			authorities.add(new GrantedAuthorityImpl("ROLE_USUARIO"));
		}

		return authorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired
	 * ()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked
	 * ()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * Checks if is admin.
	 * 
	 * @return true, if is admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Sets the admin.
	 * 
	 * @param admin
	 *            the new admin
	 */
	public void setAdmin(final boolean admin) {
		this.admin = admin;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

}
