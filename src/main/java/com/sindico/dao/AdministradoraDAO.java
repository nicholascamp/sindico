package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.Administradora;

public class AdministradoraDAO {
	public static void salvaAdministradora(Administradora administradora){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, administradora);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaAdministradora(Administradora administradora, Session session){
		try{
			HibernateFactory.saveObject(session, administradora);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaAdministradora(Administradora administradora){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, administradora);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaAdministradora(Administradora administradora, Session session){
		try{
			HibernateFactory.deleteObject(session, administradora);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaAdministradora(Administradora administradora){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, administradora);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaAdministradora(Administradora administradora, Session session){
		try{
			HibernateFactory.updateObject(session, administradora);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
