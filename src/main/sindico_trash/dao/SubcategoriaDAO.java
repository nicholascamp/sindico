package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.Subcategoria;

/**
 * The Class SubcategoriaDAO.
 */
public class SubcategoriaDAO {

	/**
	 * Salva subcategoria.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 */
	public static void salvaSubcategoria(final Subcategoria subcategoria) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, subcategoria);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva subcategoria.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 * @param session
	 *            the session
	 */
	public static void salvaSubcategoria(final Subcategoria subcategoria, final Session session) {
		try {
			HibernateFactory.saveObject(session, subcategoria);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta subcategoria.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 */
	public static void deletaSubcategoria(final Subcategoria subcategoria) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, subcategoria);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta subcategoria.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 * @param session
	 *            the session
	 */
	public static void deletaSubcategoria(final Subcategoria subcategoria, final Session session) {
		try {
			HibernateFactory.deleteObject(session, subcategoria);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza subcategoria.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 */
	public static void atualizaSubcategoria(final Subcategoria subcategoria) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, subcategoria);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza subcategoria.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 * @param session
	 *            the session
	 */
	public static void atualizaSubcategoria(final Subcategoria subcategoria, final Session session) {
		try {
			HibernateFactory.updateObject(session, subcategoria);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
