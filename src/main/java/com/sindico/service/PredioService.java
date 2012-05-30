/**
 * 
 */
package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Predio;

/**
 * The Interface PredioService.
 */
public interface PredioService {

	/**
	 * Listar predios.
	 * 
	 * @return the list
	 */
	@Transactional
	List<Predio> listarPredios();

}
