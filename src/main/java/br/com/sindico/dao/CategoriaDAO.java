package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.Categoria;

public class CategoriaDAO {
	public static void salvaCategoria(Categoria categoria){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, categoria);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaCategoria(Categoria categoria, Session session){
		try{
			HibernateFactory.saveObject(session, categoria);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaCategoria(Categoria categoria){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, categoria);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaCategoria(Categoria categoria, Session session){
		try{
			HibernateFactory.deleteObject(session, categoria);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaCategoria(Categoria categoria){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, categoria);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaCategoria(Categoria categoria, Session session){
		try{
			HibernateFactory.updateObject(session, categoria);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
