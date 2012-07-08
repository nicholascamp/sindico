package com.sindico.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.RespostaCotacao;

/**
 * The Class RespostaCotacaoDAO.
 */
@Repository
public class RespostaCotacaoDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory	sessionFactory;


	@Transactional
	public RespostaCotacao criaRespostaCotacao(final RespostaCotacao respostaCotacao) {
		sessionFactory.getCurrentSession().save(respostaCotacao);
		return respostaCotacao;
	}


	public RespostaCotacao atualizaRespostaCotacao(final RespostaCotacao respostaCotacao) {
		sessionFactory.getCurrentSession().update(respostaCotacao);
		return respostaCotacao;
	}


	public RespostaCotacao getRespostaCotacao(final Long id) {
		return (RespostaCotacao) sessionFactory.getCurrentSession().load(RespostaCotacao.class,
				id);
	}


	public void removeRespostaCotacao(final Long id) {
		RespostaCotacao respostaCotacao = (RespostaCotacao) sessionFactory.getCurrentSession().load(
				RespostaCotacao.class, id);
		if (respostaCotacao != null) {
			sessionFactory.getCurrentSession().delete(respostaCotacao);
		}
	}


	@SuppressWarnings("unchecked")
	public List<RespostaCotacao> getLista() {
		List<RespostaCotacao> respostaCotacao = new ArrayList<RespostaCotacao>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select respostaCotacao from RespostaCotacao respostaCotacao");
		respostaCotacao = query.list();

		return respostaCotacao;
	}
	
	public List<RespostaCotacao> getLista(Long cotacaoId){
		List<RespostaCotacao> respostaCotacao = new ArrayList<RespostaCotacao>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select respostaCotacao from RespostaCotacao respostaCotacao where respostaCotacao.cotacao = " 
				+ cotacaoId);
		respostaCotacao = query.list();

		return respostaCotacao;
	}
	
	public List<RespostaCotacao> getLista(Long cotacaoId, Long fornecedorId){
		List<RespostaCotacao> respostaCotacao = new ArrayList<RespostaCotacao>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select respostaCotacao from RespostaCotacao respostaCotacao where respostaCotacao.cotacao = " 
				+ cotacaoId + " and respostaCotacao.fornecedor = " + fornecedorId);
		respostaCotacao = query.list();
		return respostaCotacao;		
	}
}
