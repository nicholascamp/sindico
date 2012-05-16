package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.Fornecedor;

/**
 * The Class FornecedorDAO.
 */
public class FornecedorDAO {

	/**
	 * Salva fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 */
	public static void salvaFornecedor(final Fornecedor fornecedor) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, fornecedor);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @param session
	 *            the session
	 */
	public static void salvaFornecedor(final Fornecedor fornecedor, final Session session) {
		try {
			HibernateFactory.saveObject(session, fornecedor);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 */
	public static void deletaFornecedor(final Fornecedor fornecedor) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, fornecedor);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @param session
	 *            the session
	 */
	public static void deletaFornecedor(final Fornecedor fornecedor, final Session session) {
		try {
			HibernateFactory.deleteObject(session, fornecedor);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 */
	public static void atualizaFornecedor(final Fornecedor fornecedor) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, fornecedor);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @param session
	 *            the session
	 */
	public static void atualizaFornecedor(final Fornecedor fornecedor, final Session session) {
		try {
			HibernateFactory.updateObject(session, fornecedor);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
