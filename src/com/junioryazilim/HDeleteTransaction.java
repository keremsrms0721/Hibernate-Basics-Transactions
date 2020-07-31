package com.junioryazilim;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HDeleteTransaction {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Person.class)
			.buildSessionFactory();
	
	static Session s = factory.getCurrentSession();
	
	public static void main(String[] args) {
		
		try
		{
			s.beginTransaction();
			Person p = s.get(Person.class, 3);
			s.delete(p);			
			s.getTransaction().commit();
		}finally
		{
			s.close();
			factory.close();
		}
		
	}
	
}
