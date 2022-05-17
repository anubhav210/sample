package com.div.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static final Session getSession() {
		SessionFactory sessionFactory = new Configuration().configure("conf.xml").buildSessionFactory();
		return sessionFactory.openSession();
	}
}