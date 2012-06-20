/**
 * 
 */
package com.sindico.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Subcategoria;
import com.sindico.enums.Status;
import com.sindico.service.CotacaoService;
import com.sindico.service.SubcategoriaService;

/**
 * @author Lucas
 * 
 */
@Controller
@SessionAttributes
public class CotacaoController {

	@Autowired
	CotacaoService cotacaoService;

	@Autowired
	SubcategoriaService subcategoriaService;

	@RequestMapping(method = RequestMethod.GET, value = "/listaCotacoes")
	public ModelAndView indexCotacao() {
		ModelAndView mv = new ModelAndView("/cotacao/cotacoes", "cotacoes", cotacaoService.listCotacoes());
		mv.setViewName("listaCotacoes");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mostraCotacao")
	public ModelAndView showCotacao(final Long id) {
		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao", cotacaoService.getCotacao(id));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/criaCotacao")
	public ModelAndView newCotacao() {
		ModelAndView mv = new ModelAndView("/cotacao/criaCotacao", "cotacao", new Cotacao());
		mv.addObject("subcategorias", subcategoriaService.listSubcategorias());
		mv.setViewName("criaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/criaCotacao")
	public ModelAndView createCotacao(@ModelAttribute("cotacao") final Cotacao cotacao) {
		cotacao.setData(new Date());
		cotacao.setStatus(Status.ABERTO);
		cotacao.setImpropria(false);
		cotacao.setDataAtualizacao(new Date());
		// COMO ACHAR O GERENTE DA ADMINISTRADORA
		// COMO ACHAR O USUARIO

		ModelAndView mv = new ModelAndView("cotacao/cotacao", "cotacao", cotacaoService.criarCotacao(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaCotacao")
	public ModelAndView editCotacao(final Long id) {
		ModelAndView mv = new ModelAndView("/cotacao/editaCotacao", "cotacao", cotacaoService.getCotacao(id));
		mv.setViewName("editaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editaCotacao")
	public ModelAndView updateCotacao(@ModelAttribute("cotacao") final Cotacao cotacao) {
		cotacao.setDataAtualizacao(new Date());
		ModelAndView mv = new ModelAndView("/cotacao/cotacao", "cotacao", cotacaoService.atualizarCotacao(cotacao));
		mv.setViewName("mostraCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deletaCotacao")
	public ModelAndView destroyCotacao(final Long id) {
		cotacaoService.removerCotacao(id);
		ModelAndView mv = new ModelAndView("/cotacao/cotacoes", "cotacoes", cotacaoService.listCotacoes());
		mv.setViewName("listaCotacoes");
		return mv;
	}

	@InitBinder
	protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Subcategoria.class, "subcategoria", new PropertyEditorSupport() {
			@Override
			public void setAsText(final String id) {
				Subcategoria subcategoria = subcategoriaService.getSubcategoria(Long.parseLong(id));
				setValue(subcategoria);
			}
		});
	}
}
