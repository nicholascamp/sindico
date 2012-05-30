/**
 * 
 */
package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author Lucas
 * 
 */
@Controller
@SessionAttributes
public class PredioController {

	@Autowired
	PredioDAO						predioDAO;

	@Autowired
	GerenteAdministradoraService	gerenteAdministradoraService;

	@RequestMapping(method = RequestMethod.GET, value = "/criaPredio.html")
	public ModelAndView usuarioForm() {
		ModelAndView modelAndView = new ModelAndView("/criaPredio", "predio",
				new Predio());

		modelAndView.addObject("tipos", TipoPredio.values());
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject("gerentes",
				gerenteAdministradoraService.listaGerentes());
		System.out.println("Cria Predio");
		return modelAndView;
	}

	@RequestMapping(value = "/criaPredio", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("predio") final Predio predio,
			final BindingResult result) {

		predioDAO.criaPredio(predio);

		return "redirect:predios.html";
	}

}
