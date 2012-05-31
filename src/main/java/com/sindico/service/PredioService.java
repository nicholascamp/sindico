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

	/**
	 * Criar predio.
	 * 
	 * @param predio
	 *            the predio
	 * @return the predio
	 */
	@Transactional
	Predio criarPredio(Predio predio);

	/**
	 * Buscar predio por nome.
	 * 
	 * @param nome
	 *            the nome
	 * @return the predio
	 */
	@Transactional
	List<Predio> buscarPredioPorNome(String nome);

	/**
	 * Buscar predio por endereco.
	 * 
	 * @param nome
	 *            the nome
	 * @return the predio
	 */
	@Transactional
	List<Predio> buscarPredioPorEndereco(String nome);

	/**
	 * Deletar predio.
	 * 
	 * @param id
	 *            the id
	 */
	@Transactional
	void deletarPredio(Long id);

	/**
	 * Atualizar predio.
	 * 
	 * @param predio
	 *            the predio
	 * @return the predio
	 */
	@Transactional
	Predio atualizarPredio(Predio predio);

	/**
	 * Gets the predio.
	 * 
	 * @param predio
	 *            the predio
	 * @return the predio
	 */
	@Transactional
	Predio getPredio(Long id);

}
