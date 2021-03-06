/**
 * 
 */
package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.GerenteAdministradora;

/**
 * The Interface GerenteAdministradoraService.
 * 
 * @author Lucas
 */
public interface GerenteAdministradoraService {

	/**
	 * Lista gerentes.
	 * 
	 * @return the list
	 */
	@Transactional
	List<GerenteAdministradora> listGerentes();

	@Transactional
	GerenteAdministradora getGerente(Long id);

	@Transactional
	GerenteAdministradora createGerente(GerenteAdministradora gerente);

	@Transactional
	GerenteAdministradora updateGerente(GerenteAdministradora gerente);

	@Transactional
	boolean removeGerente(Long id);

	/**
	 * @param email
	 * @return
	 */
	@Transactional
	GerenteAdministradora getByEmail(String email);
}
