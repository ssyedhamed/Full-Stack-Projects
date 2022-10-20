package net.helper;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class SessionFact {
	public static SessionFactory getSessionFactory() {
		SessionFactory s = null;
		if (s == null) {
			s = new Configuration().configure().buildSessionFactory();
		}
		return s;
	}
}