package com.sindico.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sindico.entity.Subcategoria;

/**
 * The Class SubcategoriaDAO.
 */
@Repository
public class SubcategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public Subcategoria criaSubcategoria(final Subcategoria subcategoria) {
		return (Subcategoria) sessionFactory.getCurrentSession().save(subcategoria);
	}


	public void removeSubcategoria(final Long id) {
		Subcategoria subcategoria = (Subcategoria) sessionFactory.getCurrentSession().load(Subcategoria.class, id);
		if (subcategoria != null) {
			sessionFactory.getCurrentSession().delete(subcategoria);
		}
	}
}
