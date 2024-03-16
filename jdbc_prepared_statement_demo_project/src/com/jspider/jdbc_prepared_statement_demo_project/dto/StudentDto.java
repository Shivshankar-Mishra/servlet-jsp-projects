package com.jspider.jdbc_prepared_statement_demo_project.dto;

import java.time.LocalDate;
/**
 * This is encapsulation/POJO class
 * It is use for creating object
 */
public class StudentDto {
	/**
	 * Here are the state of the class
	 */
	private int id;
	private String name;
	private String email;
	private long phone;
	private LocalDate dob;
	/**
	 * Here is the default constructor of the class
	 * 
	 */
	public StudentDto() {
		super();
	}
	/**
	 * Here is the parameterized constructor of the class
	 * 
	 */
	public StudentDto(int id, String name, String email, long phone, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}
	/**
	 * Here is the getter and setter method for this class
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	/**
	 * Here is the toString() for printing the details of student
	 */
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ "]";
	}
	
	
	
}
