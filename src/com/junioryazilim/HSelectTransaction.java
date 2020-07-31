package com.junioryazilim;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HSelectTransaction {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Person.class)
			.buildSessionFactory();
	static Session s = factory.getCurrentSession();
	
	public static void main(String[] args) {
		
		try
		{
			s.beginTransaction();
			
			List<Person> persons = s.createQuery("from Person").getResultList();
			
			for(Person p : persons)
			{
				System.out.print(p.getPersonId()+" "+p.getPersonName()+" "+p.getPersonSurname());
				System.out.println();
			}
			s.getTransaction().commit();
		}
		finally
		{
			s.close();
			factory.close();
		}
		
		
	}
	
	
}
