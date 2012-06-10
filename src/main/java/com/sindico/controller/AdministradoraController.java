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
	AdministradoraService service;
	
	@RequestMapping(method=RequestMethod.GET, value = "/administradora/lista")
	public ModelAndView indexAdministradora(){
		ModelAndView mv = new ModelAndView("/administradora/administradoras", "administradoras", service.listAdministradoras());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/administradora/mostra")
	public ModelAndView showAdministradora(Long id){
		ModelAndView mv = new ModelAndView("/administradora/administradora", "administradora", service.getAdministradora(id));
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/administradora/cria")
	public ModelAndView newAdministradora(){
		ModelAndView mv = new ModelAndView("/administradora/criaAdministradora", "administradora", new Administradora());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/administradora/cria")
	public ModelAndView createAdministradora(@ModelAttribute("administradora") final Administradora administradora){
		service.createAdministradora(administradora);
		ModelAndView mv = new ModelAndView("/administradora/administradora", "administradora", administradora);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/administradora/edita")
	public ModelAndView editAdministradora(Long id){
		ModelAndView mv = new ModelAndView("/administradora/editAdministradora", "administradora", service.getAdministradora(id));
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/administradora/edita")
	public ModelAndView updateAdministradora(@ModelAttribute("administradora") Administradora administradora){
		ModelAndView mv = new ModelAndView("/administradora/administradora", "administradora", administradora);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/administradora/deleta")
	public ModelAndView deleteAdministradora(Long id){
		ModelAndView mv = new ModelAndView("/administradora/administradoras", "administradoras", service.listAdministradoras());
		return mv;
	}
}
