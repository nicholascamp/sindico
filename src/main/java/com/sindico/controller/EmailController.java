/**
 * 
 */
package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sindico.service.EmailService;
import com.sindico.service.FornecedorService;
import com.sindico.service.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailController.
 * 
 * @author Lucas
 */
@Controller
@RequestMapping("email")
@Transactional
public class EmailController {

	/** The email service. */
	@Autowired
	private EmailService		emailService;

	/** The fornecedor service. */
	@Autowired
	private FornecedorService	fornecedorService;

	/** The usuario service. */
	@Autowired
	private UsuarioService		usuarioService;

	/**
	 * Enviar email.
	 * 
	 * @param mensagem
	 *            the mensagem
	 * @param titulo
	 *            the titulo
	 */
	@RequestMapping(value = "cadastro", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public void enviarEmailCadastro(
			@RequestParam("mensagem") final String mensagem,
			@RequestParam("titulo") final String titulo) {

		String destinatario = getLogedUserEmail();

		emailService.emailCadastro(mensagem, destinatario);
	}

	@RequestMapping(value = "pedidoCotacao", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public void enviarEmailPedidoCotacao(
			@RequestParam("mensagem") final String mensagem,
			@RequestParam("titulo") final String titulo) {

		String destinatario = getLogedUserEmail();

		emailService.emailCadastro(mensagem, destinatario);
	}

	@RequestMapping(value = "respostaCotacao", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public void enviarEmailRespostaCotacao(
			@RequestParam("mensagem") final String mensagem,
			@RequestParam("titulo") final String titulo) {

		String destinatario = getLogedUserEmail();

		emailService.emailCadastro(mensagem, destinatario);
	}

	/**
	 * Gets the loged user email.
	 * 
	 * @return the loged user email
	 */
	private String getLogedUserEmail() {

		if (usuarioService.ehUsuarioLogado()) {
			return usuarioService.getLoggedUser().getEmail();
		}
		return fornecedorService.getLoggedFornecedor().getEmail();
	}

}
