package com.sindico.action.usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/AdicionaContato")
public class ProcuraUsuario extends HttpServlet implements Logica {
	private static final long	serialVersionUID	= 1L;

	@Autowired
	private UsuarioDAO			usuarioDAO;

	@Override
	public void executa(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String termoPesquisa = request.getParameter("pesquisa");

		Usuario usuario = null;
		
		String tipoPesquisa = request.getParameter("pesquisarPor");
		if (tipoPesquisa.equals("N")) {
			usuario = usuarioDAO.getUsuarioNome(termoPesquisa); // fazer pesquisa por
														// nome
		} else if (tipoPesquisa.equals("E")) {
			usuario = usuarioDAO.getUsuarioEmail(termoPesquisa); //  fazer pesquisa por
														// email
		} else {
			usuario = usuarioDAO.getUsuarioPredio(termoPesquisa); // fazer pesquisa por
															// predio
		}

		if (usuario != null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("mostra-usuario.jsp");
			rd.forward(request, response);
		}

	}
}