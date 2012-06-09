package com.sindico;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
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

	/**
	 * Test criar usuario.
	 */
	public void testCriarListarERemoverUsuario() {

	}

}
