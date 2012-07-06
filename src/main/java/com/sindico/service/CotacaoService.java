/**
 * 
 */
package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Cotacao;
import com.sindico.entity.RespostaCotacao;

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
	
	@Transactional
	List<Cotacao> listCotacoes();

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
	
	@Transactional
	Cotacao getCotacao(Long id);

	/**
	 * Listar respostas.
	 * 
	 * @param id
	 *            the id
	 * @return the cotacao
	 */
	@Transactional
	List<RespostaCotacao> listarRespostas(Long id);
	
	@Transactional
	boolean removerCotacao(Long id);
	
	@Transactional
	RespostaCotacao getRespostaCotacao(Long id);
	
	@Transactional
	List<RespostaCotacao> listRespostasCotacao();
	
	@Transactional
	RespostaCotacao updateRespostaCotacao(RespostaCotacao respostaCotacao);
	
	@Transactional
	void removeRespostaCotacao(Long id);
	
	@Transactional
	RespostaCotacao criaRespostaCotacao(RespostaCotacao respostaCotacao);
}
