package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Fornecedor;

/**
 * The Class FornecedorDAO.
 */
@Repository
public class FornecedorDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;


	@Transactional
	public Fornecedor criaFornecedor(final Fornecedor fornecedor) {
		sessionFactory.getCurrentSession().save(fornecedor);
		return fornecedor;
	}


	public Fornecedor atualizaFornecedor(final Fornecedor fornecedor) {
		sessionFactory.getCurrentSession().update(fornecedor);
		return fornecedor;
	}


	public Fornecedor getFornecedor(final Long id) {
		return (Fornecedor) sessionFactory.getCurrentSession().load(Fornecedor.class,
				id);
	}


	public void removeFornecedor(final Long id) {
		Fornecedor fornecedor = (Fornecedor) sessionFactory.getCurrentSession().load(
				Fornecedor.class, id);
		if (fornecedor != null) {
			sessionFactory.getCurrentSession().delete(fornecedor);
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fornecedor> getLista() {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select fornecedor from Fornecedor fornecedor");
		fornecedores = query.list();

		return fornecedores;
	}

}
