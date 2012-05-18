package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.RespostaCotacao;

/**
 * The Class RespostaCotacaoDAO.
 */
public class RespostaCotacaoDAO {

	/**
	 * Salva resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 */
	public static void salvaRespostaCotacao(final RespostaCotacao respostaCotacao) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, respostaCotacao);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Salva resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 * @param session
	 *            the session
	 */
	public static void salvaRespostaCotacao(final RespostaCotacao respostaCotacao, final Session session) {
		try {
			HibernateFactory.saveObject(session, respostaCotacao);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 */
	public static void deletaRespostaCotacao(final RespostaCotacao respostaCotacao) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, respostaCotacao);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 * @param session
	 *            the session
	 */
	public static void deletaRespostaCotacao(final RespostaCotacao respostaCotacao, final Session session) {
		try {
			HibernateFactory.deleteObject(session, respostaCotacao);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 */
	public static void atualizaRespostaCotacao(final RespostaCotacao respostaCotacao) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, respostaCotacao);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza resposta cotacao.
	 * 
	 * @param respostaCotacao
	 *            the resposta cotacao
	 * @param session
	 *            the session
	 */
	public static void atualizaRespostaCotacao(final RespostaCotacao respostaCotacao, final Session session) {
		try {
			HibernateFactory.updateObject(session, respostaCotacao);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
