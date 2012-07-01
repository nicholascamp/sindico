package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 * The Class RespostaCotacao.
 */
@Entity
@Table(name = "RESPOSTA_COTACAO")
public class RespostaCotacao {

	@Id
	@GeneratedValue
	@Column(name = "RESPOSTA_COTACAO_ID")
	private Long				id;
	
	@ManyToOne
	@JoinColumn(name = "COTACAO_ID")
	private Cotacao cotacao;
	
	@ManyToOne
	@JoinColumn(name = "FORNECEDOR_ID")
	private Fornecedor fornecedor;

	/** The primeira resposta. */
	@Column(name = "PRIMEIRA_RESPOSTA", columnDefinition = "TEXT")
	private String				primeiraResposta;

	/** The valor. */
	@Column(name = "VALOR", nullable = false)
	@NotNull(message = "Insira um valor")
	private float				valor;

	/** The condicao. */
	@Column(name = "CONDICAO", length = 50, nullable = false)
	@NotNull(message = "Insira uma condição")
	private String				condicao;

	/** The garantia. */
	@Column(name = "GARANTIA", nullable = false)
	@NotNull(message = "Insira um garantia")
	private int					garantia;

	/** The prazo. */
	@Column(name = "PRAZO", length = 100, nullable = false)
	@NotNull(message = "Insira um prazo de entrega")
	private String				prazo;

	/** The lista respostas. */
	@ElementCollection
	@CollectionTable(
			name = "RESPOSTA_COTACAO_LISTA", joinColumns = @JoinColumn(
					name = "RESPOSTA_COTACAO_ID", columnDefinition = "TEXT"))
	private Collection<String>	listaRespostas	= new ArrayList<String>();

	/** The atende area. */
	@Column(name = "ATENDE_AREA")
	private boolean				atendeArea;

	/** The parcela para. */
	@Column(name = "PARCELA_PARA")
	private int					parcelaPara;								// PERGUNTAR
																			// O
																			// QUE
																			// É

	/** The arquivo foto. */
	@Column(name = "ARQUIVO_FOTO")
	private String				arquivoFoto;
			
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the primeira resposta.
	 * 
	 * @return the primeira resposta
	 */
	public String getPrimeiraResposta() {
		return primeiraResposta;
	}

	/**
	 * Sets the primeira resposta.
	 * 
	 * @param primeiraResposta
	 *            the new primeira resposta
	 */
	public void setPrimeiraResposta(final String primeiraResposta) {
		this.primeiraResposta = primeiraResposta;
	}

	/**
	 * Gets the valor.
	 * 
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * Sets the valor.
	 * 
	 * @param valor
	 *            the new valor
	 */
	public void setValor(final float valor) {
		this.valor = valor;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(final String condicao) {
		this.condicao = condicao;
	}

	/**
	 * Gets the garantia.
	 * 
	 * @return the garantia
	 */
	public int getGarantia() {
		return garantia;
	}

	/**
	 * Sets the garantia.
	 * 
	 * @param garantia
	 *            the new garantia
	 */
	public void setGarantia(final int garantia) {
		this.garantia = garantia;
	}

	/**
	 * Gets the prazo.
	 * 
	 * @return the prazo
	 */
	public String getPrazo() {
		return prazo;
	}

	/**
	 * Sets the prazo.
	 * 
	 * @param prazo
	 *            the new prazo
	 */
	public void setPrazo(final String prazo) {
		this.prazo = prazo;
	}

	/**
	 * Gets the lista respostas.
	 * 
	 * @return the lista respostas
	 */
	public Collection<String> getListaRespostas() {
		return listaRespostas;
	}

	/**
	 * Sets the lista respostas.
	 * 
	 * @param listaRespostas
	 *            the new lista respostas
	 */
	public void setListaRespostas(final Collection<String> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}

	/**
	 * Checks if is atende area.
	 * 
	 * @return true, if is atende area
	 */
	public boolean isAtendeArea() {
		return atendeArea;
	}

	/**
	 * Sets the atende area.
	 * 
	 * @param atendeArea
	 *            the new atende area
	 */
	public void setAtendeArea(final boolean atendeArea) {
		this.atendeArea = atendeArea;
	}

	/**
	 * Gets the parcela para.
	 * 
	 * @return the parcela para
	 */
	public int getParcelaPara() {
		return parcelaPara;
	}

	/**
	 * Sets the parcela para.
	 * 
	 * @param parcelaPara
	 *            the new parcela para
	 */
	public void setParcelaPara(final int parcelaPara) {
		this.parcelaPara = parcelaPara;
	}

	/**
	 * Gets the arquivo foto.
	 * 
	 * @return the arquivo foto
	 */
	public String getArquivoFoto() {
		return arquivoFoto;
	}

	/**
	 * Sets the arquivo foto.
	 * 
	 * @param arquivoFoto
	 *            the new arquivo foto
	 */
	public void setArquivoFoto(final String arquivoFoto) {
		this.arquivoFoto = arquivoFoto;
	}

}
