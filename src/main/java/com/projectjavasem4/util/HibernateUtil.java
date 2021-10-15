package com.projectjavasem4.util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
//import org.hibernate.metamodel.MetadataSources; //cài nỳ của e
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	public static SessionFactory getSessionFactory() {
		return new MetadataSources(new StandardServiceRegistryBuilder()
				.configure().build()).buildMetadata().buildSessionFactory();
	}
}
