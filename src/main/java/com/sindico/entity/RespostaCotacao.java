package br.com.sindico.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="RESPOSTA_COTACAO")
public class RespostaCotacao {
	
	@Id @GeneratedValue
	@Column(name="RESPOSTA_COTACAO_ID")
	private int codigo;
	
	@Column(name="PRIMEIRA_RESPOSTA")
	private String primeiraResposta;
	
	@Column(name="VALOR")
	private float valor;
	
	@Column(name="CONDICAO")
	private int condicao; // PERGUNTAR O QUE É
	
	@Column(name="GARANTIA")
	private int garantia;
	
	@Column(name="PRAZO")
	private String prazo; // PERGUNTAR O QUE É
	
	@ElementCollection
	private Collection<String> listaRespostas = new ArrayList<String>();
	
	@Column(name="ATENDE_AREA")
	private boolean atendeArea;
	
	@Column(name="APROVADO")
	private boolean aprovado;
	
	@Column(name="PARCELA_PARA")
	private int parcelaPara; // PERGUNTAR O QUE É
	
	@Column(name="ARQUIVO_FOTO")
	private String arquivoFoto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPrimeiraResposta() {
		return primeiraResposta;
	}

	public void setPrimeiraResposta(String primeiraResposta) {
		this.primeiraResposta = primeiraResposta;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getCondicao() {
		return condicao;
	}

	public void setCondicao(int condicao) {
		this.condicao = condicao;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public Collection<String> getListaRespostas() {
		return listaRespostas;
	}

	public void setListaRespostas(Collection<String> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}

	public boolean isAtendeArea() {
		return atendeArea;
	}

	public void setAtendeArea(boolean atendeArea) {
		this.atendeArea = atendeArea;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public int getParcelaPara() {
		return parcelaPara;
	}

	public void setParcelaPara(int parcelaPara) {
		this.parcelaPara = parcelaPara;
	}

	public String getArquivoFoto() {
		return arquivoFoto;
	}

	public void setArquivoFoto(String arquivoFoto) {
		this.arquivoFoto = arquivoFoto;
	}

}
