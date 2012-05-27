package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.GerenteAdministradora;

/**
 * The Class GerenteAdministradoraDAO.
 */
@Repository
public class GerenteAdministradoraDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;


	@Transactional
	public GerenteAdministradora criaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora) {
		sessionFactory.getCurrentSession().save(gerenteAdministradora);
		return gerenteAdministradora;
	}


	public GerenteAdministradora atualizaGerenteAdministradora(final GerenteAdministradora gerenteAdministradora) {
		sessionFactory.getCurrentSession().update(gerenteAdministradora);
		return gerenteAdministradora;
	}


	public GerenteAdministradora getGerenteAdministradora(final Long id) {
		return (GerenteAdministradora) sessionFactory.getCurrentSession().load(GerenteAdministradora.class,
				id);
	}


	public void removeGerenteAdministradora(final Long id) {
		GerenteAdministradora gerenteAdministradora = (GerenteAdministradora) sessionFactory.getCurrentSession().load(
				GerenteAdministradora.class, id);
		if (gerenteAdministradora != null) {
			sessionFactory.getCurrentSession().delete(gerenteAdministradora);
		}
	}


	@SuppressWarnings("unchecked")
	public List<GerenteAdministradora> getLista() {
		List<GerenteAdministradora> gerenteAdministradora = new ArrayList<GerenteAdministradora>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select gerenteAdministradora from GerenteAdministradora gerenteAdministradora");
		gerenteAdministradora = query.list();

		return gerenteAdministradora;
	}

}
