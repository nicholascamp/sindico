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
	public List<Categoria> listCategorias() {
		return categoriaDAO.getLista();
	}

	@Override
	public Categoria getCategoria(final Long id) {
		return categoriaDAO.getCategoria(id);
	}

	@Override
	public Categoria createCategoria(final Categoria categoria) {
		return categoriaDAO.criaCategoria(categoria);
	}

	@Override
	public Categoria updateCategoria(final Categoria categoria) {
		return categoriaDAO.atualizaCategoria(categoria);
	}

	@Override
	public void removeCategoria(final Long id) {
		categoriaDAO.removeCategoria(id);
	}

}
