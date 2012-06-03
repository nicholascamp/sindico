package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Categoria;

/**
 * The Class CategoriaDAO.
 */
@Repository
public class CategoriaDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;

	@Transactional
	public Categoria criaCategoria(final Categoria categoria) {
		sessionFactory.getCurrentSession().save(categoria);
		return categoria;
	}

	public Categoria atualizaCategoria(final Categoria categoria) {
		sessionFactory.getCurrentSession().update(categoria);
		return categoria;
	}

	public Categoria getCategoria(final Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select categoria from Categoria categoria where categoria.id = "
						+ id);

		return (Categoria) query.uniqueResult();
	}
	
	public Categoria getCategoriaPorNome(String nome){
		Query query = sessionFactory.getCurrentSession().createQuery(
			"select categoria from Categoria categoria where categoria.nome like %" + nome + "%");
		
		return (Categoria) query.uniqueResult();
	}

	public void removeCategoria(final Long id) {
		Categoria categoria = (Categoria) sessionFactory.getCurrentSession()
				.load(Categoria.class, id);
		if (categoria != null) {
			sessionFactory.getCurrentSession().delete(categoria);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> getLista() {
		List<Categoria> categoria = new ArrayList<Categoria>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select categoria from Categoria categoria");
		categoria = query.list();

		return categoria;
	}
}
