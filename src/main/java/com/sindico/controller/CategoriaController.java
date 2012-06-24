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
	@RequestMapping(method = RequestMethod.GET, value = "/listaCategorias")
	public ModelAndView indexCategoria() {
		ModelAndView modelAndView = new ModelAndView("/categoria/categorias",
				"categoria", new Categoria());
		PagedListHolder<Categoria> pagedListHolder = new PagedListHolder<Categoria>(
				categoriaService.listCategorias());
		pagedListHolder.setPageSize(20);

		List<Categoria> pagedListCategorias = pagedListHolder.getPageList();

		modelAndView.addObject("categorias", pagedListCategorias);
		modelAndView.setViewName("listaCategorias");

		return modelAndView;
	}

	/**
	 * Show categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/mostraCategoria")
	public ModelAndView showCategoria(final Long id) {
		ModelAndView modelAndView = new ModelAndView("/categoria/categoria",
				"categoria", new Categoria());

		modelAndView.addObject("categoria", categoriaService.getCategoria(id));
		modelAndView.setViewName("mostraCategoria");
		return modelAndView;
	}

	/**
	 * New categoria.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/criaCategoria")
	public ModelAndView newCategoria() {
		ModelAndView modelAndView = new ModelAndView(
				"/categoria/criaCategoria", "categoria", new Categoria());

		modelAndView.setViewName("criaCategoria");

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
	@RequestMapping(method = RequestMethod.POST, value = "/criaCategoria")
	public ModelAndView createCategoria(
			@ModelAttribute("categoria") final Categoria categoria,
			final BindingResult result) {
		categoriaService.createCategoria(categoria);

		ModelAndView modelAndView = new ModelAndView("/categoria/categoria",
				"categoria", categoria);
		modelAndView.setViewName("mostraCategoria");
		return modelAndView;
	}

	/**
	 * Edits the categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/editaCategoria")
	public ModelAndView editCategoria(final Long id) {
		Categoria categoria = categoriaService.getCategoria(id);

		ModelAndView modelAndView = new ModelAndView(
				"/categoria/editaCategoria", "categoria", categoria);
		modelAndView.setViewName("editaCategoria");
		return modelAndView;
	}

	/**
	 * Update categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/editaCategoria")
	public ModelAndView updateCategoria(final Categoria categoria) {
		System.out.println(categoria.getNome());
		System.out.println(categoria.getId());
		categoriaService.updateCategoria(categoria);
		ModelAndView modelAndView = new ModelAndView(
				"/categoria/editaCategoria", "categoria", categoria);
		modelAndView.setViewName("mostraCategoria");

		return modelAndView;
	}

	/**
	 * Destroy categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/deletaCategoria")
	public ModelAndView destroyCategoria(final Long id) {
		categoriaService.removeCategoria(id);

		ModelAndView modelAndView = new ModelAndView("/categoria/categorias",
				"categorias", categoriaService.listCategorias());
		modelAndView.setViewName("listaCategorias");
		return modelAndView;
	}
}
