package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDAO.
 */
@Repository
public class UsuarioDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;

	/**
	 * Cria usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	@Transactional
	public Usuario criaUsuario(final Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
		return usuario;
	}

	/**
	 * Removes the usuario.
	 * 
	 * @param id
	 *            the id
	 */
	public void removeUsuario(final Long id) {
		Usuario usuario = (Usuario) sessionFactory.getCurrentSession().load(
				Usuario.class, id);
		if (usuario != null) {
			sessionFactory.getCurrentSession().delete(usuario);
		}
	}

	/**
	 * Lista usuarios.
	 * 
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listaUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select usuario from Usuario usuario");
		usuarios = query.list();

		return usuarios;
	}
}
