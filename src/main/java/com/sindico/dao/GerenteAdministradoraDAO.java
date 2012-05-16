package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.GerenteAdministradora;

/**
 * The Class GerenteAdministradoraDAO.
 */
public class GerenteAdministradoraDAO {

	/**
	 * Salva gerente administradora.
	 * 
	 * @param gerenteAdministradora
	 *            the gerente administradora
	 */
	public static void salvaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, gerenteAdministradora);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva gerente administradora.
	 * 
	 * @param gerenteAdministradora
	 *            the gerente administradora
	 * @param session
	 *            the session
	 */
	public static void salvaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora,
			final Session session) {
		try {
			HibernateFactory.saveObject(session, gerenteAdministradora);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta gerente administradora.
	 * 
	 * @param gerenteAdministradora
	 *            the gerente administradora
	 */
	public static void deletaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, gerenteAdministradora);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta gerente administradora.
	 * 
	 * @param gerenteAdministradora
	 *            the gerente administradora
	 * @param session
	 *            the session
	 */
	public static void deletaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora,
			final Session session) {
		try {
			HibernateFactory.deleteObject(session, gerenteAdministradora);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza gerente administradora.
	 * 
	 * @param gerenteAdministradora
	 *            the gerente administradora
	 */
	public static void atualizaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, gerenteAdministradora);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza gerente administradora.
	 * 
	 * @param gerenteAdministradora
	 *            the gerente administradora
	 * @param session
	 *            the session
	 */
	public static void atualizaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora,
			final Session session) {
		try {
			HibernateFactory.updateObject(session, gerenteAdministradora);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
