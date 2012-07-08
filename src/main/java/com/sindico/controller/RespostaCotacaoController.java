package com.sindico.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.sindico.service.CotacaoService;
import com.sindico.service.FornecedorService;
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
	
	@Autowired
	FornecedorService fornecedorService;
	
	Cotacao cotacao;
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaRespostaCotacao")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/respostas", "respostas", service.listRespostasCotacao());
		mv.setViewName("listaRespostaCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaRespostaCotacaoPorCotacao")
	public ModelAndView indexCotacao(Long cotacaoId){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/respostas", "respostas", service.listarRespostas(cotacaoId));
		cotacao = service.getCotacao(cotacaoId);
		mv.addObject("cotacao", cotacao);
		mv.setViewName("listaRespostaCotacaoPorCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/mostraRespostaCotacao")
	public ModelAndView showRespostaCotacao(Long id){
		ModelAndView mv = new ModelAndView("/cotacao/respostaCotacao/resposta", "resposta", service.getRespostaCotacao(id));
		mv.setViewName("mostraRespostaCotacao");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/criaRespostaCotacao")
	public ModelAndView newRespostaCotacao() {
		RespostaCotacao resposta =  new RespostaCotacao();
		resposta.setCotacao(cotacao);
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
		
		binder.registerCustomEditor(Date.class, 
    			new CustomDateEditor(new SimpleDateFormat("dd/mm/yy"), false));

		binder.registerCustomEditor(Fornecedor.class, "fornecedor",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(final String id) {
						Fornecedor fornecedor = fornecedorService.getFornecedor(Long.parseLong(id));
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
	}
}
