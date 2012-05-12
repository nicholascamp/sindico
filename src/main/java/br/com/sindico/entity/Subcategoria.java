package br.com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SUBCATEGORIA")
public class Subcategoria {
	
	@Id @GeneratedValue	
	@Column(name="SUBCATEGORIA_ID")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="CATEGORIA_ID")
	private Categoria categoria;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToMany(mappedBy="subcategorias")
	private Collection<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	@OneToMany(mappedBy="subcategoria")
	private Collection<Cotacao> cotacoes = new ArrayList<Cotacao>();

	public Collection<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Collection<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
