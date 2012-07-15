/**
 * 
 */
package com.sindico.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Fornecedor;
import com.sindico.enums.Estado;
import com.sindico.enums.Estrela;
import com.sindico.service.FornecedorService;
import com.sindico.service.SubcategoriaService;
import com.sindico.utils.StringUtils;

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

	/** The subcategoria service. */
	@Autowired
	SubcategoriaService	subcategoriaService;

	/**
	 * Index fornecedor.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/listaFornecedores")
	public ModelAndView indexFornecedor() {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/fornecedores", "fornecedor", new Fornecedor());
		PagedListHolder<Fornecedor> pagedListHolder = new PagedListHolder<Fornecedor>(
				fornecedorService.listarFornecedores());
		pagedListHolder.setPageSize(20);

		List<Fornecedor> pagedListFornecedores = pagedListHolder.getPageList();

		modelAndView.addObject("fornecedores", pagedListFornecedores);

		modelAndView.setViewName("listaFornecedores");

		return modelAndView;
	}

	/**
	 * List fornecedor by nome.
	 * 
	 * @param nome
	 *            the nome
	 * @return the model and view
	 */
	@RequestMapping(
			method = RequestMethod.GET, value = "/listaFornecedoresPorNome")
	public ModelAndView listFornecedorByNome(@RequestParam final String nome) {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/fornecedores", "fornecedor", new Fornecedor());
		PagedListHolder<Fornecedor> pagedListHolder = new PagedListHolder<Fornecedor>(
				fornecedorService.listarFornecedorPorNome(nome));
		pagedListHolder.setPageSize(20);

		List<Fornecedor> pagedListFornecedores = pagedListHolder.getPageList();

		modelAndView.addObject("fornecedores", pagedListFornecedores);

		modelAndView.setViewName("listaFornecedores");

		return modelAndView;
	}

	/**
	 * List fornecedor by endereco.
	 * 
	 * @param endereco
	 *            the endereco
	 * @return the model and view
	 */
	@RequestMapping(
			method = RequestMethod.GET, value = "/listaFornecedoresPorEndereco")
	public ModelAndView listFornecedorByEndereco(
			@RequestParam final String endereco) {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/fornecedores", "fornecedor", new Fornecedor());
		PagedListHolder<Fornecedor> pagedListHolder = new PagedListHolder<Fornecedor>(
				fornecedorService.listarFornecedorPorEndereco(endereco));
		pagedListHolder.setPageSize(20);

		List<Fornecedor> pagedListFornecedores = pagedListHolder.getPageList();

		modelAndView.addObject("fornecedores", pagedListFornecedores);
		modelAndView.setViewName("listaFornecedores");

		return modelAndView;
	}

	/**
	 * List fornecedor by email.
	 * 
	 * @param email
	 *            the email
	 * @return the model and view
	 */
	@RequestMapping(
			method = RequestMethod.GET, value = "/listaFornecedoresPorEmail")
	public ModelAndView listFornecedorByEmail(@RequestParam final String email) {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/fornecedores", "fornecedor", new Fornecedor());
		PagedListHolder<Fornecedor> pagedListHolder = new PagedListHolder<Fornecedor>(
				fornecedorService.listarFornecedorPorEmail(email));
		pagedListHolder.setPageSize(20);

		List<Fornecedor> pagedListFornecedores = pagedListHolder.getPageList();

		modelAndView.addObject("fornecedores", pagedListFornecedores);
		modelAndView.setViewName("listaFornecedores");

		return modelAndView;
	}

	/**
	 * List fornecedor by cnpj.
	 * 
	 * @param cnpj
	 *            the cnpj
	 * @return the model and view
	 */
	@RequestMapping(
			method = RequestMethod.GET, value = "/listaFornecedoresPorCNPJ")
	public ModelAndView listFornecedorByCNPJ(@RequestParam final String cnpj) {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/fornecedores", "fornecedor", new Fornecedor());
		PagedListHolder<Fornecedor> pagedListHolder = new PagedListHolder<Fornecedor>(
				fornecedorService.listarFornecedoresPorCNPJ(cnpj));
		pagedListHolder.setPageSize(20);

		List<Fornecedor> pagedListFornecedores = pagedListHolder.getPageList();

		modelAndView.addObject("fornecedores", pagedListFornecedores);

		modelAndView.setViewName("listaFornecedores");

		return modelAndView;
	}

	/**
	 * Show categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/mostraFornecedor")
	public ModelAndView showFornecedor(final Long id) {
		ModelAndView modelAndView = new ModelAndView("/fornecedor/fornecedor",
				"fornecedor", new Fornecedor());

		modelAndView.addObject("fornecedor",
				fornecedorService.getFornecedor(id));

		modelAndView.setViewName("mostraFornecedor");
		return modelAndView;
	}

	/**
	 * New categoria.
	 * 
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/criaFornecedor")
	public ModelAndView newFornecedor() {
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/criaFornecedor", "fornecedor", new Fornecedor());
		modelAndView.addObject("estrelas", Estrela.values());
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject("subcategoriasFornecedor",
				subcategoriaService.listSubcategorias());

		modelAndView.setViewName("criaFornecedor");

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
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/criaFornecedor")
	public ModelAndView createFornecedor(
			@ModelAttribute("fornecedor") final Fornecedor fornecedor,
			final BindingResult result) throws Exception {

		String plainTextPassword = fornecedor.getPassword();
		String encodedPassword = StringUtils.encodePassword(plainTextPassword,
				fornecedor.getUsername());
		fornecedor.setPassword(encodedPassword);
		fornecedorService.criarFornecedor(fornecedor);

		ModelAndView modelAndView = new ModelAndView("/fornecedor/fornecedor",
				"fornecedor", fornecedor);

		modelAndView.setViewName("mostraFornecedor");

		return modelAndView;
	}

	/**
	 * Edits the categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/editaFornecedor")
	public ModelAndView editFornecedor(final Long id) {
		Fornecedor fornecedor = fornecedorService.getFornecedor(id);
		ModelAndView modelAndView = new ModelAndView(
				"/fornecedor/editaFornecedor", "fornecedor", fornecedor);
		modelAndView.addObject("estrelas", Estrela.values());
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject("subcategoriasFornecedor",
				subcategoriaService.listSubcategorias());

		modelAndView.setViewName("editaFornecedor");
		return modelAndView;
	}

	/**
	 * Update categoria.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/editaFornecedor")
	public ModelAndView updateFornecedor(final Fornecedor fornecedor) {
		fornecedorService.atualizarFornecedor(fornecedor);

		ModelAndView modelAndView = new ModelAndView("/fornecedor/fornecedor",
				"fornecedor", fornecedor);

		modelAndView.setViewName("mostraFornecedor");
		return modelAndView;
	}

	/**
	 * Destroy categoria.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/deletaFornecedor")
	public String destroyFornecedor(final Long id) {

		fornecedorService.removerFornecedor(id);

		return "redirect:/listaFornecedores";
	}

	/**
	 * Inits the binder.
	 * 
	 * @param request
	 *            the request
	 * @param binder
	 *            the binder
	 * @throws Exception
	 *             the exception
	 */
	@InitBinder
	protected void initBinder(final HttpServletRequest request,
			final ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "subcategorias",
				new CustomCollectionEditor(List.class) {
					@Override
					protected Object convertElement(final Object element) {
						return (element == null ? null : subcategoriaService
								.getSubcategoria(Long
										.parseLong((String) element)));
					}
				});

		binder.registerCustomEditor(Estado.class, "estado",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Estado estado = Estado.valueOf(id);
						setValue(estado);
					}
				});

		binder.registerCustomEditor(Estrela.class, "estrela",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Estrela estrela = Estrela.valueOf(id);
						setValue(estrela);
					}
				});
	}
}
