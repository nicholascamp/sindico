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
	
	@RequestMapping(method=RequestMethod.GET, value="/cotacao/lista")
	public ModelAndView indexCotacao(){
		ModelAndView mv = new ModelAndView("/cotacoes", "cotacoes", cotacaoService.listCotacoes());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cotacao/mostra")
	public ModelAndView showCotacao(Long id){
		ModelAndView mv = new ModelAndView("/cotacao", "cotacao", cotacaoService.getCotacao(id));
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cotacao/cria")
	public ModelAndView newCotacao(){
		ModelAndView mv = new ModelAndView("/criaCotacao", "cotacao", new Cotacao());
		mv.addObject("subcategorias", subcategoriaService.listSubcategorias());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cotacao/cria")
	public ModelAndView createCotacao(@ModelAttribute("cotacao") Cotacao cotacao){
		cotacao.setData(new Date());
		cotacao.setStatus(Status.ABERTO);
		cotacao.setImpropria(false);
		cotacao.setDataAtualizacao(new Date());
		// COMO ACHAR O GERENTE DA ADMINISTRADORA
		// COMO ACHAR O USUARIO
		
		ModelAndView mv = new ModelAndView("/cotacao", "cotacao", cotacaoService.criarCotacao(cotacao));
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cotacao/edita")
	public ModelAndView editCotacao(Long id){
		ModelAndView mv = new ModelAndView("/editaCotacao", "cotacao", cotacaoService.getCotacao(id));
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cotacao/edita")
	public ModelAndView updateCotacao(@ModelAttribute("cotacao") Cotacao cotacao){
		cotacao.setDataAtualizacao(new Date());
		ModelAndView mv = new ModelAndView("/cotacao", "cotacao", cotacaoService.atualizarCotacao(cotacao));
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cotacao/deleta")
	public ModelAndView destroyCotacao(Long id){
		cotacaoService.removerCotacao(id);
		ModelAndView mv = new ModelAndView("/cotacoes", "cotacoes", cotacaoService.listCotacoes());
		return mv;
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Subcategoria.class, "subcategoria", new PropertyEditorSupport() {
	        public void setAsText(String id) {
				Subcategoria subcategoria = (Subcategoria) subcategoriaService.getSubcategoria(Long.parseLong(id));
	            setValue(subcategoria);
	        }
	    });
	}
}
