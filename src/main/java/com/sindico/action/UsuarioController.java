package com.sindico.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HttpServletBean;

import com.sindico.action.usuario.AdicionaUsuario;
import com.sindico.action.usuario.ProcuraUsuario;

/**
 * Servlet implementation class UsuarioController.
 */
public class UsuarioController extends HttpServletBean {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Service.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Override
	protected void service(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		String parametro = request.getParameter("logica");

		try {
			if(parametro.equals("AdicionaUsuario"))
				new AdicionaUsuario().executa(request, response);
			else if(parametro.equals("ProcuraUsuario"))
				new ProcuraUsuario().executa(request, response);
			} catch (Exception e) {
				new ServletException("A lógica de negócios causou uma exceção", e);	
				System.out.println("Houve um erro no Controller de Usuário");
			}
	}
		
}
