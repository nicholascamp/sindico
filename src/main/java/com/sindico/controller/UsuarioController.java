package com.sindico.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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
	@Qualifier("org.springframework.security.authenticationManager")
	protected AuthenticationManager			authenticationManager;

	@Autowired
	private UsuarioService					usuarioService;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public ModelAndView usuarioForm() {

		ModelAndView modelAndView = new ModelAndView("/usuario/criaUsuario",
				"usuario", new Usuario());

		modelAndView.addObject("tipos", TipoUsuario.values());
		modelAndView.setViewName("cadastro");

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView usuarioIndexForm() {
		ModelAndView modelAndView = new ModelAndView("index", "usuario",
				new Usuario());

		modelAndView.addObject("tipos", TipoUsuario.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listaUsuarios")
	public ModelAndView indexUsuario() {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuarios",
				"usuario", new UsuarioSimples());
		PagedListHolder<UsuarioSimples> pagedListHolder = new PagedListHolder<UsuarioSimples>(
				usuarioService.getLista());
		pagedListHolder.setPageSize(20);

		List<UsuarioSimples> pagedListUsuarios = pagedListHolder.getPageList();

		modelAndView.addObject("usuarios", pagedListUsuarios);
		modelAndView.setViewName("listaUsuarios");

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listaUsuariosPorNome")
	public ModelAndView indexUsuarioNome(@RequestParam final String nome) {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuarios",
				"usuario", new UsuarioSimples());
		PagedListHolder<UsuarioSimples> pagedListHolder = new PagedListHolder<UsuarioSimples>(
				usuarioService.getUsuarioNome(nome));
		pagedListHolder.setPageSize(20);

		List<UsuarioSimples> pagedListUsuarios = pagedListHolder.getPageList();

		modelAndView.addObject("usuarios", pagedListUsuarios);
		modelAndView.setViewName("listaUsuarios");

		return modelAndView;
	}

	@RequestMapping(
			method = RequestMethod.GET, value = "/listaUsuariosPorEmail")
	public ModelAndView indexUsuarioEmail(@RequestParam final String email) {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuarios",
				"usuario", new UsuarioSimples());
		PagedListHolder<UsuarioSimples> pagedListHolder = new PagedListHolder<UsuarioSimples>(
				usuarioService.getUsuarioEmail(email));
		pagedListHolder.setPageSize(20);

		List<UsuarioSimples> pagedListUsuarios = pagedListHolder.getPageList();

		modelAndView.addObject("usuarios", pagedListUsuarios);
		modelAndView.setViewName("listaUsuarios");

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/usuario/admin")
	public ModelAndView updateUsuarioAdmin(@RequestParam final Long id,
			@RequestParam final boolean admin) {
		ModelAndView modelAndView = new ModelAndView("/usuario/lista");
		usuarioService.setAdmin(id, admin);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mostraUsuario")
	public ModelAndView showFornecedor(final Long id) {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuario",
				"usuario", new UsuarioSimples());

		modelAndView.addObject("usuario", usuarioService.getUsuario(id));
		modelAndView.setViewName("mostraUsuario");
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
			final BindingResult result, final HttpServletRequest request)
			throws Exception {

		String plainTextPassword = usuario.getPassword();
		String encodedPassword = StringUtils.encodePassword(plainTextPassword,
				usuario.getUsername());
		usuario.setPassword(encodedPassword);
		sindicoUserDetailsServiceImpl.criarUsuario(usuario);

		/*
		 * Início do processo de login de usuário.
		 */

		// Gera-se um token com o username e o password.
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				usuario.getUsername(), plainTextPassword);

		// Adquire-se uma sessão, caso não exista.
		request.getSession();

		// ?
		token.setDetails(new WebAuthenticationDetails(request));

		// Realiza a autenticação do usuário e o insere no contexto.
		Authentication authenticatedUser = authenticationManager
				.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);

		/*
		 * Fim do processo de login de usuário.
		 */

		return "redirect:/index";
	}

}
