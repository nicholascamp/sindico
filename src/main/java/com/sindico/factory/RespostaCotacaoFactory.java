package com.sindico.factory;

import java.util.Collection;

import com.sindico.entity.RespostaCotacao;

public class RespostaCotacaoFactory {
	
	public static RespostaCotacao criaRespostaCotacao(String primeiraResposta, float valor, String condicao, int garantia, String prazo,
			Collection<String> listaRespostas, boolean atendeArea, int parcelaPara, String arquivoFoto){
		
		RespostaCotacao resposta = new RespostaCotacao();
		resposta.setPrimeiraResposta(primeiraResposta);
		resposta.setValor(valor);
		resposta.setCondicao(condicao);
		resposta.setGarantia(garantia);
		resposta.setPrazo(prazo);
		resposta.setListaRespostas(listaRespostas);
		resposta.setAtendeArea(atendeArea);
		resposta.setParcelaPara(parcelaPara);
		resposta.setArquivoFoto(arquivoFoto);
		return resposta;
	}
}
