package com.javatpoint.rest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="salary")
	private int salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName="id")
	private Address address;
	
	public int getId() {
		return id;
	}
	
	public Employee(String name, int salary) {
		this.name=name;
		this.salary = salary;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address=address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee() {}
	
	public int getSalary() { return salary; }
	
	public String getName() { return name; } 
}