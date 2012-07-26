/**
 * 
 */
package com.sindico.service;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmailService.
 * 
 * @author Lucas
 */
public interface EmailService {

	/**
	 * Enviar email.
	 * 
	 * @param mensagem
	 *            the mensagem
	 * @param destinatario
	 *            the destinatario
	 */
	void emailCadastro(String mensagem, String destinatario);

	/**
	 * Email pedido cotacao.
	 * 
	 * @param mensagem
	 *            the mensagem
	 * @param destinatario
	 *            the destinatario
	 */
	void emailPedidoCotacao(String mensagem, String destinatario);

	/**
	 * Email resposta cotacao.
	 * 
	 * @param mensagem
	 *            the mensagem
	 * @param destinatario
	 *            the destinatario
	 */
	void emailRespostaCotacao(String mensagem, String destinatario);

}
