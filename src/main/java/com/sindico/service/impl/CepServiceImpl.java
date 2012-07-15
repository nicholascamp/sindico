/**
 * 
 */
package com.sindico.service.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.sindico.entity.Cep;
import com.sindico.entity.CepSimples;
import com.sindico.service.CepService;

/**
 * @author Lucas
 * 
 */
@Service("cepService")
public class CepServiceImpl implements CepService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.CepService#recuperaCep(java.lang.String)
	 */
	@Override
	public CepSimples recuperaCep(final String cep) throws JAXBException,
			MalformedURLException {

		JAXBContext jc = JAXBContext.newInstance(Cep.class);

		Unmarshaller u = jc.createUnmarshaller();
		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep="
				+ cep + "&formato=xml");

		Cep wCep = (Cep) u.unmarshal(url);

		CepSimples cepSimples = new CepSimples(wCep);
		cepSimples.setCep(cep);

		return cepSimples;
	}

}
