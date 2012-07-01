/**
 * 
 */
package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.FornecedorDAO;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.Subcategoria;
import com.sindico.service.FornecedorService;

// TODO: Auto-generated Javadoc
/**
 * The Class FornecedorServiceImpl.
 * 
 * @author Lucas
 */
@Service("fornecedorService")
public class FornecedorServiceImpl implements FornecedorService {

	/** The fornecedor dao. */
	@Autowired
	FornecedorDAO	fornecedorDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.FornecedorService#listarFornecedores()
	 */
	@Override
	public List<Fornecedor> listarFornecedores() {

		return fornecedorDAO.getLista();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.FornecedorService#criarFornecedor(com.sindico.entity
	 * .Fornecedor)
	 */
	@Override
	public Fornecedor criarFornecedor(final Fornecedor fornecedor) {
		return fornecedorDAO.criaFornecedor(fornecedor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.FornecedorService#atualizarFornecedor(com.sindico
	 * .entity.Fornecedor)
	 */
	@Override
	public Fornecedor atualizarFornecedor(final Fornecedor fornecedor) {
		return fornecedorDAO.atualizaFornecedor(fornecedor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.FornecedorService#buscarFornecedorPorEmail(java.lang
	 * .String)
	 */
	@Override
	public List<Fornecedor> listarFornecedorPorEmail(final String email) {
		return fornecedorDAO.listarFornecedorPorEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.FornecedorService#buscarFornecedorPorNome(java.lang
	 * .String)
	 */
	@Override
	public List<Fornecedor> listarFornecedorPorNome(final String nome) {
		return fornecedorDAO.listarFornecedorPorNome(nome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.FornecedorService#buscarFornecedorPorEndereco(java
	 * .lang.String)
	 */
	@Override
	public List<Fornecedor> listarFornecedorPorEndereco(final String endereco) {
		return fornecedorDAO.listarFornecedorPorEndereco(endereco);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.FornecedorService#removerFornecedor(java.lang.Long)
	 */
	@Override
	public void removerFornecedor(final Long id) {
		fornecedorDAO.removeFornecedor(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.FornecedorService#getFornecedor(java.lang.Long)
	 */
	@Override
	public Fornecedor getFornecedor(final Long id) {
		return fornecedorDAO.getFornecedor(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.FornecedorService#listarFornecedoresPorCNPJ(java.
	 * lang.String)
	 */
	@Override
	public List<Fornecedor> listarFornecedoresPorCNPJ(final String cnpj) {
		return fornecedorDAO.listarFornecedorPorCNPJ(cnpj);
	}

	@Override
	public List<Fornecedor> listarFornecedorPorSubcategoria(
			Subcategoria subcategoria) {
		return fornecedorDAO.listarFornecedorPorSubcategoria(subcategoria);
	}

}
