package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Categoria;

public interface CategoriaService {
	@Transactional
	List<Categoria> listCategorias();
	
	@Transactional
	Categoria getCategoria(int id);
	
	@Transactional
	Categoria createCategoria(Categoria categoria);
	
	@Transactional
	Categoria updateCategoria(Categoria categoria);
	
	@Transactional
	void removeCategoria(int id);
}
