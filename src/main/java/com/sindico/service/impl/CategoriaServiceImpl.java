package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.CategoriaDAO;
import com.sindico.entity.Categoria;
import com.sindico.service.CategoriaService;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaDAO	categoriaDAO;

	@Override
	public List<Categoria> listarCategorias() {
		return categoriaDAO.getLista();
	}

	@Override
	public Categoria criarCategoria(final Categoria categoria) {
		return categoriaDAO.criaCategoria(categoria);
	}

}
