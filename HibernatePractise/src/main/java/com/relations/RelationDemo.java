package com.relations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class RelationDemo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Parent parent = new Parent();
		parent.setName("Syed Khaja Moin Uddin");
		parent.setAge(60);
		parent.setBirth(new Date());
		parent.setChildren(12);
		parent.setOld(true);

//	Child class
		Child child1 = new Child();
		child1.setName("Syed Hamed");
		child1.setAge(22);
		child1.setBirth(new Date(1999, 1, 7));
		
		Child child2 = new Child();
		child2.setName("Syed Mahmood");
		child2.setAge(21);
		child2.setBirth(new Date(1999, 1, 7));
		
		Child child3 = new Child();
		child3.setName("Syed Mustafa");
		child3.setAge(21);
		child3.setBirth(new Date(1999, 1, 7));
		
		
		List<Child> children=new ArrayList<Child>();
		children.add(child3);
		children.add(child2);
		children.add(child1);
		
		parent.setChild(children);

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(child1);
		session.save(child2);
		session.save(child3);
		
		
		session.save(parent);
		tx.commit();
		session.close();
	}
}
