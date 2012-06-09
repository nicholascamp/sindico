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
import com.sindico.enums.TipoUsuario;
import com.sindico.service.impl.SindicoUserDetailsServiceImpl;
import com.sindico.utils.StringUtils;

/**
 * Servlet implementation class UsuarioController.
 */
@Controller
@SessionAttributes
public class UsuarioController {

	@Autowired
	private SindicoUserDetailsServiceImpl	sindicoUserDetailsServiceImpl;

	@RequestMapping(method = RequestMethod.GET, value = "/usuario/cria")
	public ModelAndView usuarioForm() {
		ModelAndView modelAndView = new ModelAndView("usuario/criaUsuario",
				"usuario", new Usuario());

		modelAndView.addObject("tipos", TipoUsuario.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "usuario/login")
	public ModelAndView usuarioLogin() {

		System.out.println("Loga Usuario");
		return new ModelAndView("usuario/login");
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
	@RequestMapping(value = "/usuario/cria", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("usuario") final Usuario usuario,
			final BindingResult result) throws Exception {

		usuario.setPassword(StringUtils.encodePassword(usuario.getPassword(),
				usuario.getUsername()));
		sindicoUserDetailsServiceImpl.criarUsuario(usuario);

		return "redirect:/usuario/login";
	}

	/**
	 * Show contacts.
	 * 
	 * @return the model and view
	 */
	@RequestMapping("/usuario/lista")
	public ModelAndView showUsuarios() {

		return new ModelAndView("usuario", "command", new Usuario());
	}
}
