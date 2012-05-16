package br.com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateFactory{
	
	public static SessionFactory setUpSessionFactory() throws HibernateException{
		Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
	public static void tearDownSessionFactory(SessionFactory sessionFactory) throws HibernateException{
		sessionFactory.close();
	}
	
	public static Session setUpSession(SessionFactory sessionFactory) throws HibernateException{
		Session session = sessionFactory.openSession();
		return session;
	}
	
	
	public static void tearDownSession(Session session) throws HibernateException{
		session.close();
	}
	
	public static Session setUp() throws HibernateException{
		SessionFactory sessionFactory = setUpSessionFactory();
		Session session = setUpSession(sessionFactory);
		return session;
	}
	
	public static void tearDown(Session session) throws HibernateException{
		SessionFactory sessionFactory = session.getSessionFactory();
		tearDownSession(session);
		tearDownSessionFactory(sessionFactory);
	}
	
	public static void saveObject(Session session, Object object) throws HibernateException{
		session.beginTransaction();
		session.save(object);
	}
	
	public static void deleteObject(Session session, Object object) throws HibernateException{
		session.beginTransaction();
		session.delete(object);
	}
	
	public static void updateObject(Session session, Object object) throws HibernateException{
		session.beginTransaction();
		session.update(object);
	}

}
