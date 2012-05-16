package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.Cotacao;

/**
 * The Class CotacaoDAO.
 */
public class CotacaoDAO {

	/**
	 * Salva cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 */
	public static void salvaCotacao(final Cotacao cotacao) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, cotacao);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @param session
	 *            the session
	 */
	public static void salvaCotacao(final Cotacao cotacao, final Session session) {
		try {
			HibernateFactory.saveObject(session, cotacao);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 */
	public static void deletaCotacao(final Cotacao cotacao) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, cotacao);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @param session
	 *            the session
	 */
	public static void deletaCotacao(final Cotacao cotacao, final Session session) {
		try {
			HibernateFactory.deleteObject(session, cotacao);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 */
	public static void atualizaCotacao(final Cotacao cotacao) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, cotacao);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @param session
	 *            the session
	 */
	public static void atualizaCotacao(final Cotacao cotacao, final Session session) {
		try {
			HibernateFactory.updateObject(session, cotacao);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
