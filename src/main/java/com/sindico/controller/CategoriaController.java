package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.dao.CategoriaDAO;
import com.sindico.entity.Categoria;

@Controller
@SessionAttributes
public class CategoriaController {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/lista.html")
	public ModelAndView indexCategoria(){
		return new ModelAndView();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/mostra.html")
	public ModelAndView showCategoria(long id){
		return new ModelAndView();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/cria.html")
	public ModelAndView newCategoria(){
		ModelAndView modelAndView = new ModelAndView("/criaCategoria", "categoria", new Categoria());
		
		return modelAndView;		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/categoria/cria.html")
	public ModelAndView createCategoria(@ModelAttribute("categoria") Categoria categoria, BindingResult result){
		return new ModelAndView();
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/edita.html")
	public ModelAndView editCategoria(){
		return new ModelAndView();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/categoria/edita.html")
	public ModelAndView updateCategoria(Categoria categoria){
		return new ModelAndView();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/categoria/deleta.html")
	public ModelAndView destroyCategoria(Categoria categoria){
		return new ModelAndView();
	}
}
