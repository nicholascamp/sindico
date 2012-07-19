/**
 * 
 */
package com.sindico.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.CotacaoDAO;
import com.sindico.dao.RespostaCotacaoDAO;
import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.Predio;
import com.sindico.entity.RespostaCotacao;
import com.sindico.service.CotacaoService;

// TODO: Auto-generated Javadoc
/**
 * The Class CotacaoServiceImpl.
 * 
 * @author Lucas
 */
@Service("cotacaoService")
public class CotacaoServiceImpl implements CotacaoService {

	@Autowired
	CotacaoDAO	cotacaoDAO;
	
	@Autowired
	RespostaCotacaoDAO respostaCotacaoDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#listarPorFornecedor(java.lang.Long)
	 */
	@Override
	public List<Cotacao> listarPorFornecedor(final Long fornecedorId) {
		return cotacaoDAO.listarPorFornecedor(fornecedorId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#criarCotacao(com.sindico.entity.Cotacao
	 * )
	 */
	@Override
	public Cotacao criarCotacao(final Cotacao cotacao) {
		return cotacaoDAO.criaCotacao(cotacao);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#atualizarCotacao(com.sindico.entity
	 * .Cotacao)
	 */
	@Override
	public Cotacao atualizarCotacao(final Cotacao cotacao) {
		return cotacaoDAO.atualizaCotacao(cotacao);
	}

	@Override
	public List<Cotacao> listCotacoes() {
		// TODO Auto-generated method stub
		return cotacaoDAO.getLista();
	}
	
	@Override
	public List<Cotacao> listCotacoes(Long usuarioId){
		return cotacaoDAO.getLista(usuarioId);
	}
	
	@Override
	public List<Cotacao> listCotacoes(Predio predio){
		return cotacaoDAO.getLista(predio);
	}

	@Override
	public boolean removerCotacao(final Long id) {
		// TODO Auto-generated method stub
		Cotacao cotacao = cotacaoDAO.getCotacao(id);
		if (cotacao != null) {
			cotacaoDAO.removeCotacao(id);
			return true;
		}
		return false;
	}

	@Override
	public Cotacao getCotacao(final Long id) {
		Cotacao cotacao = cotacaoDAO.getCotacao(id);
		return cotacao;
	}

	@Override
	public RespostaCotacao getRespostaCotacao(Long id) {
		return respostaCotacaoDAO.getRespostaCotacao(id);
	}

	@Override
	public List<RespostaCotacao> listRespostasCotacao() {		
		List<RespostaCotacao> respostaCotacao = respostaCotacaoDAO.getLista();
		return preencheRespostaCotacao(respostaCotacao);
	}

	@Override
	public List<RespostaCotacao> listRespostasCotacao(Long idCotacao,
			Long idFornecedor) {
		// TODO Auto-generated method stub
		List<RespostaCotacao> respostaCotacao = respostaCotacaoDAO.getLista(idCotacao, idFornecedor);
		return preencheRespostaCotacao(respostaCotacao);
	}
	
	@Override
	public List<RespostaCotacao> listRespostasCotacao(Long idCotacao){
		List<RespostaCotacao> respostaCotacao = respostaCotacaoDAO.getLista(idCotacao);
		return preencheRespostaCotacao(respostaCotacao);
	}
	
	@Override
	public List<RespostaCotacao> listRespostasCotacaoHistorico(Cotacao cotacao) {		
		List<RespostaCotacao> respostaCotacao = new ArrayList<RespostaCotacao>();
		
		for(Fornecedor fornecedor : cotacao.getFornecedores()){
			RespostaCotacao resposta = respostaCotacaoDAO.getRespostaCotacao(cotacao.getId(), fornecedor.getId());
			
			if(resposta != null)
				respostaCotacao.add(resposta);
		}
		return respostaCotacao;
	}
	
	@Override
	public boolean possuiNegociacaoAberta(long cotacaoId, long fornecedorId) {
		return (respostaCotacaoDAO.getRespostaCotacao(cotacaoId, fornecedorId) != null);
	}

	@Override
	public RespostaCotacao updateRespostaCotacao(RespostaCotacao respostaCotacao) {
		return respostaCotacaoDAO.atualizaRespostaCotacao(respostaCotacao);
	}
	

	@Override
	public void removeRespostaCotacao(Long id) {
		respostaCotacaoDAO.removeRespostaCotacao(id);
	}

	@Override
	public RespostaCotacao criaRespostaCotacao(RespostaCotacao respostaCotacao) {
		return respostaCotacaoDAO.criaRespostaCotacao(respostaCotacao);
	}
	
	public List<RespostaCotacao> preencheRespostaCotacao(List<RespostaCotacao> respostaCotacao){
		List<RespostaCotacao> aux = new ArrayList<RespostaCotacao>();
		
		for(RespostaCotacao resposta : respostaCotacao){
			if(verificaExistenciaFornecedor(aux, resposta))
				aux.add(resposta);
		}
		return aux;
	}
	
	public boolean verificaExistenciaFornecedor(List<RespostaCotacao> respostas, RespostaCotacao resposta){
		for(RespostaCotacao respostaAux : respostas){
			if(respostaAux.getFornecedor().equals(resposta.getFornecedor()))
				return false;
		}
		return true;
	}
}
