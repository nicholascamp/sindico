/**
 * 
 */
package com.sindico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sindico.entity.Fornecedor;
import com.sindico.entity.Usuario;
import com.sindico.service.FornecedorService;
import com.sindico.service.GerenteAdministradoraService;
import com.sindico.service.UsuarioService;

/**
 * @author Lucas
 * 
 */
public class SindicoUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService					usuarioService;

	@Autowired
	private FornecedorService				fornecedorService;

	@Autowired
	private GerenteAdministradoraService	gerenteAdministradoraService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String email)
			throws UsernameNotFoundException {

		Usuario usuario = usuarioService.loadByUsername(email);

		if (usuario == null) {
			Fornecedor fornecedor = fornecedorService.loadByUsername(email);
			if (fornecedor == null) {
				return gerenteAdministradoraService.getByEmail(email);
			}
		}

		return usuario;
	}

	/**
	 * @param usuario
	 */
	public Usuario criarUsuario(final Usuario usuario) {

		return usuarioService.criaUsuario(usuario);

	}

}
