/**
 * 
 */
package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author usman
 *
 */
public class App2 {

	
	public static void main(String[] args) {
		 SessionFactory fectory=new Configuration().configure().buildSessionFactory();
	      Session session =fectory.openSession();
	      Transaction tr=session.beginTransaction();
//	      session.save(new Employee(124, "rohit", "kumar", "faridabad"));
	      Employee emp=session.load(Employee.class, 235);
	      if(emp!=null) {
	    	  session.delete(emp);
	    	  emp.setAddress("delhi");
//	    	  emp.setFirstName("rehan");
//	    	  System.out.println("data updated.....");
	      }else {
	    	  System.out.println("your emplyee id wrong...");
	      }
	      tr.commit();

	}

}
