package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.Usuario;

/**
 * The Class UsuarioDAO.
 */
public class UsuarioDAO {

	/**
	 * Salva usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 */
	public static void salvaUsuario(final Usuario usuario) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, usuario);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param session
	 *            the session
	 */
	public static void salvaUsuario(final Usuario usuario, final Session session) {
		try {
			HibernateFactory.saveObject(session, usuario);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 */
	public static void deletaUsuario(final Usuario usuario) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, usuario);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param session
	 *            the session
	 */
	public static void deletaUsuario(final Usuario usuario, final Session session) {
		try {
			HibernateFactory.deleteObject(session, usuario);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 */
	public static void atualizaUsuario(final Usuario usuario) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, usuario);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param session
	 *            the session
	 */
	public static void atualizaUsuario(final Usuario usuario, final Session session) {
		try {
			HibernateFactory.updateObject(session, usuario);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
