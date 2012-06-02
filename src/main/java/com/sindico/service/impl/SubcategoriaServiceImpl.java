package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.SubcategoriaDAO;
import com.sindico.entity.Subcategoria;
import com.sindico.service.SubcategoriaService;

@Service("subcategoriaService")
public class SubcategoriaServiceImpl implements SubcategoriaService{

	@Autowired
	private SubcategoriaDAO dao;
	
	@Override
	public List<Subcategoria> listSubacategorias() {
		return dao.getLista();
	}

	@Override
	public Subcategoria getSubcategoria(long id) {
		return dao.getSubcategoria(id);
	}

	@Override
	public Subcategoria createSubcategoria(Subcategoria subcategoria) {
		return dao.criaSubcategoria(subcategoria);
	}

	@Override
	public Subcategoria updateSubcategoria(Subcategoria subcategoria) {
		return dao.atualizaSubcategoria(subcategoria);
	}

	@Override
	public boolean removeSubcategoria(long id) {
		return dao.removeSubcategoria(id);
	}

}
