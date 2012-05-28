package com.sindico.action.usuario;

import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sindico.action.Logica;
import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;

/**
 * Servlet implementation class ProcuraUsuario
 */
public class ProcuraUsuario extends HttpServlet implements Logica {
	private static final long	serialVersionUID	= 1L;

	@Autowired
	private UsuarioDAO			usuarioDAO;

	@Override
	public void executa(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String termoPesquisa = request.getParameter("pesquisa");

		Collection<Usuario> usuarios = null;
		
		String tipoPesquisa = request.getParameter("pesquisarPor");
		if (tipoPesquisa.equals("N")) {
			usuarios = usuarioDAO.getUsuarioNome(termoPesquisa); // fazer pesquisa por
														// nome
		} else if (tipoPesquisa.equals("E")) {
			usuarios = usuarioDAO.getUsuarioEmail(termoPesquisa); //  fazer pesquisa por
														// email
		} else {
			usuarios = usuarioDAO.getUsuarioPredio(termoPesquisa); // fazer pesquisa por
															// predio
		}

		if (usuarios != null) {
			request.setAttribute("usuarios", usuarios);
			RequestDispatcher rd = request
					.getRequestDispatcher("lista-usuarios.jsp");
			rd.forward(request, response);
		}

	}
}
