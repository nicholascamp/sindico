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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.UsuarioForm;
import com.sindico.entity.CepSimples;
import com.sindico.entity.Predio;
import com.sindico.entity.Usuario;
import com.sindico.entity.UsuarioSimples;
import com.sindico.enums.TipoUsuario;
import com.sindico.service.CepService;
import com.sindico.service.PredioService;
import com.sindico.service.UsuarioService;
import com.sindico.service.impl.SindicoUserDetailsServiceImpl;
import com.sindico.utils.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class UsuarioController.
 */
@Controller
@SessionAttributes
public class UsuarioController {

	/** The sindico user details service impl. */
	@Autowired
	private SindicoUserDetailsServiceImpl	sindicoUserDetailsServiceImpl;

	/** The authentication manager. */
	@Autowired
	@Qualifier("org.springframework.security.authenticationManager")
	protected AuthenticationManager			authenticationManager;

	/** The usuario service. */
	@Autowired
	private UsuarioService					usuarioService;

	/** The cep service. */
	@Autowired
	private CepService						cepService;

	/** The predio service. */
	@Autowired
	private PredioService					predioService;

	/**
	 * Usuario form.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public ModelAndView usuarioForm() {

		ModelAndView modelAndView = new ModelAndView("/usuario/criaUsuario",
				"usuario", new UsuarioForm());

		modelAndView.addObject("tipos", TipoUsuario.values());
		modelAndView.setViewName("cadastro");

		return modelAndView;
	}

	/**
	 * Usuario index form.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView usuarioIndexForm() {
		ModelAndView modelAndView = new ModelAndView("index", "usuario",
				new Usuario());

		modelAndView.addObject("tipos", TipoUsuario.values());

		return modelAndView;
	}

	/**
	 * Index usuario.
	 * 
	 * @return the model and view
	 */
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

	/**
	 * Index usuario nome.
	 * 
	 * @param nome
	 *            the nome
	 * @return the model and view
	 */
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

	/**
	 * Index usuario email.
	 * 
	 * @param email
	 *            the email
	 * @return the model and view
	 */
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

	/**
	 * Eh usuario logado.
	 * 
	 * @return true, if successful
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/ehUsuario")
	@ResponseBody
	public boolean ehUsuarioLogado() {
		return usuarioService.ehUsuarioLogado();
	}

	/**
	 * Gets the logged user.
	 * 
	 * @return the logged user
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getLoggedUser")
	@ResponseBody
	public UsuarioSimples getLoggedUser() {
		return new UsuarioSimples(usuarioService.getLoggedUser());
	}

	// Alterar para PUT
	/**
	 * Update usuario admin.
	 * 
	 * @param id
	 *            the id
	 * @param admin
	 *            the admin
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/tornarAdmin")
	public ModelAndView updateUsuarioAdmin(@RequestParam final Long id,
			@RequestParam final boolean admin) {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuario",
				"usuario", new UsuarioSimples());
		modelAndView.addObject("usuario",
				new UsuarioSimples(usuarioService.setAdmin(id, admin)));
		modelAndView.setViewName("mostraUsuario");
		return modelAndView;
	}

	/**
	 * Show fornecedor.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/mostraUsuario")
	public ModelAndView showFornecedor(final Long id) {
		ModelAndView modelAndView = new ModelAndView("/usuario/usuario",
				"usuario", new UsuarioSimples());

		modelAndView.addObject("usuario", usuarioService.getUsuario(id));
		modelAndView.setViewName("mostraUsuario");
		return modelAndView;
	}

	/**
	 * Usuario login.
	 * 
	 * @param errorMessage
	 *            the error message
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView usuarioLogin(
			@RequestParam(required = false) final String errorMessage) {

		return new ModelAndView("login")
				.addObject("errorMessage", errorMessage);
	}

	/**
	 * Adds the contact.
	 * 
	 * @param usuarioForm
	 *            the usuario form
	 * @param result
	 *            the result
	 * @param request
	 *            the request
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String createUsuario(
			@ModelAttribute("usuario") final UsuarioForm usuarioForm,
			final BindingResult result, final HttpServletRequest request)
			throws Exception {

		Usuario usuario = new Usuario(usuarioForm);
		CepSimples cep = cepService.recuperaCep(usuarioForm.getCep());
		cep.setNumero(usuarioForm.getNumero());
		Predio predio = new Predio(cep);

		predio = predioService.criarPredio(predio);

		usuario.setPredio(predio);

		String plainTextPassword = usuarioForm.getPassword();
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
