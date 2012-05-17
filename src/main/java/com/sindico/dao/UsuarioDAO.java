package com.sindico.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sindico.entity.Usuario;

/**
 * The Class UsuarioDAO.
 */
@Repository
public class UsuarioDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Adiciona usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return
	 */
	public Usuario criaUsuario(final Usuario usuario) {
		return (Usuario) sessionFactory.getCurrentSession().save(usuario);
	}

	/**
	 * Removes the usuario.
	 * 
	 * @param id
	 *            the id
	 */
	public void removeUsuario(final Long id) {
		Usuario usuario = (Usuario) sessionFactory.getCurrentSession().load(Usuario.class, id);
		if (usuario != null) {
			sessionFactory.getCurrentSession().delete(usuario);
		}
	}
}
