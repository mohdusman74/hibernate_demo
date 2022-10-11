/**
 * 
 */
package com.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author usman
 *
 */
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String address;

	public Employee() {

	}

	public Employee(int id, String firtName, String lastName, String address) {
		super();
		this.id = id;
		this.firstName = firtName;
		this.lastName = lastName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firtName) {
		this.firstName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
  
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ "]";
	}

}
