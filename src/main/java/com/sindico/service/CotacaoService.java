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

	/**
	 * List cotacoes.
	 * 
	 * @return the list
	 */
	@Transactional
	List<Cotacao> listCotacoes();

	/**
	 * List cotacoes.
	 * 
	 * @param usuarioId
	 *            the usuario id
	 * @return the list
	 */
	@Transactional
	List<Cotacao> listCotacoes(Long usuarioId);

	/**
	 * List cotacoes.
	 * 
	 * @param predio
	 *            the predio
	 * @return the list
	 */
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

	/**
	 * Gets the cotacao.
	 * 
	 * @param id
	 *            the id
	 * @return the cotacao
	 */
	@Transactional
	Cotacao getCotacao(Long id);

	/**
	 * Remover cotacao.
	 * 
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
	@Transactional
	boolean removerCotacao(Long id);

	/**
	 * Gets the resposta cotacao.
	 * 
	 * @param id
	 *            the id
	 * @return the resposta cotacao
	 */
	@Transactional
	RespostaCotacao getRespostaCotacao(Long id);

	/**
	 * List respostas cotacao.
	 * 
	 * @return the list
	 */
	@Transactional
	List<RespostaCotacao> listRespostasCotacao();

	/**
	 * List respostas cotacao.
	 * 
	 * @param idCotacao
	 *            the id cotacao
	 * @param idFornecedor
	 *            the id fornecedor
	 * @return the list
	 */
	@Transactional
	List<RespostaCotacao> listRespostasCotacao(Long idCotacao, Long idFornecedor);

	/**
	 * List respostas cotacao.
	 * 
	 * @param idCotacao
	 *            the id cotacao
	 * @return the list
	 */
	@Transactional
	List<RespostaCotacao> listRespostasCotacao(Long idCotacao);

	/**
	 * List respostas cotacao historico.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @return the list
	 */
	@Transactional
	List<RespostaCotacao> listRespostasCotacaoHistorico(Cotacao cotacao);

	/**
	 * Update resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 * @return the resposta cotacao
	 */
	@Transactional
	RespostaCotacao updateRespostaCotacao(RespostaCotacao respostaCotacao);

	/**
	 * Removes the resposta cotacao.
	 * 
	 * @param id
	 *            the id
	 */
	@Transactional
	void removeRespostaCotacao(Long id);

	/**
	 * Cria resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 * @return the resposta cotacao
	 */
	@Transactional
	RespostaCotacao criaRespostaCotacao(RespostaCotacao respostaCotacao);

	/**
	 * Possui negociacao aberta.
	 * 
	 * @param cotacaoId
	 *            the cotacao id
	 * @param fornecedorId
	 *            the fornecedor id
	 * @return true, if successful
	 */
	@Transactional
	boolean possuiNegociacaoAberta(long cotacaoId, long fornecedorId);

	/**
	 * Adicionar gerente.
	 * 
	 * @param email
	 *            the email
	 * @param cotacaoId
	 *            the cotacao id
	 * @throws Exception
	 *             the exception
	 */
	@Transactional
	void adicionarGerente(String email, Long cotacaoId) throws Exception;

	/**
	 * Adicionar usuario.
	 * 
	 * @param email
	 *            the email
	 * @param cotacaoId
	 *            the cotacao id
	 * @throws Exception
	 *             the exception
	 */
	@Transactional
	void adicionarUsuario(String email, Long cotacaoId) throws Exception;
}
