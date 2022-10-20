
package com.hpractse.HibernatePractise;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.model.Address;

import com.model.Student;
public class App {
	public static void main(String[] args) throws IOException {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();

		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
//		creatinf address
		Address adr=new Address();
		adr.setCity("Aurangabad");
		adr.setDate(new Date());
		FileInputStream fis= new FileInputStream("src/main/java/profile.png");
		byte[] b=new byte[fis.available()];
		fis.read(b);
		adr.setImage(null);
		adr.setNot(120);
		adr.setOpen(false);
		Student student=new Student();
		student.setName("Syed Hamed");
		student.setBranch("IT");
		student.setRollNo("160318737029");
		student.setAddr(adr);
		session.save(student);
//		session.save(s);
		tx.commit();
//		SessionFactory factory=new Configuration().configure().buildSessionFactory();
	}
}
