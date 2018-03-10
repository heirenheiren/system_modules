package org.system.domain.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate5.1中对sessionFactory获取的方法
 *
 */
public class HSessionUtils {
	
	private static Session session = null;
	
	static{
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		
		session = sessionFactory.getCurrentSession();
	}

	public static Session getSession() {
		return session;
	}
}
