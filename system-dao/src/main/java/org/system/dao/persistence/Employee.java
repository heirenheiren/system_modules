package org.system.dao.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="Employee")
@Table(name="Employee",catalog="",schema="")
public class Employee implements Serializable {

	private static final long serialVersionUID = -5448910882687263369L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="")
	private int id;
	
	@Column(name="firstName",nullable=false,columnDefinition="String")
	private String firstName;
	
	@Column(name="lastName",nullable=false,columnDefinition="String")
	private String lastName;
	
	@Column(name="salary",nullable=false,columnDefinition="int")
	private int salary;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="Order")
	Set<Order> setOrder;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}  

	public Set<Order> getSetOrder() {
		return setOrder;
	}

	public void setSetOrder(Set<Order> setOrder) {
		this.setOrder = setOrder;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", "
				+ "firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ ", salary=" + salary + "]";
	}
}
