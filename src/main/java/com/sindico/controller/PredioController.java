/**
 * 
 */
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

import com.sindico.dao.PredioDAO;
import com.sindico.entity.Predio;
import com.sindico.enums.Estado;
import com.sindico.enums.TipoPredio;
import com.sindico.service.GerenteAdministradoraService;
import com.sindico.service.PredioService;

/**
 * The Class PredioController.
 */
@Controller
@SessionAttributes
public class PredioController {

	/** The predio dao. */
	@Autowired
	private PredioDAO predioDAO;

	/** The predio service. */
	@Autowired
	private PredioService predioService;

	/** The gerente administradora service. */
	@Autowired
	private GerenteAdministradoraService gerenteAdministradoraService;

	/**
	 * Predio crud.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/predios.html")
	public ModelAndView predioCRUD() {

		ModelAndView modelAndView = new ModelAndView("/predios", "predio", new Predio());
		PagedListHolder<Predio> pagedListHolder = new PagedListHolder<Predio>(predioService.listarPredios());
		pagedListHolder.setPageSize(10);

		List<Predio> pagedListPredios = pagedListHolder.getPageList();

		modelAndView.addObject("predios", pagedListPredios);

		return modelAndView;
	}

	/**
	 * Predio form.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/criaPredio.html")
	public ModelAndView predioForm() {
		ModelAndView modelAndView = new ModelAndView("/criaPredio", "predio", new Predio());

		modelAndView.addObject("tipos", TipoPredio.values());
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject("gerentes", gerenteAdministradoraService.listaGerentes());
		System.out.println("Cria Predio");
		return modelAndView;
	}

	/**
	 * Adds the contact.
	 * 
	 * @param predio
	 *            the predio
	 * @param result
	 *            the result
	 * @return the string
	 */
	@RequestMapping(value = "/criaPredio", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("predio") final Predio predio, final BindingResult result) {

		predioDAO.criaPredio(predio);

		return "redirect:predios.html";
	}

}
