package com.javatpoint.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class EmployeeRequest implements Serializable{
	
	private String name;
	private String salary;	
	private String city, state;
	private String pincode;
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getPincode() {
		return this.pincode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public Address getAddress() {
		return new Address(city,state,Integer.valueOf(pincode));
	}
	
	public EmployeeRequest() {}
	
	public String getSalary() { return salary; }

	public String getName() {
		return name;
	}

}
