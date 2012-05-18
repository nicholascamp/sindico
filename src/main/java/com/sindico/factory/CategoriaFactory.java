package com.sindico.factory;

import java.util.Collection;

import com.sindico.entity.Categoria;
import com.sindico.entity.Subcategoria;

public class CategoriaFactory {
	
	public static Categoria criaCategoria(String nome, Collection<Subcategoria> subcategorias){
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoria.setSubcategorias(subcategorias);
		return categoria;
	}

}


