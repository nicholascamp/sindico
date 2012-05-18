package com.sindico;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;

/**
 * The Class UserTest.
 */

/**
 * @author lucas.oliveira
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:sindico-beans.xml")
@TransactionConfiguration
@Transactional
public class UserTest {

	/** The usuario dao. */
	@Autowired
	private UsuarioDAO	usuarioDAO;

	/**
	 * Test criar usuario.
	 */
	@Test
	public void testCriarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Nome");
		usuario.setCelular("11 77779999");
		usuario.setEmail("email@email.com");

		Usuario usuarioNovo = usuarioDAO.criaUsuario(usuario);

		Assert.assertNotNull("Usuario esperado: ", usuarioNovo);

	}

}
