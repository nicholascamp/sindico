/**
 * 
 */
package com.sindico.controller;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sindico.entity.Cep;

/**
 * The Class CepController.
 */
@Controller
@SessionAttributes
public class CepController {

	/**
	 * Recupera cep.
	 * 
	 * @param cep
	 *            the cep
	 * @return the cep
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/cep")
	public Cep recuperaCEP(@RequestParam final String cep)
			throws JAXBException, MalformedURLException {

		JAXBContext jc = JAXBContext.newInstance(Cep.class);

		Unmarshaller u = jc.createUnmarshaller();
		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep="
				+ cep + "&formato=xml");
		// URL url = new
		// URL("http://grepcep.com/callws.do?token=201206051808195DJAWAZWXEUGXD6MOSX3R&cep="
		// + cep
		// + "&style=xml");
		Cep wCep = (Cep) u.unmarshal(url);

		return wCep;

	}
}
