/**
 * 
 */
package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.PredioDAO;
import com.sindico.entity.Predio;
import com.sindico.service.PredioService;

/**
 * The Class PredioServiceImpl.
 */
@Service("predioService")
public class PredioServiceImpl implements PredioService {

	/** The predio dao. */
	@Autowired
	private PredioDAO predioDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.PredioService#listarPredios()
	 */
	@Override
	public List<Predio> listarPredios() {

		return predioDAO.listarPredios();
	}

	/**
	 * Criar predio.
	 * 
	 * @param predio
	 *            the predio
	 * @return the predio
	 */
	@Override
	public Predio criarPredio(final Predio predio) {

		return predioDAO.criaPredio(predio);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.PredioService#buscarPredioPorNome(java.lang.String)
	 */
	@Override
	public List<Predio> buscarPredioPorNome(final String nome) {
		return predioDAO.buscarPredioPorNome(nome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.PredioService#buscarPredioPorEndereco(java.lang.String
	 * )
	 */
	@Override
	public List<Predio> buscarPredioPorEndereco(final String endereco) {
		return predioDAO.buscarPredioPorEndereco(endereco);
	}
}
