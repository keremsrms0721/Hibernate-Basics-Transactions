package com.junioryazilim;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HUpdateTransaction {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Person.class)
			.buildSessionFactory();
	static Session s = factory.getCurrentSession();
	
	public static void main(String[] args) {
		
		try
		{
			s.beginTransaction();
			Person p = s.get(Person.class, 6);
			//before changed
			System.out.println(p.getPersonId()+" "+p.getPersonName()+" "+p.getPersonSurname());
			p.setPersonName("Kağan");
			// after changed
			System.out.println(p.getPersonId()+" "+p.getPersonName()+" "+p.getPersonSurname());
			s.save(p);
			s.getTransaction().commit();
		}
		finally
		{
			s.close();
			factory.close();
		}
		
	}

}
