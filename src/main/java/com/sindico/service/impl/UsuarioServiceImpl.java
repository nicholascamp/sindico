/**
 * 
 */
package com.sindico.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;
import com.sindico.service.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioServiceImpl.
 * 
 * @author Lucas
 */
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO	usuarioDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.UsuarioService#criaUsuario(com.sindico.entity.Usuario
	 * )
	 */
	@Override
	public Usuario criaUsuario(final Usuario usuario) {
		return usuarioDAO.criaUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.UsuarioService#atualizaUsuario(com.sindico.entity
	 * .Usuario)
	 */
	@Override
	public Usuario atualizaUsuario(final Usuario usuario) {
		return usuarioDAO.atualizaUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#getUsuario(java.lang.Long)
	 */
	@Override
	public Usuario getUsuario(final Long id) {
		return usuarioDAO.getUsuario(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#getUsuarioNome(java.lang.String)
	 */
	@Override
	public Collection<Usuario> getUsuarioNome(final String nome) {
		return usuarioDAO.getUsuarioNome(nome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#getUsuarioEmail(java.lang.String)
	 */
	@Override
	public Collection<Usuario> getUsuarioEmail(final String email) {
		return usuarioDAO.getUsuarioEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.UsuarioService#getUsuarioPredio(java.lang.String)
	 */
	@Override
	public Collection<Usuario> getUsuarioPredio(final String predio) {
		return usuarioDAO.getUsuarioPredio(predio);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#removeUsuario(java.lang.Long)
	 */
	@Override
	public void removeUsuario(final Long id) {
		usuarioDAO.removeUsuario(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#getLista()
	 */
	@Override
	public List<Usuario> getLista() {
		return usuarioDAO.getLista();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#loadByUsername(java.lang.String)
	 */
	@Override
	public Usuario loadByUsername(final String username) {
		return usuarioDAO.loadByUsername(username);
	}

}
