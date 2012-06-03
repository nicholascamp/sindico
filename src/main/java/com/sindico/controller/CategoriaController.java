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

/**
 * The Class CategoriaController.
 */
@Controller
@SessionAttributes
public class CategoriaController {

	/** The categoria service. */
	@Autowired
	private CategoriaService	categoriaService;

	/**
	 * Index categoria.
	 * 
	 * @return the model and view
	 */
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

	/**
	 * Show categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/mostra")
	public ModelAndView showCategoria(final Long id) {
		ModelAndView modelAndView = new ModelAndView("/categoria", "categoria",
				new Categoria());

		modelAndView.addObject("categoria", categoriaService.getCategoria(id));
		return modelAndView;
	}

	/**
	 * New categoria.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/cria")
	public ModelAndView newCategoria() {
		ModelAndView modelAndView = new ModelAndView("/criaCategoria",
				"categoria", new Categoria());

		return modelAndView;
	}

	/**
	 * Creates the categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/categoria/cria")
	public ModelAndView createCategoria(
			@ModelAttribute("categoria") final Categoria categoria,
			final BindingResult result) {
		categoriaService.createCategoria(categoria);

		return new ModelAndView("/categoria", "categoria", categoria);
	}

	/**
	 * Edits the categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/edita")
	public ModelAndView editCategoria(final Long id) {
		Categoria categoria = categoriaService.getCategoria(id);

		return new ModelAndView("/editaCategoria", "categoria", categoria);
	}

	/**
	 * Update categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/categoria/edita")
	public ModelAndView updateCategoria(final Categoria categoria) {
		System.out.println(categoria.getNome());
		System.out.println(categoria.getCodigo());
		categoriaService.updateCategoria(categoria);

		return new ModelAndView("/categoria", "categoria", categoria);
	}

	/**
	 * Destroy categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/categoria/deleta")
	public ModelAndView destroyCategoria(final Categoria categoria) {
		categoriaService.removeCategoria(categoria.getCodigo());

		return new ModelAndView("/categorias", "categorias",
				categoriaService.listCategorias());
	}
}
