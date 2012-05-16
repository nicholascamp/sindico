package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.Categoria;

/**
 * The Class CategoriaDAO.
 */
public class CategoriaDAO {

	/**
	 * Salva categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 */
	public static void salvaCategoria(final Categoria categoria) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, categoria);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @param session
	 *            the session
	 */
	public static void salvaCategoria(final Categoria categoria, final Session session) {
		try {
			HibernateFactory.saveObject(session, categoria);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 */
	public static void deletaCategoria(final Categoria categoria) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, categoria);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @param session
	 *            the session
	 */
	public static void deletaCategoria(final Categoria categoria, final Session session) {
		try {
			HibernateFactory.deleteObject(session, categoria);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 */
	public static void atualizaCategoria(final Categoria categoria) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, categoria);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @param session
	 *            the session
	 */
	public static void atualizaCategoria(final Categoria categoria, final Session session) {
		try {
			HibernateFactory.updateObject(session, categoria);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
