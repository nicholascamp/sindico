package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.sindico.entity.Fornecedor;

public class FornecedorDAO {
	public static void salvaFornecedor(Fornecedor fornecedor){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, fornecedor);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void salvaFornecedor(Fornecedor fornecedor, Session session){
		try{
			HibernateFactory.saveObject(session, fornecedor);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaFornecedor(Fornecedor fornecedor){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, fornecedor);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletaFornecedor(Fornecedor fornecedor, Session session){
		try{
			HibernateFactory.deleteObject(session, fornecedor);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaFornecedor(Fornecedor fornecedor){
		try{
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, fornecedor);
			HibernateFactory.tearDown(session);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void atualizaFornecedor(Fornecedor fornecedor, Session session){
		try{
			HibernateFactory.updateObject(session, fornecedor);
			
		} catch(HibernateException hbe){
			hbe.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
