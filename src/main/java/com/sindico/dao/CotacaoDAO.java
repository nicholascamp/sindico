package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Cotacao;

/**
 * The Class CotacaoDAO.
 */
@Repository
public class CotacaoDAO {
	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;


	@Transactional
	public Cotacao criaCotacao(final Cotacao cotacao) {
		sessionFactory.getCurrentSession().save(cotacao);
		return cotacao;
	}


	public Cotacao atualizaCotacao(final Cotacao cotacao) {
		sessionFactory.getCurrentSession().update(cotacao);
		return cotacao;
	}


	public Cotacao recuperaCotacao(final Long id) {
		return (Cotacao) sessionFactory.getCurrentSession().load(Cotacao.class,
				id);
	}


	public void removeCotacao(final Long id) {
		Cotacao cotacao = (Cotacao) sessionFactory.getCurrentSession().load(
				Cotacao.class, id);
		if (cotacao != null) {
			sessionFactory.getCurrentSession().delete(cotacao);
		}
	}


	@SuppressWarnings("unchecked")
	public List<Cotacao> listaCotacao() {
		List<Cotacao> cotacao = new ArrayList<Cotacao>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select cotacao from Cotacao cotacao");
		cotacao = query.list();

		return cotacao;
	}
}
