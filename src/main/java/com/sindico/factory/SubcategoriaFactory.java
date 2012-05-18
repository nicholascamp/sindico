package com.sindico.factory;

import java.util.Collection;

import com.sindico.entity.Categoria;
import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.Subcategoria;

public class SubcategoriaFactory {
	
	public static Subcategoria criSubcategoria(String title, Categoria categoria, Collection<Fornecedor> fornecedores, 
			Collection<Cotacao> cotacoes){
		Subcategoria subcategoria = new Subcategoria();
		subcategoria.setCategoria(categoria);
		subcategoria.setTitle(title);
		subcategoria.setFornecedores(fornecedores);
		subcategoria.setCotacoes(cotacoes);
		return subcategoria;
	}

}
