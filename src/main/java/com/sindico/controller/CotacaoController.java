/**
 * 
 */
package com.sindico.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.entity.Subcategoria;
import com.sindico.entity.Usuario;
import com.sindico.enums.Status;
import com.sindico.service.CotacaoService;
import com.sindico.service.FornecedorService;
import com.sindico.service.GerenteAdministradoraService;
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
	
	protected Subcategoria subcategoria;

	@RequestMapping(method = RequestMethod.GET, value = "/listaCotacoes")
	public ModelAndView indexCotacao() {
		ModelAndView mv = new ModelAndView("/cotacao/cotacoes", "cotacoes",
				cotacaoService.listCotacoes());
		mv.setViewName("listaCotacoes");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mostraCotacao")
	public ModelAndView showCotacao(final Long id) {
		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao",
				cotacaoService.getCotacao(id));
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
	public ModelAndView buscarFornecedoresPorSubcategoria(@ModelAttribute("cotacao") Cotacao cotacao){		
		
		ModelAndView mv = new ModelAndView("/cotacao/criCotacao", "cotacao", cotacao);
		mv.addObject("fornecedores", fornecedorService.listarFornecedorPorSubcategoria(cotacao.getSubcategoria()));
		mv.addObject("subcategoria", cotacao.getSubcategoria());
		subcategoria = cotacao.getSubcategoria();
		mv.addObject("subcategorias", subcategoriaService.listSubcategorias());
		mv.setViewName("criaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/criaCotacao")
	public ModelAndView createCotacao(
			@ModelAttribute("cotacao") final Cotacao cotacao) {
		//System.out.println(cotacao.getSubcategoria());
		
		cotacao.setData(new Date());
		cotacao.setStatus(Status.ABERTO);
		cotacao.setImpropria(false);
		cotacao.setDataAtualizacao(new Date());
		cotacao.setSubcategoria(subcategoria);
		Usuario user = usuarioService.getLoggedUser();
		cotacao.setUsuario(user);
		// COMO ACHAR O GERENTE DA ADMINISTRADORA

		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao",
				cotacaoService.criarCotacao(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaCotacao")
	public ModelAndView editCotacao(final Long id) {
		ModelAndView mv = new ModelAndView("/cotacao/editaCotacao", "cotacao",
				cotacaoService.getCotacao(id));
		mv.addObject("subcategorias", subcategoriaService.listSubcategorias());
		mv.setViewName("editaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editaCotacao")
	public ModelAndView updateCotacao(
			@ModelAttribute("cotacao") final Cotacao cotacao) {
		cotacao.setDataAtualizacao(new Date());
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

		binder.registerCustomEditor(Subcategoria.class, "subcategoria",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						System.out.println(id);
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
