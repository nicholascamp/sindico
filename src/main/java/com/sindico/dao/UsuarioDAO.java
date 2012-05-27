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
	 * Atualiza usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	public Usuario atualizaUsuario(final Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
		return usuario;
	}

	/**
	 * Recupera usuario.
	 * 
	 * @param id
	 *            the id
	 * @return the usuario
	 */
	public Usuario getUsuario(final Long id) {
		return (Usuario) sessionFactory.getCurrentSession().load(Usuario.class,
				id);
	}

	public Usuario getUsuarioNome(final String nome) {
		return new Usuario();
	}

	public Usuario getUsuarioEmail(final String email) {
		return new Usuario();
	}

	public Usuario getUsuarioPredio(final String predio) {
		return new Usuario();
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
	public List<Usuario> getLista() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select usuario from Usuario usuario");
		usuarios = query.list();

		return usuarios;
	}
}
