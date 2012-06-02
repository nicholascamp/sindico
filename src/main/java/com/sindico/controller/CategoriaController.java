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

import com.sindico.entity.Categoria;
import com.sindico.service.CategoriaService;

@Controller
@SessionAttributes
public class CategoriaController {

	@Autowired
	private CategoriaService	categoriaService;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/lista")
	public ModelAndView indexCategoria() {
		ModelAndView modelAndView = new ModelAndView("/categorias",
				"categoria", new Categoria());
		PagedListHolder<Categoria> pagedListHolder = new PagedListHolder<Categoria>(
				categoriaService.listCategorias());
		pagedListHolder.setPageSize(20);

		List<Categoria> pagedListCategorias = pagedListHolder.getPageList();

		modelAndView.addObject("categorias", pagedListCategorias);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/categoria/mostra")
	public ModelAndView showCategoria(final int id) {
		ModelAndView modelAndView = new ModelAndView("/categoria", "categoria",
				new Categoria());

		modelAndView.addObject("categoria", categoriaService.getCategoria(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/categoria/cria")
	public ModelAndView newCategoria() {
		ModelAndView modelAndView = new ModelAndView("/criaCategoria",
				"categoria", new Categoria());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/categoria/cria")
	public ModelAndView createCategoria(
			@ModelAttribute("categoria") final Categoria categoria,
			final BindingResult result) {
		categoriaService.createCategoria(categoria);

		return new ModelAndView("/categoria", "categoria", categoria);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/categoria/edita")
	public ModelAndView editCategoria(final int id) {
		Categoria categoria = categoriaService.getCategoria(id);

		return new ModelAndView("/editaCategoria", "categoria", categoria);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/categoria/edita")
	public ModelAndView updateCategoria(final Categoria categoria) {
		categoriaService.updateCategoria(categoria);

		return new ModelAndView("/categoria", "categoria", categoria);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/categoria/deleta")
	public ModelAndView destroyCategoria(final Categoria categoria) {
		categoriaService.removeCategoria(categoria.getCodigo());

		return new ModelAndView("/categorias", "categorias",
				categoriaService.listCategorias());
	}
}
