package com.productdetails;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductSessionFactory {

	private static SessionFactory sessionFactory;


	public static SessionFactory getSessionFactory(){

		if(sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (Throwable ex) { 
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex); 
			}
		}
		return sessionFactory;

	}
}
