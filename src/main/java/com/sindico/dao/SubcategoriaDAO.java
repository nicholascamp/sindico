package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sindico.entity.Subcategoria;

/**
 * The Class SubcategoriaDAO.
 */
public class SubcategoriaDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;

	/**
	 * Cria sub categoria.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 * @return the subcategoria
	 */
	public Subcategoria criaSubCategoria(final Subcategoria subcategoria) {
		sessionFactory.getCurrentSession().save(subcategoria);
		return subcategoria;
	}

	/**
	 * Removes the subcategoria.
	 * 
	 * @param id
	 *            the id
	 */
	public void removeSubcategoria(final Long id) {
		Subcategoria subcategoria = (Subcategoria) sessionFactory
				.getCurrentSession().load(Subcategoria.class, id);
		if (subcategoria != null) {
			sessionFactory.getCurrentSession().delete(subcategoria);
		}
	}

	/**
	 * Lista subcategorias.
	 * 
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Subcategoria> listaSubcategorias() {
		List<Subcategoria> subcategorias = new ArrayList<Subcategoria>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select subcategoria from Subcategoria subcategoria");
		subcategorias = query.list();

		return subcategorias;
	}

}
