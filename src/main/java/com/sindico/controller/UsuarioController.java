package com.sindico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Usuario;
import com.sindico.entity.UsuarioSimples;
import com.sindico.enums.TipoUsuario;
import com.sindico.service.UsuarioService;
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

	@Autowired
	private UsuarioService					usuarioService;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public ModelAndView usuarioForm() {
		ModelAndView modelAndView = new ModelAndView("cadastro", "usuario",
				new Usuario());

		modelAndView.addObject("tipos", TipoUsuario.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/usuario/lista")
	public ModelAndView indexUsuario() {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuarios",
				"usuario", new UsuarioSimples());
		PagedListHolder<UsuarioSimples> pagedListHolder = new PagedListHolder<UsuarioSimples>(
				usuarioService.getLista());
		pagedListHolder.setPageSize(20);

		List<UsuarioSimples> pagedListUsuarios = pagedListHolder.getPageList();

		modelAndView.addObject("usuarios", pagedListUsuarios);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/usuario/admin")
	public ModelAndView updateUsuarioAdmin(@RequestParam final Long id) {
		ModelAndView modelAndView = new ModelAndView("/usuario/lista");
		usuarioService.setAdmin(id);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/usuario/mostra")
	public ModelAndView showFornecedor(final Long id) {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuario",
				"usuario", new UsuarioSimples());

		modelAndView.addObject("usuario", usuarioService.getUsuario(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView usuarioLogin(
			@RequestParam(required = false) final String errorMessage) {

		return new ModelAndView("login")
				.addObject("errorMessage", errorMessage);
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
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("usuario") final Usuario usuario,
			final BindingResult result) throws Exception {

		usuario.setPassword(StringUtils.encodePassword(usuario.getPassword(),
				usuario.getUsername()));
		sindicoUserDetailsServiceImpl.criarUsuario(usuario);

		return "redirect:/login";
	}

}
