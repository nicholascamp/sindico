package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Subcategoria;

/**
 * The Class SubcategoriaDAO.
 */
@Repository
public class SubcategoriaDAO {
	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;


	@Transactional
	public Subcategoria criaSubcategoria(final Subcategoria subcategoria) {
		sessionFactory.getCurrentSession().save(subcategoria);
		return subcategoria;
	}


	public Subcategoria atualizaSubcategoria(final Subcategoria subcategoria) {
		sessionFactory.getCurrentSession().update(subcategoria);
		return subcategoria;
	}


	public Subcategoria getSubcategoria(final Long id) {
		return (Subcategoria) sessionFactory.getCurrentSession().load(Subcategoria.class,
				id);
	}


	public void removeSubcategoria(final Long id) {
		Subcategoria subcategoria = (Subcategoria) sessionFactory.getCurrentSession().load(
				Subcategoria.class, id);
		if (subcategoria != null) {
			sessionFactory.getCurrentSession().delete(subcategoria);
		}
	}


	@SuppressWarnings("unchecked")
	public List<Subcategoria> getLista() {
		List<Subcategoria> subcategoria = new ArrayList<Subcategoria>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select subcategoria from Subcategoria subcategoria");
		subcategoria = query.list();

		return subcategoria;
	}
	
}

