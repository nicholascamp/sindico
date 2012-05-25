package com.sindico.action;

import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;
import com.sindico.enums.TipoUsuario;
import com.sindico.factory.UsuarioFactory;

/**
 * Servlet implementation class AdicionaContato
 */
@ContextConfiguration("classpath:sindico-beans.xml")
@TransactionConfiguration
@Transactional
@WebServlet("/AdicionaContato")
public class AdicionaContato extends HttpServlet implements Logica{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioDAO	usuarioDAO;

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Seta variável telefone
		StringBuilder telefone = new StringBuilder();
		telefone.append(request.getParameter("ddd"));
		telefone.append(" ");
		telefone.append(request.getParameter("telefone"));
		
		//Seta variável celular
		StringBuilder celular = new StringBuilder();
		celular.append(request.getParameter("dddc"));
		celular.append(" ");
		celular.append(request.getParameter("celular"));
		
		
		Usuario usuario = UsuarioFactory.criaUsuario(request.getParameter("nome"), 
				request.getParameter("senha"), 
				telefone.toString(), celular.toString(), new Date(), new Date(), //ajeitar data de nascimento 
				request.getParameter("email"), 
				getRecebeCotacao(request.getParameter("recebeCotacao")), 
				getTipo(request.getParameter("tipoUsuario")), 
				null);
		
		usuarioDAO.criaUsuario(usuario);
		
	}

	private boolean getRecebeCotacao(String cotacao) {
		if(cotacao.equals("true"))
			return true;
		else 
			return false;
	}

	private TipoUsuario getTipo(String tipo) {
		
		if(tipo.equals("S"))
			return TipoUsuario.SINDICO;
		else if(tipo.equals("C"))
			return TipoUsuario.CONSELHO;
		else if(tipo.equals("M"))
			return TipoUsuario.MORADOR;
		else
			return TipoUsuario.ZELADOR;
	}      
    
}
