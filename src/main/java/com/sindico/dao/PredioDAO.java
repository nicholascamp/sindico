package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.Predio;

/**
 * The Class PredioDAO.
 */
public class PredioDAO {

	/**
	 * Salva predio.
	 * 
	 * @param predio
	 *            the predio
	 */
	public static void salvaPredio(final Predio predio) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, predio);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva predio.
	 * 
	 * @param predio
	 *            the predio
	 * @param session
	 *            the session
	 */
	public static void salvaPredio(final Predio predio, final Session session) {
		try {
			HibernateFactory.saveObject(session, predio);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta predio.
	 * 
	 * @param predio
	 *            the predio
	 */
	public static void deletaPredio(final Predio predio) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, predio);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta predio.
	 * 
	 * @param predio
	 *            the predio
	 * @param session
	 *            the session
	 */
	public static void deletaPredio(final Predio predio, final Session session) {
		try {
			HibernateFactory.deleteObject(session, predio);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza predio.
	 * 
	 * @param predio
	 *            the predio
	 */
	public static void atualizaPredio(final Predio predio) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, predio);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza predio.
	 * 
	 * @param predio
	 *            the predio
	 * @param session
	 *            the session
	 */
	public static void atualizaPredio(final Predio predio, final Session session) {
		try {
			HibernateFactory.updateObject(session, predio);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
