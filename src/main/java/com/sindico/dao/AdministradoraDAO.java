package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Administradora;

@Repository
public class AdministradoraDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;

	@Transactional
	public Administradora criaAdministradora(final Administradora administradora) {
		sessionFactory.getCurrentSession().save(administradora);
		return administradora;
	}
	
	public Administradora atualizaAdministradota(final Administradora administradora) {
		sessionFactory.getCurrentSession().update(administradora);
		return administradora;
	}


	public Administradora getAdministradora(final Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select administradora from Administradora administradora where administradora = "
						+ id);

		return (Administradora) query.uniqueResult();
	}

	public boolean removeAdministradora(final Long id) {
		Administradora administradora = (Administradora) sessionFactory
				.getCurrentSession().load(Administradora.class, id);
		if (administradora != null) {
			sessionFactory.getCurrentSession().delete(administradora);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Administradora> getLista() {
		List<Administradora> administradoras = new ArrayList<Administradora>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select administradora from Administradora administradora");
		administradoras = query.list();

		return administradoras;
	}
}
