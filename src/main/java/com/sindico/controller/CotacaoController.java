/**
 * 
 */
package com.sindico.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.entity.RespostaCotacao;
import com.sindico.entity.Subcategoria;
import com.sindico.entity.Usuario;
import com.sindico.enums.Status;
import com.sindico.service.CotacaoService;
import com.sindico.service.FornecedorService;
import com.sindico.service.GerenteAdministradoraService;
import com.sindico.service.PredioService;
import com.sindico.service.SubcategoriaService;
import com.sindico.service.UsuarioService;

/**
 * @author Lucas
 * 
 */
@Controller
@SessionAttributes
public class CotacaoController {

	@Autowired
	CotacaoService					cotacaoService;

	@Autowired
	SubcategoriaService				subcategoriaService;

	@Autowired
	FornecedorService				fornecedorService;

	@Autowired
	UsuarioService					usuarioService;

	@Autowired
	GerenteAdministradoraService	gerenteAdminService;

	@Autowired
	PredioService					predioService;

	@RequestMapping(method = RequestMethod.GET, value = "/listaCotacoes")
	public ModelAndView indexCotacao() {
		ModelAndView mv = new ModelAndView("/cotacao/cotacoes", "cotacoes",
				cotacaoService.listCotacoes());
		mv.setViewName("listaCotacoes");
		return mv;
	}

	@RequestMapping(
			method = RequestMethod.GET, value = "/listaCotacoesPorUsuario")
	public ModelAndView indexCotacaoPorUsuario() {
		ModelAndView mv = new ModelAndView("/cotacao/cotacoes", "cotacoes",
				cotacaoService.listCotacoes(usuarioService.getLoggedUser()
						.getId()));
		mv.setViewName("listaCotacaoesPorUsuario");
		return mv;
	}

	@RequestMapping(
			method = RequestMethod.GET, value = "/listaCotacoesPorPredio")
	public ModelAndView indexCotacaoPorPredio() {
		ModelAndView mv = new ModelAndView("/cotacao/cotacoes", "cotacoes",
				cotacaoService.listCotacoes(usuarioService.getLoggedUser()
						.getPredio()));
		mv.setViewName("listaCotacoesPorPredio");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mostraCotacao")
	public ModelAndView showCotacao(final Long id) {
		Cotacao cotacao = cotacaoService.getCotacao(id);
		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao",
				cotacao);

		mv.addObject("respostas",
				cotacaoService.listRespostasCotacaoHistorico(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/criaCotacao")
	public ModelAndView newCotacao() {
		ModelAndView mv = new ModelAndView("/cotacao/criaCotacao", "cotacao",
				new Cotacao());
		mv.addObject("subcategorias", subcategoriaService.listSubcategorias());
		mv.addObject("fornecedores", null);
		mv.setViewName("criaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/carregaFornecedores")
	public ModelAndView buscarFornecedoresPorSubcategoria(
			@ModelAttribute("cotacao") final Cotacao cotacao) {

		ModelAndView mv = new ModelAndView("/cotacao/criCotacao", "cotacao",
				cotacao);
		mv.addObject("fornecedores",
				fornecedorService.listarFornecedor(cotacao.getSubcategoria()));
		mv.addObject("subcategorias", subcategoriaService.listSubcategorias());
		mv.setViewName("criaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/criaCotacao")
	public ModelAndView createCotacao(
			@ModelAttribute("cotacao") final Cotacao cotacao) {
		cotacao.setData(new Date());
		cotacao.setStatus(Status.ABERTO);
		cotacao.setImpropria(false);
		cotacao.setDataAtualizacao(new Date());
		Usuario user = usuarioService.getLoggedUser();
		cotacao.addUsuario(user);
		cotacao.setPredio(user.getPredio());
		// COMO ACHAR O GERENTE DA ADMINISTRADORA

		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao",
				cotacaoService.criarCotacao(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaCotacao")
	public ModelAndView editCotacao(final Long id) {
		Cotacao cotacao = cotacaoService.getCotacao(id);
		ModelAndView mv = new ModelAndView("/cotacao/editaCotacao", "cotacao",
				cotacao);

		mv.setViewName("editaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editaCotacao")
	public ModelAndView updateCotacao(
			@ModelAttribute("cotacao") final Cotacao cotacao) {
		cotacao.setDataAtualizacao(new Date());
		cotacao.addUsuario(usuarioService.getLoggedUser());
		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao",
				cotacaoService.atualizarCotacao(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaCotacaoAdmin")
	public ModelAndView editCotacaoAdmin(final Long id) {
		ModelAndView mv = new ModelAndView("/cotacao/editaCotacaoAdmin",
				"cotacao", cotacaoService.getCotacao(id));
		mv.addObject("subcategorias", subcategoriaService.listSubcategorias());
		mv.setViewName("editaCotacaoAdmin");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editaCotacaoAdmin")
	public ModelAndView updateCotacaoAdmin(
			@ModelAttribute("cotacao") final Cotacao cotacao) {
		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao",
				cotacaoService.atualizarCotacao(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/encerraCotacao")
	public ModelAndView encerraCotacao(final Long idRespostaCotacao) {
		RespostaCotacao respostaCotacao = cotacaoService
				.getRespostaCotacao(idRespostaCotacao);

		Cotacao cotacao = respostaCotacao.getCotacao();
		cotacao.setRespostaCotacaoVencedora(respostaCotacao);
		cotacao.setStatus(Status.FECHADO);
		cotacao.setDataAtualizacao(new Date());
		cotacao.setFornecedorVencedor(respostaCotacao.getFornecedor());

		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao",
				cotacaoService.atualizarCotacao(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/adicionarUsuario")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public void adicionarUsuario(@RequestParam final String email,
			@RequestParam final Long cotacaoId) throws Exception {

		cotacaoService.adicionarUsuario(email, cotacaoId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/adicionarGerente")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public void adicionarGerente(@RequestParam final String email,
			@RequestParam final Long cotacaoId) throws Exception {

		cotacaoService.adicionarGerente(email, cotacaoId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deletaCotacao")
	public ModelAndView destroyCotacao(final Long id) {
		cotacaoService.removerCotacao(id);
		ModelAndView mv = new ModelAndView("/cotacao/cotacoes", "cotacoes",
				cotacaoService.listCotacoes());
		mv.setViewName("listaCotacoes");
		return mv;
	}

	@InitBinder
	protected void initBinder(final HttpServletRequest request,
			final ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Usuario.class, "usuario",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Usuario usuario = usuarioService.buscaUsuario(Long
								.parseLong(id));
						setValue(usuario);
					}
				});

		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
				new SimpleDateFormat("dd/mm/yy"), false));

		binder.registerCustomEditor(Subcategoria.class,
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Subcategoria subcategoria = subcategoriaService
								.getSubcategoria(Long.parseLong(id));
						setValue(subcategoria);
					}
				});

		binder.registerCustomEditor(List.class, "fornecedores",
				new CustomCollectionEditor(List.class) {
					@Override
					protected Object convertElement(final Object element) {
						return (element == null ? null
								: fornecedorService.getFornecedor(Long
										.parseLong((String) element)));
					}
				});

		binder.registerCustomEditor(Fornecedor.class, "fornecedorVencedor",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Fornecedor fornecedor = fornecedorService
								.getFornecedor(Long.parseLong(id));
						setValue(fornecedor);
					}
				});

		binder.registerCustomEditor(GerenteAdministradora.class,
				"gerenteAdmin", new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						GerenteAdministradora gerenteAdmin = gerenteAdminService
								.getGerente(Long.parseLong(id));
						setValue(gerenteAdmin);
					}
				});
	}
}
