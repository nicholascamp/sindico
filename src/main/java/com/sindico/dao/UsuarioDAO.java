package com.sindico.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Usuario;

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
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select usuario from Usuario usuario where usuario.id = " + id);

		return (Usuario) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public Collection<Usuario> getUsuarioNome(final String nome) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"SELECT usuario FROM Usuario usuario WHERE usuario.nome like '%"
						+ nome + "%'");
		usuarios = query.list();

		return usuarios;
	}

	@SuppressWarnings("unchecked")
	public Collection<Usuario> getUsuarioEmail(final String email) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"SELECT usuario FROM Usuario usuario WHERE usuario.email like '%"
						+ email + "%'");
		usuarios = query.list();

		return usuarios;
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

	/**
	 * @param username
	 * @return
	 */
	public Usuario loadByUsername(final String email) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"SELECT usuario FROM Usuario usuario WHERE usuario.email = :email")
				.setParameter("email", email);
		return (Usuario) query.uniqueResult();
	}

	/**
	 * @param id
	 * @return
	 */
	public Usuario setAdmin(final Long id, final boolean admin) {
		Usuario usuario = (Usuario) this.sessionFactory.getCurrentSession()
				.load(Usuario.class, id);
		usuario.setAdmin(admin);
		return usuario;
	}

}
