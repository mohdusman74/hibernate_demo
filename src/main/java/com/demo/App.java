package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
      SessionFactory fectory=new Configuration().configure().buildSessionFactory();
      Session session =fectory.openSession();
//      insert records.......
      Transaction tr=session.beginTransaction();
//      session.save(new Employee(235, "mohammad", "usman", "kashipur"));
      tr.commit();
      
//      get records.......
      Employee emp=session.get(Employee.class,234);
      if(emp!=null) {
      System.out.println(emp);
      }else {
    	  System.out.println("data not availeble for this id..");
      }
      
      
//      Employee emp=get(234);
//      System.out.println(emp.getFirstName());
//		save(new Employee(123, "saba", "khante", "allahabad"));
	}

	
	
	
	
	
	
	
	
	public static void save(Employee emp) {
//		System.out.println(emp.getFirtName());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hibernate", "root", "manager");
			String insert = "update employee set firtName=?, lastName=?, address=? where id=?";
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setInt(4, emp.getId());
			ps.setString(1, "sahfgs");
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getAddress());
			ps.executeUpdate();
			System.out.println("connection succeed...");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static Employee get(int id) {
		Employee emp=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hibernate", "root", "manager");
			String insert = "select *from employee where id=?";
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				emp=new Employee();
				emp.setId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setAddress(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return emp;
	}
	
}
