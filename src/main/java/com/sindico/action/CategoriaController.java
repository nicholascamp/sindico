package com.sindico.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sindico.action.categoria.AdicionaCategoria;

/**
 * Servlet implementation class CategoriaController
 */
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		String parametro = request.getParameter("logica");

		try {
			if(parametro.equals("AdicionaCategoria"))
				new AdicionaCategoria().executa(request, response);
			else if(parametro.equals("ProcuraCategoria"))
				return;
			
			} catch (Exception e) {
				new ServletException("A lógica de negócios causou uma exceção", e);				
			}
	}

}
