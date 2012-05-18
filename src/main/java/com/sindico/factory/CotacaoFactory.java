package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Administradora;
import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.entity.Subcategoria;
import com.sindico.entity.Usuario;

public class CotacaoFactory {
	
	public static Cotacao criaCotacao(Date data, Subcategoria subcategoria, char status, boolean aprovada, Collection<Usuario> usuarios,
			Administradora administradora, GerenteAdministradora gerente, Collection<Fornecedor> fornecedores, Fornecedor fornecedorVencedor){
		Cotacao cotacao = new Cotacao();
		cotacao.setData(data);
		cotacao.setSubcategoria(subcategoria);
		cotacao.setStatus(status);
		cotacao.setAprovada(aprovada);
		cotacao.setUsuarios(usuarios);
		cotacao.setAdministradora(administradora);
		cotacao.setGerenteAdmin(gerente);
		cotacao.setFornecedores(fornecedores);
		cotacao.setFornecedorVencedor(fornecedorVencedor);
		return cotacao;
	}

}

