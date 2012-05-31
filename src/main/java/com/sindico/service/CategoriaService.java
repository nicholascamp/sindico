package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Categoria;

public interface CategoriaService {
	@Transactional
	List<Categoria> listarCategorias();
	
	@Transactional
	Categoria criarCategoria(Categoria categoria);
}
