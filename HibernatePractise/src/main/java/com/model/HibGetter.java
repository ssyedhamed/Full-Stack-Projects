package com.model;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibGetter {
public static void main(String[] args) {
	Session session=new Configuration().configure().buildSessionFactory().openSession();
	Address adr=(Address)session.get(Address.class, 22);
//	Address adr=(Address)session.load(Address.class, 22);
	System.out.println(adr);


}
}
