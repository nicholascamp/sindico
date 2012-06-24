/**
 * 
 */
package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.CotacaoDAO;
import com.sindico.entity.Cotacao;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.CotacaoService#listarRespostas(java.lang.Long)
	 */
	@Override
	public Cotacao listarRespostas(final Long id) {
		return null;
	}

	@Override
	public List<Cotacao> listCotacoes() {
		// TODO Auto-generated method stub
		return cotacaoDAO.getLista();
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

}
