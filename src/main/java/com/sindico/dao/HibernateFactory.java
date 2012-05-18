package com.sindico.dao;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * A factory for creating Hibernate objects.
 */
public class HibernateFactory {

	/**
	 * Sets the up session factory.
	 * 
	 * @return the session factory
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static SessionFactory setUpSessionFactory() throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	/**
	 * Tear down session factory.
	 * 
	 * @param sessionFactory
	 *            the session factory
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static void tearDownSessionFactory(final SessionFactory sessionFactory) throws HibernateException {
		sessionFactory.close();
	}

	/**
	 * Sets the up session.
	 * 
	 * @param sessionFactory
	 *            the session factory
	 * @return the session
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static Session setUpSession(final SessionFactory sessionFactory) throws HibernateException {
		Session session = sessionFactory.openSession();
		return session;
	}

	/**
	 * Tear down session.
	 * 
	 * @param session
	 *            the session
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static void tearDownSession(final Session session) throws HibernateException {
		session.close();
	}

	/**
	 * Sets the up.
	 * 
	 * @return the session
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static Session setUp() throws HibernateException {
		SessionFactory sessionFactory = setUpSessionFactory();
		Session session = setUpSession(sessionFactory);
		return session;
	}

	/**
	 * Tear down.
	 * 
	 * @param session
	 *            the session
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static void tearDown(final Session session) throws HibernateException {
		SessionFactory sessionFactory = session.getSessionFactory();
		tearDownSession(session);
		tearDownSessionFactory(sessionFactory);
	}

	/**
	 * Save object.
	 * 
	 * @param session
	 *            the session
	 * @param object
	 *            the object
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static void saveObject(final Session session, final Object object) throws HibernateException {
		session.beginTransaction();
		session.save(object);
	}

	/**
	 * Delete object.
	 * 
	 * @param session
	 *            the session
	 * @param object
	 *            the object
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static void deleteObject(final Session session, final Object object) throws HibernateException {
		session.beginTransaction();
		session.delete(object);
	}

	/**
	 * Update object.
	 * 
	 * @param session
	 *            the session
	 * @param object
	 *            the object
	 * @throws HibernateException
	 *             the hibernate exception
	 */
	public static void updateObject(final Session session, final Object object) throws HibernateException {
		session.beginTransaction();
		session.update(object);
	}

}
