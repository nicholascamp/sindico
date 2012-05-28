package com.sindico.action.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;

/**
 * Servlet implementation class CriaUsuario.
 */
@Controller
public class CriaUsuario extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/** The usuario dao. */
	@Autowired
	private UsuarioDAO			usuarioDAO;

	/**
	 * Instantiates a new cria usuario.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public CriaUsuario() {
		super();
	}

	/**
	 * Do get.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Do post.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome, senha, email);

		usuarioDAO.criaUsuario(usuario);

		out.println("<html>");
		out.println("<body>");
		out.println("Usuario " + usuario.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");

	}
}
