package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sindico.entity.Predio;
import com.sindico.entity.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class PredioDAO.
 */
@Repository
public class PredioDAO {
	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;

	/**
	 * Cria predio.
	 * 
	 * @param predio
	 *            the predio
	 * @return the predio
	 */
	public Predio criaPredio(final Predio predio) {
		sessionFactory.getCurrentSession().save(predio);
		return predio;
	}

	/**
	 * Atualiza predio.
	 * 
	 * @param predio
	 *            the predio
	 * @return the predio
	 */
	public Predio atualizaPredio(final Predio predio) {
		sessionFactory.getCurrentSession().update(predio);
		return predio;
	}

	/**
	 * Gets the predio.
	 * 
	 * @param id
	 *            the id
	 * @return the predio
	 */
	public Predio getPredio(final Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select predio from Predio predio WHERE predio.id = " + id);
		return (Predio) query.uniqueResult();
	}

	/**
	 * Removes the predio.
	 * 
	 * @param id
	 *            the id
	 */
	public void removePredio(final Long id) {
		Predio predio = (Predio) sessionFactory.getCurrentSession().load(
				Predio.class, id);
		if (predio != null) {
			sessionFactory.getCurrentSession().delete(predio);
		}
	}

	/**
	 * Listar predios.
	 * 
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Predio> listarPredios() {
		List<Predio> predio = new ArrayList<Predio>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select predio from Predio predio");
		predio = query.list();

		return predio;
	}

	/**
	 * Gets the predio.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the predio
	 */
	public Predio getPredio(final Usuario usuario) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select usuario.predio from Usuario usuario WHERE usuario.id = "
						+ usuario.getId());
		return (Predio) query.uniqueResult();
	}

	/**
	 * Gets the predio por cep numero.
	 * 
	 * @param cep
	 *            the cep
	 * @param numero
	 *            the numero
	 * @return the predio por cep numero
	 */
	public Predio getPredioPorCEPNumero(final String cep, final int numero) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select predio from Predio predio WHERE predio.cep = '" + cep
						+ "' AND predio.numero = " + numero);
		return (Predio) query.uniqueResult();
	}

	/**
	 * Buscar predio por nome.
	 * 
	 * @param nome
	 *            the nome
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Predio> buscarPredioPorNome(final String nome) {
		List<Predio> predios = new ArrayList<Predio>();

		Query query = sessionFactory.getCurrentSession().createQuery(
				"SELECT predio FROM Predio predio WHERE predio.nome like '%"
						+ nome + "%'");
		predios = query.list();

		return predios;
	}

	/**
	 * Buscar predio por endereco.
	 * 
	 * @param endereco
	 *            the endereco
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Predio> buscarPredioPorEndereco(final String endereco) {
		List<Predio> predios = new ArrayList<Predio>();

		Query query = sessionFactory.getCurrentSession().createQuery(
				"SELECT predio FROM Predio predio WHERE predio.endereco like '%"
						+ endereco + "%'");
		predios = query.list();

		return predios;
	}

	/**
	 * Buscar predio por cnpj.
	 * 
	 * @param cnpj
	 *            the cnpj
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Predio> buscarPredioPorCNPJ(final String cnpj) {
		List<Predio> predios = new ArrayList<Predio>();

		Query query = sessionFactory.getCurrentSession().createQuery(
				"SELECT predio FROM Predio predio WHERE predio.cnpj like '%"
						+ cnpj + "%'");
		predios = query.list();

		return predios;
	}

}
