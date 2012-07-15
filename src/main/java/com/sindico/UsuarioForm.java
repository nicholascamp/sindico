/**
 * 
 */
package com.sindico;

import java.util.Date;

import org.hibernate.validator.Email;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotNull;

import com.sindico.enums.TipoUsuario;

/**
 * @author Lucas
 * 
 */
public class UsuarioForm {

	@NotNull(message = "Usuário deve ter um nome")
	@Max(value = 60)
	private String		nome;

	@NotNull(message = "Usuário deve ter uma senha")
	private String		password;

	@Max(value = 20)
	private String		telefone;

	@Max(value = 20)
	private String		celular;

	private Date		dataNascimento;

	@Max(value = 50)
	@NotNull(message = "Usuário deve possuir um email")
	@Email
	private String		email;

	private boolean		recebeCotacao;

	@NotNull
	private TipoUsuario	tipo;

	@Max(value = 8)
	@Min(value = 8)
	@NotNull
	private String		cep;

	@NotNull
	private Integer		numero;

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(final String celular) {
		this.celular = celular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public boolean isRecebeCotacao() {
		return recebeCotacao;
	}

	public void setRecebeCotacao(final boolean recebeCotacao) {
		this.recebeCotacao = recebeCotacao;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(final TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(final String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(final Integer numero) {
		this.numero = numero;
	}

}
