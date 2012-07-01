package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Fornecedor;
import com.sindico.entity.Subcategoria;

// TODO: Auto-generated Javadoc
/**
 * The Class FornecedorDAO.
 */
@Repository
public class FornecedorDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;

	/**
	 * Cria fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @return the fornecedor
	 */
	@Transactional
	public Fornecedor criaFornecedor(final Fornecedor fornecedor) {
		sessionFactory.getCurrentSession().save(fornecedor);
		return fornecedor;
	}

	/**
	 * Atualiza fornecedor.
	 * 
	 * @param fornecedor
	 *            the fornecedor
	 * @return the fornecedor
	 */
	public Fornecedor atualizaFornecedor(final Fornecedor fornecedor) {
		sessionFactory.getCurrentSession().update(fornecedor);
		return fornecedor;
	}

	/**
	 * Gets the fornecedor.
	 * 
	 * @param id
	 *            the id
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor(final Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select fornecedor from Fornecedor fornecedor where fornecedor.id = "
						+ id);

		return (Fornecedor) query.uniqueResult();
	}

	/**
	 * Removes the fornecedor.
	 * 
	 * @param id
	 *            the id
	 */
	public void removeFornecedor(final Long id) {
		Fornecedor fornecedor = (Fornecedor) sessionFactory.getCurrentSession()
				.load(Fornecedor.class, id);
		if (fornecedor != null) {
			sessionFactory.getCurrentSession().delete(fornecedor);
		}
	}

	/**
	 * Gets the lista.
	 * 
	 * @return the lista
	 */
	@SuppressWarnings("unchecked")
	public List<Fornecedor> getLista() {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select fornecedor from Fornecedor fornecedor");
		fornecedores = query.list();

		return fornecedores;
	}

	/**
	 * Buscar fornecedor por email.
	 * 
	 * @param email
	 *            the email
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarFornecedorPorEmail(final String email) {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select fornecedor from Fornecedor fornecedor WHERE fornecedor.email like '%"
						+ email + "%'");
		fornecedores = query.list();

		return fornecedores;
	}

	/**
	 * Buscar fornecedor por nome.
	 * 
	 * @param nome
	 *            the nome
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarFornecedorPorNome(final String nome) {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select fornecedor from Fornecedor fornecedor WHERE fornecedor.nome like '%"
						+ nome + "%'");
		fornecedores = query.list();

		return fornecedores;
	}

	/**
	 * Buscar fornecedor por endereco.
	 * 
	 * @param endereco
	 *            the endereco
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarFornecedorPorEndereco(final String endereco) {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select fornecedor from Fornecedor fornecedor WHERE fornecedor.endereco like '%"
								+ endereco + "%'");
		fornecedores = query.list();

		return fornecedores;
	}

	/**
	 * Listar fornecedor por cnpj.
	 * 
	 * @param cnpj
	 *            the cnpj
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarFornecedorPorCNPJ(final String cnpj) {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select fornecedor from Fornecedor fornecedor WHERE fornecedor.cnpj like '%"
						+ cnpj + "%'");
		fornecedores = query.list();

		return fornecedores;
	}

	public List<Fornecedor> listarFornecedorPorSubcategoria(
			Subcategoria subcategoria) {
		List<Fornecedor> fornecedoresAux = getLista();
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		for(Fornecedor fornecedor : fornecedoresAux){
			for(Subcategoria subcategoriaAux : fornecedor.getSubcategorias()){
				if(subcategoriaAux.getId().equals(subcategoria.getId())){
					fornecedores.add(fornecedor);
					break;
				}					
			}
		}
		return fornecedores;
	}

}
