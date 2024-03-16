package com.jsp.session_tracking.dto;
/**
 * @author Shivshankar Mishra
 */
public class User {
	/*
	 * This is the encapsulated class with constructor
	 */
	private int id;
	private String name;
	private String email;
	private long phone;
	private String gender;
	private String address;
	private String pass;
	/*
	 * Here is the constructor of this class
	 */
	public User() {
		super();
	}
	public User(String name, String email, long phone, String gender, String address, String pass) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.pass = pass;
	}
	public User(int id, String name, String email, long phone, String gender, String address, String pass) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.pass = pass;
	}
	/*
	 * here is the toString() method
	 */
	
	/*
	 * Here is the getter and setter methods
	 */
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", address=" + address + ", pass=" + pass + "]";
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	

}
