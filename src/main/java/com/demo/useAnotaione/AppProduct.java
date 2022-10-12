/**
 * 
 */
package com.demo.useAnotaione;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author usman
 *
 */
public class AppProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tr=session.beginTransaction();
		
//		session.save(new Product(123, "laptop", "3000"));
//		session.persist(new Product(124, "laptop", "3000"));
		session.saveOrUpdate(new Product(123, "mobile", "3000"));
		tr.commit();
	}

}
