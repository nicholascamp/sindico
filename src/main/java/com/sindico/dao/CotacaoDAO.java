package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Cotacao;

// TODO: Auto-generated Javadoc
/**
 * The Class CotacaoDAO.
 */
@Repository
public class CotacaoDAO {
	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;

	/**
	 * Cria cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @return the cotacao
	 */
	@Transactional
	public Cotacao criaCotacao(final Cotacao cotacao) {
		sessionFactory.getCurrentSession().save(cotacao);
		return cotacao;
	}

	/**
	 * Atualiza cotacao.
	 * 
	 * @param cotacao
	 *            the cotacao
	 * @return the cotacao
	 */
	public Cotacao atualizaCotacao(final Cotacao cotacao) {
		sessionFactory.getCurrentSession().update(cotacao);
		return cotacao;
	}

	/**
	 * Recupera cotacao.
	 * 
	 * @param id
	 *            the id
	 * @return the cotacao
	 */
	public Cotacao recuperaCotacao(final Long id) {
		return (Cotacao) sessionFactory.getCurrentSession().load(Cotacao.class,
				id);
	}

	/**
	 * Removes the cotacao.
	 * 
	 * @param id
	 *            the id
	 */
	public void removeCotacao(final Long id) {
		Cotacao cotacao = (Cotacao) sessionFactory.getCurrentSession().load(
				Cotacao.class, id);
		if (cotacao != null) {
			sessionFactory.getCurrentSession().delete(cotacao);
		}
	}

	/**
	 * Lista cotacao.
	 * 
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Cotacao> listaCotacao() {
		List<Cotacao> cotacao = new ArrayList<Cotacao>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select cotacao from Cotacao cotacao");
		cotacao = query.list();

		return cotacao;
	}
}
