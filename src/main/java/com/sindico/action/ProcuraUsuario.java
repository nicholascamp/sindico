package com.sindico.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.dao.UsuarioDAO;

/**
 * Servlet implementation class ProcuraUsuario
 */
@ContextConfiguration("classpath:sindico-beans.xml")
@TransactionConfiguration
@Transactional
@WebServlet("/AdicionaContato")
public class ProcuraUsuario extends HttpServlet implements Logica{
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String termoPesquisa = request.getParameter("pesquisa");
		
		Usuario usuario = null;
		
		String tipoPesquisa = request.getParameter("pesquisarPor");
		if(tipoPesquisa.equals("N"))
			usuario = usuarioDAO.recuperaUsuario(null); //fazer pesquisa por nome
		else if(tipoPesquisa.equals("E"))
			usuario = usuarioDAO.recuperaUsuario(null); //fazer pesquisa por email
		else
			usuario = usuarioDAO.recuperaUsuario(null); //fazer pesquisa por predio
		
		if(usuario != null){
			RequestDispatcher rd = request.getRequestDispatcher("mostra-contato.jsp");
			rd.forward(request, response);
		}
		
	}
       

}
