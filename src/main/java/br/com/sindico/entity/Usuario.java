package br.com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table (name= "USUARIO")
public class Usuario {
	
	/** The codigo. */
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name = "USUARIO_ID")
	private int			codigo;
	
	@Column (name="NOME", length=20)
	private String nome;
	
	@Column (name="SOBRENOME", length=45)
	private String sobrenome;
	
	@Column (name="SENHA", length=10)
	private String senha;
	
	@Column (name="TELEFONE", length=20)
	private String telefone;
	
	@Column (name="CELULAR", length=20)
	private String celular;
	
	@Column (name="FAX", length=20)
	private String fax;
	
	@Column (name="TELEFONE_COMERCIAL", length=20)
	private String telefoneComercial;
	
	@Column(name="DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column (name="DATA_NASCIMENTO")
	private Date dataNascimento;
	
	@Column (name="EMAIL", length=50)
	private String email;
	
	/** The recebe cotacao. */
	@Column (name="RECEBE_COTACAO")
	private boolean		recebeCotacao;
	
	/** The tipo. */
	@Column (name="TIPO")
	private char		tipo;					// s = sindico, c = conselho, m
												// = morador e z = zelador

	@ManyToMany(mappedBy="usuarios")
	private Collection<Cotacao> cotacoes = new ArrayList<Cotacao>();
	
	public int getCodigo() {
		return codigo;
	}

	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRecebeCotacao() {
		return recebeCotacao;
	}

	public void setRecebeCotacao(boolean recebeCotacao) {
		this.recebeCotacao = recebeCotacao;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	
}
