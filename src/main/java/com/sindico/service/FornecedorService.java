/**
 * 
 */
package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Fornecedor;
import com.sindico.entity.Subcategoria;

// TODO: Auto-generated Javadoc
/**
 * The Interface FornecedorService.
 * 
 * @author Lucas
 */
public interface FornecedorService {

	/**
	 * Listar fornecedores.
	 * 
	 * @return the list
	 */
	@Transactional
	List<Fornecedor> listarFornecedores();

	/**
	 * Criar fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @return the fornecedor
	 */
	@Transactional
	Fornecedor criarFornecedor(Fornecedor fornecedor);

	/**
	 * Gets the fornecedor.
	 * 
	 * @param id
	 *            the id
	 * @return the fornecedor
	 */
	@Transactional
	Fornecedor getFornecedor(Long id);

	/**
	 * Atualizar fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @return the fornecedor
	 */
	@Transactional
	Fornecedor atualizarFornecedor(Fornecedor fornecedor);

	/**
	 * Buscar fornecedor por email.
	 * 
	 * @param email
	 *            the email
	 * @return the list
	 */
	@Transactional
	List<Fornecedor> listarFornecedorPorEmail(String email);

	/**
	 * Buscar fornecedor por nome.
	 * 
	 * @param nome
	 *            the nome
	 * @return the list
	 */
	@Transactional
	List<Fornecedor> listarFornecedorPorNome(String nome);

	/**
	 * Listar fornecedor.
	 * 
	 * @param subcategoria
	 *            the subcategoria
	 * @return the list
	 */
	@Transactional
	List<Fornecedor> listarFornecedor(Subcategoria subcategoria);

	/**
	 * Buscar fornecedor por endereco.
	 * 
	 * @param endereco
	 *            the endereco
	 * @return the list
	 */
	@Transactional
	List<Fornecedor> listarFornecedorPorEndereco(String endereco);

	/**
	 * Remover fornecedor.
	 * 
	 * @param id
	 *            the id
	 */
	@Transactional
	void removerFornecedor(Long id);

	/**
	 * Listar fornecedores por cnpj.
	 * 
	 * @param cnpj
	 *            the cnpj
	 * @return the list
	 */
	@Transactional
	List<Fornecedor> listarFornecedoresPorCNPJ(String cnpj);

	/**
	 * Load by username.
	 * 
	 * @param email
	 *            the email
	 * @return the fornecedor
	 */
	@Transactional
	Fornecedor loadByUsername(String email);

	/**
	 * Gets the logged fornecedor.
	 * 
	 * @return the logged fornecedor
	 */
	@Transactional
	Fornecedor getLoggedFornecedor();

}
