package com.sindico.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sindico.entity.RespostaCotacao;

/**
 * The Class RespostaCotacaoDAO.
 */
@Repository
public class RespostaCotacaoDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public RespostaCotacao criaRespostaCotacao(final RespostaCotacao respostaCotacao) {
		return (RespostaCotacao) sessionFactory.getCurrentSession().save(respostaCotacao);
	}


	public void removeRespostaCotacao(final Long id) {
		RespostaCotacao respostaCotacao = (RespostaCotacao) sessionFactory.getCurrentSession().load(RespostaCotacao.class, id);
		if (respostaCotacao != null) {
			sessionFactory.getCurrentSession().delete(respostaCotacao);
		}
	}
}
