package com.sindico.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import com.sindico.entity.Endereco;
import com.sindico.factory.AdministradoraFactory;

public class AdministradoraDAOTeste extends TestCase implements Test{

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando teste AdministradoraDAO...");
	}
	
	public void testAdministradoraDAO(){
		Endereco endereco = new Endereco();
		endereco.setBairro("Vila Maria Alta");
		endereco.setCep("02126-070");
		endereco.setCidade("São Paulo");
		endereco.setComplemento("Casa");
		endereco.setEndereco("Rua Marquê de Pombal");
		endereco.setNumero(271);
		endereco.setEstado("SP");
		
		Collection<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(endereco);
		
		AdministradoraFactory.criaAdministradora(new Date(), "12345678910", 
				enderecos , "11 2967-2420", "11 8561-6083", "", "", null, null);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizando teste AdministradoraDAO.");
	}

}
