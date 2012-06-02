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
<<<<<<< HEAD
	List<Categoria> listarCategorias();

	/**
	 * Criar categoria.
	 * 
	 * @param categoria
	 *            the categoria
	 * @return the categoria
	 */
=======
	List<Categoria> listCategorias();
	
>>>>>>> 759c5de8bc31dfb78848458290ea8804758b08c8
	@Transactional
	Categoria getCategoria(int id);
	
	@Transactional
	Categoria createCategoria(Categoria categoria);
	
	@Transactional
	Categoria updateCategoria(Categoria categoria);
	
	@Transactional
	void removeCategoria(int id);
}
