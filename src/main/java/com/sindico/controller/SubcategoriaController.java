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
	SubcategoriaService	subcategoriaService;

	@Autowired
	CategoriaService	categoriaService;

	@RequestMapping(method = RequestMethod.GET, value = "/listaSubcategorias")
	public ModelAndView indexSubcategoria() {
		ModelAndView mv = new ModelAndView("/subcategoria/subcategorias",
				"subcategorias", subcategoriaService.listSubcategorias());
		mv.setViewName("listaSubcategorias");
		// mv.addObject("categorias", categoriaService.listCategorias());
		// mv.addObject("categoria", new Categoria());

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mostraSubcategoria")
	public ModelAndView showSubcategoria(final long id) {
		ModelAndView mv = new ModelAndView("/subcategoria/subcategoria",
				"subcategoria", subcategoriaService.getSubcategoria(id));
		mv.setViewName("mostraSubcategoria");

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/criaSubcategoria")
	public ModelAndView newSubcategoria() {
		ModelAndView mv = new ModelAndView("/subcategoria/criaSubcategoria",
				"subcategoria", new Subcategoria());
		mv.addObject("categorias", categoriaService.listCategorias());

		mv.setViewName("criaSubcategoria");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/criaSubcategoria")
	public ModelAndView createSubcategoria(
			@ModelAttribute("subcategoria") final Subcategoria subcategoria) {
		ModelAndView mv = new ModelAndView("/subcategoria/subcategoria",
				"subcategoria",
				subcategoriaService.createSubcategoria(subcategoria));

		mv.setViewName("mostraSubcategoria");

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaSubcategoria")
	public ModelAndView editSubcategoria(final long id) {
		Subcategoria subcategoria = subcategoriaService.getSubcategoria(id);

		ModelAndView mv = new ModelAndView("/subcategoria/editaSubcategoria",
				"subcategoria", subcategoria);
		mv.addObject("categorias", categoriaService.listCategorias());

		mv.setViewName("editaSubcategoria");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editaSubcategoria")
	public ModelAndView updateSubcategoria(final Subcategoria subcategoria) {
		ModelAndView mv = new ModelAndView("/subcategoria/subcategoria",
				"subcategoria",
				subcategoriaService.updateSubcategoria(subcategoria));

		mv.setViewName("mostraSubcategoria");

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deletaSubcategoria")
	public ModelAndView destroySubcategoria(final long id) {
		subcategoriaService.removeSubcategoria(id);
		ModelAndView mv = new ModelAndView("/subcategoria/subcategorias",
				"subcategorias", subcategoriaService.listSubcategorias());

		mv.setViewName("listaSubcategorias");

		return mv;
	}

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/listaSubcategoriasPorCategoria")
	public ModelAndView showSubcategoriaPorCategoria(final Categoria categoria) {
		ModelAndView mv = new ModelAndView("/subcategoria/subcategorias",
				"subcategorias",
				subcategoriaService.listSubcategoriasPorCategoria(categoria));

		mv.setViewName("listaSubcategorias");

		return mv;
	}

	@InitBinder
	protected void initBinder(final HttpServletRequest request,
			final ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Categoria.class, "categoria",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Categoria categoria = categoriaService
								.getCategoria(Long.parseLong(id));
						setValue(categoria);
					}
				});
	}
}
