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

import com.sindico.entity.Fornecedor;
import com.sindico.enums.Estado;
import com.sindico.enums.Estrela;
import com.sindico.service.FornecedorService;
import com.sindico.service.SubcategoriaService;

// TODO: Auto-generated Javadoc
/**
 * The Class FornecedorController.
 * 
 * @author Lucas
 */
@Controller
@SessionAttributes
public class FornecedorController {

	/** The fornecedor service. */
	@Autowired
	FornecedorService	fornecedorService;

	@Autowired
	SubcategoriaService	subcategoriaService;

	/**
	 * Index fornecedor.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fornecedor/lista")
	public ModelAndView indexFornecedor() {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/fornecedores", "fornecedor", new Fornecedor());
		PagedListHolder<Fornecedor> pagedListHolder = new PagedListHolder<Fornecedor>(
				fornecedorService.listarFornecedores());
		pagedListHolder.setPageSize(20);

		List<Fornecedor> pagedListFornecedores = pagedListHolder.getPageList();

		modelAndView.addObject("fornecedores", pagedListFornecedores);

		return modelAndView;
	}

	/**
	 * Show categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fornecedor/mostra")
	public ModelAndView showFornecedor(final Long id) {
		ModelAndView modelAndView = new ModelAndView("/fornecedor/fornecedor",
				"fornecedor", new Fornecedor());

		modelAndView.addObject("fornecedor",
				fornecedorService.getFornecedor(id));
		return modelAndView;
	}

	/**
	 * New categoria.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fornecedor/cria")
	public ModelAndView newFornecedor() {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/criaFornecedor", "fornecedor", new Fornecedor());
		modelAndView.addObject("estrelas", Estrela.values());
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject("subcategorias",
				subcategoriaService.listSubcategorias());

		return modelAndView;
	}

	/**
	 * Creates the categoria.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/fornecedor/cria")
	public ModelAndView createFornecedor(
			@ModelAttribute("fornecedor") final Fornecedor fornecedor,
			final BindingResult result) {
		fornecedorService.criarFornecedor(fornecedor);

		return new ModelAndView("/fornecedor/fornecedor", "fornecedor",
				fornecedor);
	}

	/**
	 * Edits the categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fornecedor/edita")
	public ModelAndView editFornecedor(final Long id) {
		Fornecedor fornecedor = fornecedorService.getFornecedor(id);

		return new ModelAndView("/fornecedor/editaFornecedor", "fornecedor",
				fornecedor);
	}

	/**
	 * Update categoria.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/fornecedor/edita")
	public ModelAndView updateFornecedor(final Fornecedor fornecedor) {
		fornecedorService.atualizarFornecedor(fornecedor);

		return new ModelAndView("/fornecedor/fornecedor", "fornecedor",
				fornecedor);
	}

	/**
	 * Destroy categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/fornecedor/deleta")
	public ModelAndView destroyFornecedor(final Fornecedor fornecedor) {
		fornecedorService.removerFornecedor(fornecedor.getCodigo());

		return new ModelAndView("/fornecedor/fornecedores", "fornecedores",
				fornecedorService.listarFornecedores());
	}

	/**
	 * 
	 * BUSCAS POR: NOME, EMAIL, ENDERECO E CNPJ
	 */

	/**
	 * USUARIO, FORNECEDOR
	 * 
	 * COTACOES, UPLOAD
	 * 
	 * 
	 * WEBSERVICE CORREIOS
	 * 
	 */
}
