package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Subcategoria;
import com.sindico.service.SubcategoriaService;

@Controller
@SessionAttributes
public class SubcategoriaController {

	@Autowired
	SubcategoriaService subcategoriaService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/subcategoria/lista")
	public ModelAndView indexSubcategoria(){
		ModelAndView mv = new ModelAndView("/subcategorias", "categorias", subcategoriaService.listSubacategorias());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/subcategoria/mostra")
	public ModelAndView showSubcategoria(long id){
		ModelAndView mv = new ModelAndView("/subcategoria", "subcategoria", subcategoriaService.getSubcategoria(id));
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/subcategoria/cria")
	public ModelAndView newSubcategoria(){
		ModelAndView mv = new ModelAndView("/criaSubcategoria", "subcategoria", new Subcategoria());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/subcategoria/cria")
	public ModelAndView createSubcategoria(Subcategoria subcategoria){
		ModelAndView mv = new ModelAndView("/subcategoria", "subcategoria", subcategoriaService.createSubcategoria(subcategoria));
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/subcategoria/edita")
	public ModelAndView editSubcategoria(long id){
		ModelAndView mv = new ModelAndView("/editaCategoria", "subcategoria", subcategoriaService.getSubcategoria(id));
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/subcategoria/edita")
	public ModelAndView updateSubcategoria(Subcategoria subcategoria){
		ModelAndView mv = new ModelAndView("/subcategoria", "subcategoria",subcategoriaService.updateSubcategoria(subcategoria));
		
		return mv;
	}
	
	public ModelAndView destroySubcategoria(long id){
		subcategoriaService.removeSubcategoria(id);
		ModelAndView mv = new ModelAndView("/subcategorias", "subcategorias", subcategoriaService.listSubacategorias());
		
		return mv;
	}
}
