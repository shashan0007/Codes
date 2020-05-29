package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory()
	{
		try
		{
			Configuration con = new Configuration();
			con.configure("hibernate-configuration.xml");
			
			ServiceRegistry srv = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
			sessionFactory = con.buildSessionFactory(srv);
			return sessionFactory;
		}
		catch(Throwable ex)
		{
			System.out.println("Exception raised in creating session : " + ex);
			throw new ExceptionInInitializerError(ex);
		}	
	}
	
	public static SessionFactory buildSessionFactory() {
		if(sessionFactory==null) {
			sessionFactory = getSessionFactory();
		}
		return sessionFactory;
	}

}
