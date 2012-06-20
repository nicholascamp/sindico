package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Administradora;
import com.sindico.service.AdministradoraService;

@Controller
@SessionAttributes
public class AdministradoraController {

	@Autowired
	AdministradoraService administradoraService;

	@RequestMapping(method = RequestMethod.GET, value = "/listaAdministradoras")
	public ModelAndView indexAdministradora() {
		ModelAndView mv = new ModelAndView("/administradora/administradoras", "administradoras",
				administradoraService.listAdministradoras());
		mv.setViewName("listaAdministradoras");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mostraAdministradora")
	public ModelAndView showAdministradora(final Long id) {
		ModelAndView mv = new ModelAndView("/administradora/administradora", "administradora",
				administradoraService.getAdministradora(id));
		mv.setViewName("mostraAdministradora");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/criaAdministradora")
	public ModelAndView newAdministradora() {
		ModelAndView mv = new ModelAndView("/administradora/criaAdministradora", "administradora", new Administradora());
		mv.setViewName("criaAdministradora");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/criaAdministradora")
	public ModelAndView createAdministradora(@ModelAttribute("administradora") final Administradora administradora) {
		administradoraService.createAdministradora(administradora);
		ModelAndView mv = new ModelAndView("/administradora/administradora", "administradora", administradora);
		mv.setViewName("mostraAdministradora");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaAdministradora")
	public ModelAndView editAdministradora(final Long id) {
		ModelAndView mv = new ModelAndView("/administradora/editaAdministradora", "administradora",
				administradoraService.getAdministradora(id));
		mv.setViewName("editaAdministradora");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editaAdministradora")
	public ModelAndView updateAdministradora(@ModelAttribute("administradora") final Administradora administradora) {
		administradoraService.updateAdministradora(administradora);
		ModelAndView mv = new ModelAndView("/administradora/administradora", "administradora", administradora);
		mv.setViewName("mostraAdministradora");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deletaAdministradora")
	public ModelAndView destroyAdministradora(final Long id) {
		administradoraService.removeAdministradora(id);
		ModelAndView mv = new ModelAndView("/administradora/administradoras", "administradoras",
				administradoraService.listAdministradoras());
		mv.setViewName("listaAdministradoras");
		return mv;
	}
}
