package com.sindico.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Interface Logica.
 */
public interface Logica {

	/**
	 * Executa.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws Exception
	 *             the exception
	 */
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}