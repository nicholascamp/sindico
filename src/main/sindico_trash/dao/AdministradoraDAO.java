package com.sindico.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sindico.entity.Administradora;

public class AdministradoraDAO {
	public static void salvaAdministradora(final Administradora administradora) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.saveObject(session, administradora);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void salvaAdministradora(final Administradora administradora, final Session session) {
		try {
			HibernateFactory.saveObject(session, administradora);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deletaAdministradora(final Administradora administradora) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.deleteObject(session, administradora);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deletaAdministradora(final Administradora administradora, final Session session) {
		try {
			HibernateFactory.deleteObject(session, administradora);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void atualizaAdministradora(final Administradora administradora) {
		try {
			Session session = HibernateFactory.setUp();
			HibernateFactory.updateObject(session, administradora);
			HibernateFactory.tearDown(session);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void atualizaAdministradora(final Administradora administradora, final Session session) {
		try {
			HibernateFactory.updateObject(session, administradora);

		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
