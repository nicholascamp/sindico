/**
 * 
 */
package com.sindico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sindico.entity.Usuario;
import com.sindico.service.UsuarioService;

/**
 * @author Lucas
 * 
 */
public class SindicoUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioService	usuarioService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		Usuario usuario = usuarioService.loadByUsername(username);

		return usuario;
	}

	/**
	 * @param usuario
	 */
	public Usuario criarUsuario(final Usuario usuario) {

		return usuarioService.criaUsuario(usuario);

	}

}
