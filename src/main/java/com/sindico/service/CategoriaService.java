package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Categoria;

/**
 * The Interface CategoriaService.
 */
public interface CategoriaService {

	/**
	 * List categorias.
	 * 
	 * @return the list
	 */
	@Transactional
	List<Categoria> listCategorias();

	/**
	 * Gets the categoria.
	 * 
	 * @param id
	 *            the id
	 * @return the categoria
	 */
	@Transactional
	Categoria getCategoria(Long id);

	/**
	 * Creates the categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the categoria
	 */
	@Transactional
	Categoria createCategoria(Categoria categoria);

	/**
	 * Update categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the categoria
	 */
	@Transactional
	Categoria updateCategoria(Categoria categoria);

	/**
	 * Removes the categoria.
	 * 
	 * @param id
	 *            the id
	 */
	@Transactional
	void removeCategoria(Long id);
}