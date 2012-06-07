/**
 * 
 */
package com.sindico.controller;

import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.grepcepws.entity.xsd.ObterCepResponse;
import com.grepcepws.ws.GrepCepSoap11BindingStub;

/**
 * @author Lucas
 * 
 */
@Controller
@SessionAttributes
public class EnderecoController {

	@RequestMapping(method = RequestMethod.GET, value = "/endereco/cep")
	public void getCep() {
		try {
			GrepCepSoap11BindingStub stub = new GrepCepSoap11BindingStub(
					new URL(
							"http://webservice.grepcep.com/GrepCepWs/services/GrepCep.GrepCepHttpSoap11Endpoint/"),
					null);
			ObterCepResponse resp = stub.obterEnderecoCep("09607030",
					"201206051808195DJAWAZWXEUGXD6MOSX3R");
			System.out.println(resp.getResponseDescription());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
