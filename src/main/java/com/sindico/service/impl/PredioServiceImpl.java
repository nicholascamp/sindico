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
}
