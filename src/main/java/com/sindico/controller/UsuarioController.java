package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Usuario;
import com.sindico.service.impl.SindicoUserDetailsServiceImpl;

/**
 * Servlet implementation class UsuarioController.
 */
@Controller
@SessionAttributes
public class UsuarioController {

	@Autowired
	private SindicoUserDetailsServiceImpl	sindicoUserDetailsServiceImpl;

	@RequestMapping(method = RequestMethod.GET, value = "/criaUsuario.html")
	public ModelAndView usuarioForm() {

		System.out.println("Cria Usuario");
		return new ModelAndView("/criaUsuario", "usuario", new Usuario());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login.html")
	public ModelAndView usuarioLogin() {

		System.out.println("Loga Usuario");
		return new ModelAndView("/login");
	}

	/**
	 * Adds the contact.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param result
	 *            the result
	 * @return the string
	 * @throws Exception
	 */
	@RequestMapping(value = "/criaUsuario", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("usuario") final Usuario usuario,
			final BindingResult result) throws Exception {

		// String password = usuario.getPassword();
		// usuario.setPassword(StringUtils.encodePassword(password));
		sindicoUserDetailsServiceImpl.criarUsuario(usuario);

		return "redirect:/login.html";
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
