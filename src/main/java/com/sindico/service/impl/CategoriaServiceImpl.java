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
	private CategoriaDAO	categoriaDAO;

	@Override
	public List<Categoria> listCategorias() {
		return categoriaDAO.getLista();
	}

	@Override
	public Categoria getCategoria(int id) {
		return categoriaDAO.getCategoria(id);
	}

	@Override
	public Categoria createCategoria(Categoria categoria) {
		return categoriaDAO.criaCategoria(categoria);
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		return categoriaDAO.atualizaCategoria(categoria);
	}

	@Override
	public void removeCategoria(int id) {
		categoriaDAO.removeCategoria(id);
	}

	
}
