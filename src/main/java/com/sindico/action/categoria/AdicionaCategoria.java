package com.sindico.action.categoria;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sindico.action.Logica;
import com.sindico.dao.CategoriaDAO;
import com.sindico.entity.Categoria;
import com.sindico.factory.CategoriaFactory;

/**
 * Servlet implementation class AdicionaCategoria
 */
public class AdicionaCategoria extends HttpServlet implements Logica{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaDAO			categoriaDAO;

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Categoria categoria = CategoriaFactory.criaCategoria(request.getParameter("nome"), null);
		
		if(categoria != null){
			categoriaDAO.criaCategoria(categoria);
			request.setAttribute("categoria", categoria);
			RequestDispatcher rd = request.getRequestDispatcher("mostra-categoria.jsp");
			rd.forward(request, response);
		}		
	}       
}
