package com.sindico.controller;

import java.beans.PropertyEditorSupport;

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

import com.sindico.entity.Categoria;
import com.sindico.entity.Subcategoria;
import com.sindico.service.CategoriaService;
import com.sindico.service.SubcategoriaService;

@Controller
@SessionAttributes
public class SubcategoriaController {

	@Autowired
	SubcategoriaService subcategoriaService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/subcategoria/lista")
	public ModelAndView indexSubcategoria(){
		ModelAndView mv = new ModelAndView("/subcategorias", "subcategorias", subcategoriaService.listSubcategorias());
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
		mv.addObject("categorias", categoriaService.listCategorias());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/subcategoria/cria")
	public ModelAndView createSubcategoria(@ModelAttribute("subcategoria")  Subcategoria subcategoria){
		System.out.println(subcategoria.getCategoria().getNome());
		ModelAndView mv = new ModelAndView("/subcategoria", "subcategoria", subcategoriaService.createSubcategoria(subcategoria));
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/subcategoria/edita")
	public ModelAndView editSubcategoria(long id){
		Subcategoria subcategoria = subcategoriaService.getSubcategoria(id);
		
		System.out.println(subcategoria.getTitle());
		System.out.println(subcategoria.getCategoria().getNome());
		ModelAndView mv = new ModelAndView("/editaCategoria", "subcategoria", subcategoria);
		mv.addObject("categorias", categoriaService.listCategorias());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/subcategoria/edita")
	public ModelAndView updateSubcategoria(Subcategoria subcategoria){
		ModelAndView mv = new ModelAndView("/subcategoria", "subcategoria",subcategoriaService.updateSubcategoria(subcategoria));
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/subcategoria/delata")
	public ModelAndView destroySubcategoria(long id){
		subcategoriaService.removeSubcategoria(id);
		ModelAndView mv = new ModelAndView("/subcategorias", "subcategorias", subcategoriaService.listSubcategorias());
		
		return mv;
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Categoria.class, "categoria", new PropertyEditorSupport() {
	        public void setAsText(String id) {
				Categoria categoria = (Categoria) categoriaService.getCategoria(Long.parseLong(id));
	            setValue(categoria);
	        }
	    });
	}
}
