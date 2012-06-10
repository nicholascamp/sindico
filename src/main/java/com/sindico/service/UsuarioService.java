/**
 * 
 */
package com.sindico.service;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Usuario;
import com.sindico.entity.UsuarioSimples;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioService.
 * 
 * @author Lucas
 */
public interface UsuarioService {

	/**
	 * Cria usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	@Transactional
	public Usuario criaUsuario(final Usuario usuario);

	/**
	 * Atualiza usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	@Transactional
	public Usuario atualizaUsuario(final Usuario usuario);

	@Transactional
	public Usuario setAdmin(Long id);

	/**
	 * Recupera usuario.
	 * 
	 * @param id
	 *            the id
	 * @return the usuario
	 */
	@Transactional
	public UsuarioSimples getUsuario(final Long id);

	/**
	 * Gets the usuario nome.
	 * 
	 * @param nome
	 *            the nome
	 * @return the usuario nome
	 */
	@Transactional
	public Collection<UsuarioSimples> getUsuarioNome(final String nome);

	/**
	 * Gets the usuario email.
	 * 
	 * @param email
	 *            the email
	 * @return the usuario email
	 */
	@Transactional
	public Collection<UsuarioSimples> getUsuarioEmail(final String email);

	/**
	 * Removes the usuario.
	 * 
	 * @param id
	 *            the id
	 */
	@Transactional
	public void removeUsuario(final Long id);

	/**
	 * Lista usuarios.
	 * 
	 * @return the list
	 */
	@Transactional
	public List<UsuarioSimples> getLista();

	/**
	 * Load by username.
	 * 
	 * @param username
	 *            the username
	 * @return the usuario
	 */
	@Transactional
	public Usuario loadByUsername(final String username);
}
