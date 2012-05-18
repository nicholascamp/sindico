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

	public void removeAdministradora(final Long id) {
		Administradora administradora = (Administradora) sessionFactory
				.getCurrentSession().load(Administradora.class, id);
		if (administradora != null) {
			sessionFactory.getCurrentSession().delete(administradora);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Administradora> listaUsuarios() {
		List<Administradora> administradoras = new ArrayList<Administradora>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select administradora from Usuario administradora");
		administradoras = query.list();

		return administradoras;
	}
}
