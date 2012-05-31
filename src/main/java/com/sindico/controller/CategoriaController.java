package com.sindico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.dao.CategoriaDAO;
import com.sindico.entity.Categoria;
import com.sindico.service.CategoriaService;

@Controller
@SessionAttributes
public class CategoriaController {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/lista.html")
	public ModelAndView indexCategoria(){
		ModelAndView modelAndView = new ModelAndView("/categorias", "categoria", new Categoria());
		PagedListHolder<Categoria> pagedListHolder = new PagedListHolder<Categoria>(categoriaService.listarCategorias());
		pagedListHolder.setPageSize(2);

		List<Categoria> pagedListCategorias = pagedListHolder.getPageList();

		modelAndView.addObject("categoria", pagedListCategorias);

		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/mostra.html")
	public ModelAndView showCategoria(long id){
		ModelAndView modelAndView = new ModelAndView("/categoria", "categoria", new Categoria());
		
		modelAndView.addObject("categoria", categoriaDAO.getCategoria(id));
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/cria.html")
	public ModelAndView newCategoria(){
		ModelAndView modelAndView = new ModelAndView("/criaCategoria", "categoria", new Categoria());
			
		return modelAndView;		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/categoria/cria.html")
	public ModelAndView createCategoria(@ModelAttribute("categoria") Categoria categoria, BindingResult result){
		categoriaService.criarCategoria(categoria);
		
		return new ModelAndView("/categoria", "categoria", categoria);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/edita.html")
	public ModelAndView editCategoria(long id){
		Categoria categoria = categoriaDAO.getCategoria(id);
		
		return new ModelAndView("/editaCategoria", "categoria", categoria);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/categoria/edita.html")
	public ModelAndView updateCategoria(Categoria categoria){
		categoriaDAO.atualizaCategoria(categoria);
		
		return new ModelAndView("/categoria", "categoria", categoria);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/categoria/deleta.html")
	public ModelAndView destroyCategoria(Categoria categoria){
		categoriaDAO.removeCategoria((long) categoria.getCodigo());
		
		return new ModelAndView("/categorias", "categorias", categoriaService.listarCategorias());
	}
}
