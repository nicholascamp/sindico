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

/**
 * @author Lucas
 * 
 */
@Controller
@RequestMapping("email")
@Transactional
public class EmailController {

	/** The email service. */
	@Autowired
	private EmailService		emailService;

	@Autowired
	private FornecedorService	fornecedorService;

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
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public void enviarEmail(@RequestParam("mensagem") final String mensagem,
			@RequestParam("titulo") final String titulo) {

		String destinatario = "";

		if (usuarioService.ehUsuarioLogado()) {
			destinatario = usuarioService.getLoggedUser().getEmail();
		} else {
			destinatario = fornecedorService.getLoggedFornecedor().getEmail();
		}

		emailService.enviarEmail(mensagem, destinatario, titulo);
	}

}
