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
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select resposta from RespostaCotacao resposta where resposta.id = " + id);

		return (RespostaCotacao) query.uniqueResult();
	}
	
	public RespostaCotacao getRespostaCotacao(Long cotacaoId, Long fornecedorId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select respostaCotacao from RespostaCotacao respostaCotacao where respostaCotacao.cotacao.id = " 
				+ cotacaoId + " and respostaCotacao.fornecedor.id = " + fornecedorId + " order by respostaCotacao.data desc");

		List<RespostaCotacao> respostaCotacao = query.list();	
		if(respostaCotacao.size() == 0)
			return null;
		
		return respostaCotacao.get(0);
	}
	
	public RespostaCotacao getRespostaCotacaoAberta(Long cotacaoId, Long fornecedorId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select respostaCotacao from RespostaCotacao respostaCotacao where respostaCotacao.cotacao.id = " 
				+ cotacaoId + " and respostaCotacao.fornecedor.id = " + fornecedorId + " and respostaCotacao.cotacao.status != 2 order by respostaCotacao.data desc");

		List<RespostaCotacao> respostaCotacao = query.list();	
		if(respostaCotacao.size() == 0)
			return null;
		
		return respostaCotacao.get(0);
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
				"select respostaCotacao from RespostaCotacao respostaCotacao order by respostaCotacao.data desc");
		respostaCotacao = query.list();

		return respostaCotacao;
	}
	
	public List<RespostaCotacao> getLista(Long cotacaoId){
		List<RespostaCotacao> respostaCotacao = new ArrayList<RespostaCotacao>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select respostaCotacao from RespostaCotacao respostaCotacao where respostaCotacao.cotacao.id = " 
				+ cotacaoId + " order by respostaCotacao.data desc");
		respostaCotacao = query.list();		
		
		return respostaCotacao;
	}
	
	public List<RespostaCotacao> getLista(Long cotacaoId, Long fornecedorId){
		List<RespostaCotacao> respostaCotacao = new ArrayList<RespostaCotacao>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select respostaCotacao from RespostaCotacao respostaCotacao where respostaCotacao.cotacao.id = " 
				+ cotacaoId + " and respostaCotacao.fornecedor.id = " + fornecedorId + " order by respostaCotacao.data");
		respostaCotacao = query.list();
		
		return respostaCotacao;		
	}	
	
}
