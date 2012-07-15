/**
 * 
 */
package com.sindico.service;

import java.net.MalformedURLException;

import javax.xml.bind.JAXBException;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.CepSimples;

// TODO: Auto-generated Javadoc
/**
 * The Interface CepService.
 * 
 * @author Lucas
 */
public interface CepService {

	/**
	 * Recupera cep.
	 * 
	 * @param cep
	 *            the cep
	 * @return the cep simples
	 * @throws JAXBException
	 * @throws MalformedURLException
	 */
	@Transactional
	CepSimples recuperaCep(String cep) throws JAXBException,
			MalformedURLException;

}
