package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Predio;

/**
 * The Class PredioDAO.
 */
@Repository
public class PredioDAO {
	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;


	@Transactional
	public Predio criaPredio(final Predio predio) {
		sessionFactory.getCurrentSession().save(predio);
		return predio;
	}


	public Predio atualizaPredio(final Predio predio) {
		sessionFactory.getCurrentSession().update(predio);
		return predio;
	}


	public Predio getPredio(final Long id) {
		return (Predio) sessionFactory.getCurrentSession().load(Predio.class,
				id);
	}


	public void removePredio(final Long id) {
		Predio predio = (Predio) sessionFactory.getCurrentSession().load(
				Predio.class, id);
		if (predio != null) {
			sessionFactory.getCurrentSession().delete(predio);
		}
	}


	@SuppressWarnings("unchecked")
	public List<Predio> getLista() {
		List<Predio> predio = new ArrayList<Predio>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select predio from Predio predio");
		predio = query.list();

		return predio;
	}

}
