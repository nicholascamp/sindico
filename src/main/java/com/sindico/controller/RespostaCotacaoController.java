package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.entity.RespostaCotacao;
import com.sindico.service.CotacaoService;
import com.sindico.service.PredioService;
import com.sindico.service.UsuarioService;

@Controller
@SessionAttributes
public class RespostaCotacaoController {
	
	@Autowired
	CotacaoService service;
	
	@Autowired
	PredioService predioService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaRespostaCotacao")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/respostas", "respostas", service.listRespostasCotacao());
		mv.setViewName("listaRespostaCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaRespostaCotacaoPorCotacao")
	public ModelAndView indexCotacao(Long id){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/respostas", "respostas", service.listarRespostas(id));
		mv.setViewName("listaRespostaCotacaoPorCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/mostraRespostaCotacao")
	public ModelAndView showCotacao(Long id){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/resposta", "resposta", service.getCotacao(id));
		mv.setViewName("mostraRespostaCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/criaRespostaCotacao")
	public ModelAndView newRespostaCotacao(Long id) {
		RespostaCotacao resposta =  new RespostaCotacao();
		resposta.setCotacao(service.getCotacao(id));
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/criaResposta", "resposta", resposta);
		mv.setViewName("criaRespostaCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/criaRespostaCotacao")
	public ModelAndView createRespostaCotacao(@ModelAttribute("resposta") RespostaCotacao respostaCotacao){		
		respostaCotacao.setPredio(predioService.getPredioUsuario(usuarioService.getLoggedUser()));
		// TODO Setar Fornecedor
		
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/mostraResposta", "resposta", service.criaRespostaCotacao(respostaCotacao));
		mv.setViewName("mostraResposta");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editaRespostaCotacao")
	public ModelAndView editRespostaCotacao(Long id){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/editaResposta", "resposta", service.getRespostaCotacao(id));
		mv.setViewName("editaRespostaCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editaRespostaCotacao")
	public ModelAndView updateRespostaCotacao(@ModelAttribute("resposta") RespostaCotacao respostaCotacao){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/mostraResposta", "resposta", service.updateRespostaCotacao(respostaCotacao));
		mv.setViewName("mostraResposta");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deletaRespostaCotacao")
	public ModelAndView destroyRespostaCotacao(Long id) {
		long idCotacao = service.getRespostaCotacao(id).getCotacao().getId();
		service.removeRespostaCotacao(id);
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/respostas", "respostas", service.listarRespostas(idCotacao));
		mv.setViewName("listaRespostaCotacaoPorCotacao");
		return mv;
		
	}
}
