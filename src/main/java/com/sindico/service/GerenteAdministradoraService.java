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
	List<GerenteAdministradora> listaGerentes();

}
