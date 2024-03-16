package com.jsp.form.dto;
/**
 * @author Shivshankar Mishra
 * 
 * here is encapsulation class
 */
/**
 * 
 */
public class User {
	/*
	 * here are private variables
	 */
	private int id=1;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String address;
	/*
	 * Here is the constructors of class
	 */
	
	public User() {
		super();
	}
	public User(String name, String email, String phone, String gender, String address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
	}
	/*
	 * Here is getter and setter methods
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
/*
 * Here is toString() method	
 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", address=" + address + "]";
	}
	
	
	

}
