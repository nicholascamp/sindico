/**
 * 
 */
package com.sindico.controller;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sindico.entity.CepSimples;
import com.sindico.service.CepService;

/**
 * The Class CepController.
 */
@Controller
@SessionAttributes
public class CepController {

	@Autowired
	private CepService	cepService;

	/**
	 * Recupera cep.
	 * 
	 * @param req
	 *            the req
	 * @param response
	 *            the response
	 * @return the cep
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/cep")
	@ResponseBody
	public CepSimples recuperaCEP(final HttpServletRequest req,
			final HttpServletResponse response) throws JAXBException,
			MalformedURLException {

		String cep = req.getParameter("cep");

		return cepService.recuperaCep(cep);

	}
}
