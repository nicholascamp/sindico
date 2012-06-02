package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Categoria;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoriaService.
 */
public interface CategoriaService {

	/**
	 * Listar categorias.
	 * 
	 * @return the list
	 */
	@Transactional
	List<Categoria> listarCategorias();

	/**
	 * Criar categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the categoria
	 */
	@Transactional
	Categoria criarCategoria(Categoria categoria);
}
