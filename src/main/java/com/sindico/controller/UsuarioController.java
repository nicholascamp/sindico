package com.sindico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Usuario;

/**
 * Servlet implementation class UsuarioController.
 */
@Controller
@SessionAttributes
public class UsuarioController {

	@RequestMapping(method = RequestMethod.GET, value = "/criaUsuario.html")
	public ModelAndView usuarioForm() {
		System.out.println("Cria Usuario");
		return new ModelAndView("/criaUsuario", "usuario", new Usuario());
	}

	/**
	 * Adds the contact.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param result
	 *            the result
	 * @return the string
	 */
	@RequestMapping(value = "/criaUsuario", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("usuario") final Usuario usuario,
			final BindingResult result) {

		System.out.println("First Name:" + usuario.getNome());

		return "redirect:usuarios.html";
	}

	/**
	 * Show contacts.
	 * 
	 * @return the model and view
	 */
	@RequestMapping("/usuarios.html")
	public ModelAndView showContacts() {

		return new ModelAndView("usuario", "command", new Usuario());
	}
}
