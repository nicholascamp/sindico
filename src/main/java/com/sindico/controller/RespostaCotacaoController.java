package com.sindico.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.RespostaCotacao;
import com.sindico.entity.Usuario;
import com.sindico.enums.Status;
import com.sindico.service.CotacaoService;
import com.sindico.service.FornecedorService;
import com.sindico.service.PredioService;
import com.sindico.service.UsuarioService;

@Controller
@SessionAttributes
public class RespostaCotacaoController {

	@Autowired
	CotacaoService		service;

	@Autowired
	PredioService		predioService;

	@Autowired
	UsuarioService		usuarioService;

	@Autowired
	FornecedorService	fornecedorService;

	@RequestMapping(method = RequestMethod.GET, value = "/listaRespostaCotacao")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView(
				"/cotacao/respostaCotacao/respostas", "respostas",
				service.listRespostasCotacao());
		mv.setViewName("listaRespostaCotacao");
		return mv;
	}

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/listaRespostaCotacaoPorCotacao")
	public ModelAndView indexCotacao(final Long cotacaoId) {
		ModelAndView mv = new ModelAndView(
				"/cotacao/respostaCotacao/respostas", "respostas",
				service.listRespostasCotacao(cotacaoId));
		
		mv.addObject("cotacao", service.getCotacao(cotacaoId));
		mv.setViewName("listaRespostaCotacaoPorCotacao");
		return mv;
	}

	@RequestMapping(
			method = RequestMethod.GET, value = "/mostraRespostaCotacao")
	public ModelAndView showRespostaCotacao(final Long id) {
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/resposta",
				"resposta", service.getRespostaCotacao(id));
		mv.setViewName("mostraRespostaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/criaRespostaCotacao")
	public ModelAndView newRespostaCotacao(Cotacao cotacao) {
		
		RespostaCotacao resposta = new RespostaCotacao();
		
		if(usuarioService.ehUsuarioLogado()){
			ModelAndView mv = new ModelAndView(
					"/cotacao/cotacao", "cotacao", cotacao);
			mv.addObject("msg", "A abertura de negociação é sempre feita por um Fornecedor.");
			mv.setViewName("mostraCotacao");
			return mv;
		}
		else{
			if(!service.possuiNegociacaoAberta(cotacao.getId(), fornecedorService.getLoggedFornecedor().getId())){
				cotacao = service.getCotacao(cotacao.getId());		
				cotacao.setStatus(Status.TRABALHO);
				cotacao.setDataAtualizacao(new Date());
				service.atualizarCotacao(cotacao);

				resposta.setCotacao(cotacao);
				resposta.setPredio(cotacao.getPredio());			
				resposta.setFornecedor(fornecedorService.getLoggedFornecedor());
				
				ModelAndView mv = new ModelAndView(
						"/cotacao/respostaCotacao/criaResposta", "resposta", resposta);
				mv.setViewName("criaRespostaCotacao");
				return mv;
			}
			else{
				ModelAndView mv = new ModelAndView(
						"/cotacao/cotacao", "cotacao", cotacao);
				mv.addObject("msg", "Fornecedor já possui negociação na Cotação.");
				mv.setViewName("mostraCotacao");
				return mv;
			}
			
		}	
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/criaRespostaCotacaoResposta")
	public ModelAndView newRespostaCotacao(final Long idRespostaCotacao) {
		RespostaCotacao respostaAnterior = service
				.getRespostaCotacao(idRespostaCotacao);
		List<RespostaCotacao> respostas = service.listRespostasCotacao(
				respostaAnterior.getCotacao().getId(), respostaAnterior
						.getFornecedor().getId());

		RespostaCotacao resposta = new RespostaCotacao();
		resposta.setCotacao(respostaAnterior.getCotacao());
		resposta.setFornecedor(respostaAnterior.getFornecedor());
		resposta.setPredio(respostaAnterior.getPredio());
		
		ModelAndView mv = new ModelAndView(
				"/cotacao/respostaCotacao/criaResposta", "resposta", resposta);
		mv.addObject("respostas", respostas);
		mv.setViewName("criaRespostaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/criaRespostaCotacao")
	public ModelAndView createRespostaCotacao(
			@ModelAttribute("resposta") final RespostaCotacao respostaCotacao) {
		respostaCotacao.setPredio(predioService.getPredio(usuarioService
				.getLoggedUser()));
		respostaCotacao.setData(new Date());		

		ModelAndView mv = new ModelAndView(
				"/cotacao/respostaCotacao/resposta", "resposta",
				service.criaRespostaCotacao(respostaCotacao));
		mv.setViewName("mostraRespostaCotacao");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editaRespostaCotacao")
	public ModelAndView editRespostaCotacao(final Long id) {
		ModelAndView mv = new ModelAndView(
				"/cotacao/respostaCotacao/editaResposta", "resposta",
				service.getRespostaCotacao(id));
		mv.setViewName("editaRespostaCotacao");
		return mv;
	}

	@RequestMapping(
			method = RequestMethod.POST, value = "/editaRespostaCotacao")
	public ModelAndView updateRespostaCotacao(
			@ModelAttribute("resposta") final RespostaCotacao respostaCotacao) {
		ModelAndView mv = new ModelAndView(
				"/cotacao/respostaCotacao/resposta", "resposta",
				service.updateRespostaCotacao(respostaCotacao));
		mv.setViewName("mostraRespostaCotacao");
		return mv;
	}

	@RequestMapping(
			method = RequestMethod.GET, value = "/deletaRespostaCotacao")
	public ModelAndView destroyRespostaCotacao(final Long id) {
		long idCotacao = service.getRespostaCotacao(id).getCotacao().getId();
		service.removeRespostaCotacao(id);
		ModelAndView mv = new ModelAndView(
				"/cotacao/respostaCotacao/respostas", "respostas",
				service.listRespostasCotacao(idCotacao));
		mv.setViewName("listaRespostaCotacaoPorCotacao");
		return mv;
	}

	@InitBinder
	protected void initBinder(final HttpServletRequest request,
			final ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Usuario.class, "usuario",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Usuario usuario = usuarioService.buscaUsuario(Long
								.parseLong(id));
						setValue(usuario);
					}
				});

		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/mm/yy"), false));

		binder.registerCustomEditor(Fornecedor.class, "fornecedor",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Fornecedor fornecedor = fornecedorService
								.getFornecedor(Long.parseLong(id));
						setValue(fornecedor);
					}
				});

		binder.registerCustomEditor(Fornecedor.class, "fornecedorVencedor",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Fornecedor fornecedor = fornecedorService
								.getFornecedor(Long.parseLong(id));
						setValue(fornecedor);
					}
				});
		binder.registerCustomEditor(Cotacao.class,
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Cotacao cotacao = service.getCotacao(Long.parseLong(id));
						setValue(cotacao);
					}
				});
	}
}
