package com.sindico.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HttpServletBean;

/**
 * Servlet implementation class UsuarioController.
 */
<<<<<<< HEAD
public class UsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "com.sindico.action" + parametro;
		
=======
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
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;

>>>>>>> 1235b54d467ce742abd4cde44108cdd1bdf75370
		try {
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
<<<<<<< HEAD
			
			} catch (Exception e) {
				new ServletException("A lógica de negócios causou uma exceção", e);				
			}
		
=======

		} catch (Exception e) {
			throw new ServletException(
					"A lógica de negócios causou uma exceção", e);
		}
>>>>>>> 1235b54d467ce742abd4cde44108cdd1bdf75370
	}

}
