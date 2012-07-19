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
	 * @param titulo
	 *            the titulo
	 */
	void enviarEmail(String mensagem, String destinatario, String titulo);

}
