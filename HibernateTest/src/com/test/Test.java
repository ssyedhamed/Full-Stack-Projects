package com.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		Student s=new Student("Syed Mahmood", "28294", "Information Technology");
		Configuration cfg=new Configuration();
		cfg.configure("com/hibernate/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		session.save(s);
		System.out.println("saved");
		trans.commit();
	}
}
