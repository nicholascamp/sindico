/**
 * 
 */
package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Cotacao;

// TODO: Auto-generated Javadoc
/**
 * The Interface CotacaoService.
 * 
 * @author Lucas
 */
public interface CotacaoService {

	/**
	 * Listar por fornecedor.
	 * 
	 * @param fornecedorId
	 *            the fornecedor id
	 * @return the list
	 */
	@Transactional
	List<Cotacao> listarPorFornecedor(Long fornecedorId);

	/**
	 * Criar cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @return the cotacao
	 */
	@Transactional
	Cotacao criarCotacao(Cotacao cotacao);

	/**
	 * Atualizar cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @return the cotacao
	 */
	@Transactional
	Cotacao atualizarCotacao(Cotacao cotacao);

	/**
	 * Listar respostas.
	 * 
	 * @param id
	 *            the id
	 * @return the cotacao
	 */
	@Transactional
	Cotacao listarRespostas(Long id);

}
