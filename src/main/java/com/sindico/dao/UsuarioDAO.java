package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.Usuario;

public class UsuarioDAO {
	public static void salvaUsuario(Usuario usuario){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, usuario);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaUsuario(Usuario usuario, Session session){
		try{
			HibernateFactory.saveObject(session, usuario);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaUsuario(Usuario usuario){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, usuario);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaUsuario(Usuario usuario, Session session){
		try{
			HibernateFactory.deleteObject(session, usuario);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaUsuario(Usuario usuario){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, usuario);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaUsuario(Usuario usuario, Session session){
		try{
			HibernateFactory.updateObject(session, usuario);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
