package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.Predio;

public class PredioDAO {
	public static void salvaPredio(Predio predio){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, predio);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaPredio(Predio predio, Session session){
		try{
			HibernateFactory.saveObject(session, predio);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaPredio(Predio predio){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, predio);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaPredio(Predio predio, Session session){
		try{
			HibernateFactory.deleteObject(session, predio);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaPredio(Predio predio){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, predio);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaPredio(Predio predio, Session session){
		try{
			HibernateFactory.updateObject(session, predio);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
