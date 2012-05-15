package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.RespostaCotacao;

public class RespostaCotacaoDAO {
	public static void salvaRespostaCotacao(RespostaCotacao respostaCotacao){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, respostaCotacao);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaRespostaCotacao(RespostaCotacao respostaCotacao, Session session){
		try{
			HibernateFactory.saveObject(session, respostaCotacao);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaRespostaCotacao(RespostaCotacao respostaCotacao){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, respostaCotacao);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaRespostaCotacao(RespostaCotacao respostaCotacao, Session session){
		try{
			HibernateFactory.deleteObject(session, respostaCotacao);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaRespostaCotacao(RespostaCotacao respostaCotacao){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, respostaCotacao);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaRespostaCotacao(RespostaCotacao respostaCotacao, Session session){
		try{
			HibernateFactory.updateObject(session, respostaCotacao);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
