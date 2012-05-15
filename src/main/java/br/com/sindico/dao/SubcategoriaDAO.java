package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.Subcategoria;

public class SubcategoriaDAO {
	public static void salvaSubcategoria(Subcategoria subcategoria){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, subcategoria);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaSubcategoria(Subcategoria subcategoria, Session session){
		try{
			HibernateFactory.saveObject(session, subcategoria);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaSubcategoria(Subcategoria subcategoria){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, subcategoria);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaSubcategoria(Subcategoria subcategoria, Session session){
		try{
			HibernateFactory.deleteObject(session, subcategoria);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaSubcategoria(Subcategoria subcategoria){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, subcategoria);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaSubcategoria(Subcategoria subcategoria, Session session){
		try{
			HibernateFactory.updateObject(session, subcategoria);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
