package com.junioryazilim;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HInsertTransaction {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Person.class)
			.buildSessionFactory();
	static Session s = factory.getCurrentSession();
	
	public static void main(String[] args) {
		
		try
		{
			s.beginTransaction();
// If you want take input from user , then remove the comments below and another p object.
//			Scanner scan = new Scanner(System.in);
//			String username= scan.next();
//			String surname = scan.next();
//			Person p = new Person(0,username,surname);
			Person p = new Person(0,"Junior","Yazilim");
			s.save(p);
			s.getTransaction().commit();
		}finally
		{
			s.close();
			factory.close();
		}
		
	}
	
}
