package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.Cotacao;

public class CotacaoDAO {
	public static void salvaCotacao(Cotacao cotacao){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, cotacao);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaCotacao(Cotacao cotacao, Session session){
		try{
			HibernateFactory.saveObject(session, cotacao);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaCotacao(Cotacao cotacao){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, cotacao);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaCotacao(Cotacao cotacao, Session session){
		try{
			HibernateFactory.deleteObject(session, cotacao);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaCotacao(Cotacao cotacao){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, cotacao);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaCotacao(Cotacao cotacao, Session session){
		try{
			HibernateFactory.updateObject(session, cotacao);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
