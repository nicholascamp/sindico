/**
 * 
 */
package com.sindico.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;
import com.sindico.entity.UsuarioSimples;
import com.sindico.service.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioServiceImpl.
 * 
 * @author Lucas
 */
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	/** The usuario dao. */
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
	public UsuarioSimples getUsuario(final Long id) {
		return new UsuarioSimples(usuarioDAO.getUsuario(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#getUsuarioNome(java.lang.String)
	 */
	@Override
	public List<UsuarioSimples> getUsuarioNome(final String nome) {

		List<UsuarioSimples> usuarios = new ArrayList<UsuarioSimples>();
		for (Usuario usuario : usuarioDAO.getUsuarioNome(nome)) {
			usuarios.add(new UsuarioSimples(usuario));
		}
		return usuarios;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#getUsuarioEmail(java.lang.String)
	 */
	@Override
	public List<UsuarioSimples> getUsuarioEmail(final String email) {
		List<UsuarioSimples> usuarios = new ArrayList<UsuarioSimples>();
		for (Usuario usuario : usuarioDAO.getUsuarioEmail(email)) {
			usuarios.add(new UsuarioSimples(usuario));
		}
		return usuarios;
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
	public List<UsuarioSimples> getLista() {
		List<UsuarioSimples> usuarios = new ArrayList<UsuarioSimples>();
		for (Usuario usuario : usuarioDAO.getLista()) {
			usuarios.add(new UsuarioSimples(usuario));
		}
		return usuarios;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#setAdmin(java.lang.Long)
	 */
	@Override
	public Usuario setAdmin(final Long id, final boolean admin) {
		return usuarioDAO.setAdmin(id, admin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.UsuarioService#getLoggedUser()
	 */
	@Override
	public Usuario getLoggedUser() {

		Usuario usuario = (Usuario) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		return usuario;
	}

	@Override
	public Usuario buscaUsuario(Long id) {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuario(id);
	}

}
