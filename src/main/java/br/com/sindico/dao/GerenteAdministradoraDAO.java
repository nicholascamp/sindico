package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.GerenteAdministradora;

public class GerenteAdministradoraDAO {
	public static void salvaGerenteAdministradora(GerenteAdministradora gerenteAdministradora){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, gerenteAdministradora);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaGerenteAdministradora(GerenteAdministradora gerenteAdministradora, Session session){
		try{
			HibernateFactory.saveObject(session, gerenteAdministradora);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaGerenteAdministradora(GerenteAdministradora gerenteAdministradora){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, gerenteAdministradora);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaGerenteAdministradora(GerenteAdministradora gerenteAdministradora, Session session){
		try{
			HibernateFactory.deleteObject(session, gerenteAdministradora);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaGerenteAdministradora(GerenteAdministradora gerenteAdministradora){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, gerenteAdministradora);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaGerenteAdministradora(GerenteAdministradora gerenteAdministradora, Session session){
		try{
			HibernateFactory.updateObject(session, gerenteAdministradora);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
