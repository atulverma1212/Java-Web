package com.javatpoint.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private int pincode;
	
	public Address() {}
	
	public Address(String city, String state, int pincode) {
		this.city=city;
		this.state =state;
		this.pincode=pincode;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public int getPincode() {
		return pincode;
	}
	
	public void setPincode(int pincode) {
		this.pincode=pincode;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public void setState(String state) {
		this.state=state;
	}
}
