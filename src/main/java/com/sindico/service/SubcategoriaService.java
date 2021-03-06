package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Categoria;
import com.sindico.entity.Subcategoria;

public interface SubcategoriaService {
	
	@Transactional
	List<Subcategoria> listSubcategorias();
	
	List<Subcategoria> listSubcategoriasPorCategoria(Categoria categoria);
	
	@Transactional
	Subcategoria getSubcategoria(long id);
	
	@Transactional
	Subcategoria createSubcategoria(Subcategoria subcategoria);
	
	@Transactional
	Subcategoria updateSubcategoria(Subcategoria subcategoria);
	
	@Transactional
	boolean removeSubcategoria(long id);
}
