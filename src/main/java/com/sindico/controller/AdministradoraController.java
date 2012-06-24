package com.sindico.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Administradora;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.enums.Estado;
import com.sindico.service.AdministradoraService;
import com.sindico.service.GerenteAdministradoraService;
import com.sindico.service.PredioService;

@Controller
@SessionAttributes
public class AdministradoraController {

	@Autowired
	AdministradoraService	administradoraService;
	
	@Autowired
	GerenteAdministradoraService gerenteService;
	
	@Autowired
	PredioService predioService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/administradoraIndex")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("/administradora/administradoraIndex");
		mv.setViewName("administradoraIndex");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listaAdministradoras")
	public ModelAndView indexAdministradora() {
		ModelAndView mv = new ModelAndView("/administradora/administradoras",
				"administradoras", administradoraService.listAdministradoras());
		mv.setViewName("listaAdministradoras");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaGerentes")
	public ModelAndView indexGerente(){
		ModelAndView mv = new ModelAndView("/gerente/gerentes", "gerentes", gerenteService.listGerentes());
		mv.setViewName("listaGerentes");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mostraAdministradora")
	public ModelAndView showAdministradora(final Long id) {
		ModelAndView mv = new ModelAndView("/administradora/administradora",
				"administradora", administradoraService.getAdministradora(id));
		mv.setViewName("mostraAdministradora");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/mostraGerente")
	public ModelAndView showGerente(Long id){
		ModelAndView mv = new ModelAndView("/gerente/gerente", "gerente", gerenteService.getGerente(id));
		mv.setViewName("mostraGerente");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/criaAdministradora")
	public ModelAndView newAdministradora() {
		ModelAndView mv = new ModelAndView(
				"/administradora/criaAdministradora", "administradora",
				new Administradora());
		mv.addObject("estados", Estado.values());
		mv.setViewName("criaAdministradora");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/criaGerente")
	public ModelAndView newGerente(){
		ModelAndView mv = new ModelAndView("/gerente/criaGerente", "gerente", new GerenteAdministradora());
		mv.addObject("administradoras", administradoraService.listAdministradoras());
		mv.addObject("predios", predioService.listarPredios());
		mv.setViewName("criaGerente");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/criaAdministradora")
	public ModelAndView createAdministradora(
			@ModelAttribute("administradora") final Administradora administradora) {
		administradoraService.createAdministradora(administradora);
		ModelAndView mv = new ModelAndView("/administradora/administradora",
				"administradora", administradora);
		mv.setViewName("mostraAdministradora");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/criaGerente")
	public ModelAndView createGerente(@ModelAttribute("gerente") GerenteAdministradora gerente){
		gerenteService.createGerente(gerente);
		ModelAndView mv = new ModelAndView("/gerente/gerente", "gerente", gerente);
		mv.setViewName("mostraGerente");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaAdministradora")
	public ModelAndView editAdministradora(final Long id) {
		ModelAndView mv = new ModelAndView(
				"/administradora/editaAdministradora", "administradora",
				administradoraService.getAdministradora(id));
		mv.setViewName("editaAdministradora");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editaGerente")
	public ModelAndView editGerente(Long id){
		ModelAndView mv = new ModelAndView("/gerente/editaGerente", "gerente", gerenteService.getGerente(id));
		mv.setViewName("editaGerente");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editaAdministradora")
	public ModelAndView updateAdministradora(
			@ModelAttribute("administradora") final Administradora administradora) {
		administradoraService.updateAdministradora(administradora);
		ModelAndView mv = new ModelAndView("/administradora/administradora",
				"administradora", administradora);
		mv.setViewName("mostraAdministradora");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editaGerente")
	public ModelAndView updateGerente(@ModelAttribute("gerente") GerenteAdministradora gerente){
		gerenteService.updateGerente(gerente);
		ModelAndView mv = new ModelAndView("/gerente/gerente", "gerente", gerente);
		mv.setViewName("mostraGerente");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deletaAdministradora")
	public ModelAndView destroyAdministradora(final Long id) {
		administradoraService.removeAdministradora(id);
		ModelAndView mv = new ModelAndView("/administradora/administradoras",
				"administradoras", administradoraService.listAdministradoras());
		mv.setViewName("listaAdministradoras");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deletaGerente")
	public ModelAndView destroyGerente(Long id){
		gerenteService.removeGerente(id);
		ModelAndView mv = new ModelAndView("/gerente/gerentes", "gerentes", gerenteService.listGerentes());
		mv.setViewName("listaGerentes");
		return mv;
	}
	
	@InitBinder
	protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "predios", new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(final Object element) {
				return (element == null ? null : predioService.getPredio(Long.parseLong((String) element)));
			}
		});

		binder.registerCustomEditor(Administradora.class, "administradora", new PropertyEditorSupport() {
			@Override
			public void setAsText(final String id) {
				Administradora admin = administradoraService.getAdministradora(Long.parseLong(id));
				setValue(admin);
			}
		});
	}
}
