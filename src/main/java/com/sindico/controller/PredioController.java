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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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

	/** The predio service. */
	@Autowired
	private PredioService					predioService;

	/** The gerente administradora service. */
	@Autowired
	private GerenteAdministradoraService	gerenteAdministradoraService;

	/**
	 * Listar predios.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/predios.html")
	public ModelAndView listarPredios() {

		ModelAndView modelAndView = new ModelAndView("/predios", "predio",
				new Predio());
		PagedListHolder<Predio> pagedListHolder = new PagedListHolder<Predio>(
				predioService.listarPredios());
		pagedListHolder.setPageSize(2);

		List<Predio> pagedListPredios = pagedListHolder.getPageList();

		modelAndView.addObject("predios", pagedListPredios);

		return modelAndView;
	}

	/**
	 * Criar predio.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/criaPredio.html")
	public ModelAndView criarPredio() {
		ModelAndView modelAndView = new ModelAndView("/criaPredio", "predio",
				new Predio());

		modelAndView.addObject("tipos", TipoPredio.values());
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject("gerentes",
				gerenteAdministradoraService.listaGerentes());
		System.out.println("Cria Predio");
		return modelAndView;
	}

	/**
	 * Criar predio.
	 * 
	 * @param predio
	 *            the predio
	 * @param result
	 *            the result
	 * @return the string
	 */
	@RequestMapping(value = "/criaPredio", method = RequestMethod.POST)
	public String criarPredio(@ModelAttribute("predio") final Predio predio,
			final BindingResult result) {

		predioService.criarPredio(predio);

		return "redirect:predios.html";
	}

	/**
	 * Buscar predio.
	 * 
	 * @param nome
	 *            the nome
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/buscarPredioPorNome")
	public ModelAndView buscarPredio(@RequestParam final String nome) {

		ModelAndView modelAndView = new ModelAndView("/predios", "predio",
				new Predio());

		modelAndView.addObject("predios",
				predioService.buscarPredioPorNome(nome));

		return modelAndView;
	}

	/**
	 * Buscar predio por endereco.
	 * 
	 * @param endereco
	 *            the endereco
	 * @return the model and view
	 */
	@RequestMapping(
			method = RequestMethod.GET, value = "/buscarPredioPorEndereco")
	public ModelAndView buscarPredioPorEndereco(
			@RequestParam final String endereco) {

		ModelAndView modelAndView = new ModelAndView("/predios", "predio",
				new Predio());

		modelAndView.addObject("predios",
				predioService.buscarPredioPorEndereco(endereco));

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/removerPredio")
	public String removerPredio(@RequestParam final Long id) {

		predioService.deletarPredio(id);

		return "redirect:predios.html";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/atualizarPredio")
	public String atualizarPredio(
			@ModelAttribute("predio") final Predio predio,
			final BindingResult result) {

		predioService.atualizarPredio(predio);

		return "redirect:predios.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/atualizarPredio.html")
	public ModelAndView atualizarPredio(@RequestParam final Long id) {

		ModelAndView modelAndView = new ModelAndView("/atualizaPredio",
				"predio", predioService.getPredio(id));

		modelAndView.addObject("tipos", TipoPredio.values());
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject("gerentes",
				gerenteAdministradoraService.listaGerentes());
		System.out.println("Atualiza Predio");

		return modelAndView;
	}

}
