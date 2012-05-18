package com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class RespostaCotacao.
 */
@Entity
@Table(name = "RESPOSTA_COTACAO")
public class RespostaCotacao {

	/** The codigo. */
	@Id
	@GeneratedValue
	@Column(name = "RESPOSTA_COTACAO_ID")
	private int codigo;

	/** The primeira resposta. */
	@Column(name = "PRIMEIRA_RESPOSTA")
	private String primeiraResposta;

	/** The valor. */
	@Column(name = "VALOR")
	private float valor;

	/** The condicao. */
	@Column(name = "CONDICAO")
	private int condicao; // PERGUNTAR O QUE É

	/** The garantia. */
	@Column(name = "GARANTIA")
	private int garantia;

	/** The prazo. */
	@Column(name = "PRAZO")
	private String prazo; // PERGUNTAR O QUE É

	/** The lista respostas. */
	@ElementCollection
	private Collection<String> listaRespostas = new ArrayList<String>();

	/** The atende area. */
	@Column(name = "ATENDE_AREA")
	private boolean atendeArea;

	/** The aprovado. */
	@Column(name = "APROVADO")
	private boolean aprovado;

	/** The parcela para. */
	@Column(name = "PARCELA_PARA")
	private int parcelaPara; // PERGUNTAR O QUE É

	/** The arquivo foto. */
	@Column(name = "ARQUIVO_FOTO")
	private String arquivoFoto;

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

	/**
	 * Gets the condicao.
	 * 
	 * @return the condicao
	 */
	public int getCondicao() {
		return condicao;
	}

	/**
	 * Sets the condicao.
	 * 
	 * @param condicao
	 *            the new condicao
	 */
	public void setCondicao(final int condicao) {
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
	 * Checks if is aprovado.
	 * 
	 * @return true, if is aprovado
	 */
	public boolean isAprovado() {
		return aprovado;
	}

	/**
	 * Sets the aprovado.
	 * 
	 * @param aprovado
	 *            the new aprovado
	 */
	public void setAprovado(final boolean aprovado) {
		this.aprovado = aprovado;
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
