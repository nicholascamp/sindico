/**
 * 
 */
package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Predio;
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
	
	@Transactional
	List<Cotacao> listCotacoes(Long usuarioId);
	
	@Transactional
	List<Cotacao> listCotacoes(Predio predio);

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
	
	@Transactional
	boolean removerCotacao(Long id);
	
	@Transactional
	RespostaCotacao getRespostaCotacao(Long id);
	
	@Transactional
	List<RespostaCotacao> listRespostasCotacao();
	
	@Transactional
	List<RespostaCotacao> listRespostasCotacao(Long idCotacao, Long idFornecedor);
	
	@Transactional
	List<RespostaCotacao> listRespostasCotacao(Long idCotacao);
	
	@Transactional
	List<RespostaCotacao> listRespostasCotacaoHistorico(Cotacao cotacao);
	
	@Transactional
	RespostaCotacao updateRespostaCotacao(RespostaCotacao respostaCotacao);
	
	@Transactional
	void removeRespostaCotacao(Long id);
	
	@Transactional
	RespostaCotacao criaRespostaCotacao(RespostaCotacao respostaCotacao);	
}
