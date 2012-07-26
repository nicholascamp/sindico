/**
 * 
 */
package com.sindico.service;

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
	public Usuario buscaUsuario(Long id);

	/**
	 * Sets the admin.
	 * 
	 * @param id
	 *            the id
	 * @param admin
	 *            the admin
	 * @return the usuario
	 */
	@Transactional
	public Usuario setAdmin(Long id, boolean admin);

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
	public List<UsuarioSimples> getUsuarioNome(final String nome);

	/**
	 * Gets the usuario email.
	 * 
	 * @param email
	 *            the email
	 * @return the usuario email
	 */
	@Transactional
	public List<UsuarioSimples> getUsuarioEmail(final String email);

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

	/**
	 * Gets the logged user.
	 * 
	 * @return the logged user
	 */
	@Transactional
	public Usuario getLoggedUser();

	/**
	 * @return
	 */
	@Transactional
	public boolean ehUsuarioLogado();

	/**
	 * @param email
	 * @param cotacaoId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Usuario adicionarPorEmail(String email, Long cotacaoId)
			throws Exception;

}
