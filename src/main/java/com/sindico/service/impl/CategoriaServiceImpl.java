package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sindico.dao.CategoriaDAO;
import com.sindico.entity.Categoria;
import com.sindico.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> listarCategorias() {
		return categoriaDAO.getLista();
	}

	@Override
	public Categoria criarCategoria(Categoria categoria) {
		return categoriaDAO.criaCategoria(categoria);
	}

}
