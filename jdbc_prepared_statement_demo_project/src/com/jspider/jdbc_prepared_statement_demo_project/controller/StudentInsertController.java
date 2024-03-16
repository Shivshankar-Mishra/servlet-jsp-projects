package com.jspider.jdbc_prepared_statement_demo_project.controller;

import java.time.LocalDate;
import java.util.Scanner;
import com.jspider.jdbc_prepared_statement_demo_project.dto.StudentDto;
import com.jspider.jdbc_prepared_statement_demo_project.service.StudentService;

/**
 * @author Shivshankar Mishra
 * 
 * This controller class is used for inserting data into the database
 */
public class StudentInsertController {
	/**
	 * Here is the main method
	 */
	public static void main(String[] args) {
		StudentDto student = new StudentDto();
//		StudentDao sdo = new StudentDao();
		StudentService sds = new StudentService();
//		StudentDatabaseConnection connection = new StudentDatabaseConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Main Method start");
		System.out.println("Enter Student Id: ");
		int id = sc.nextInt();
		System.out.println("Enter Student Name: ");
		String name = sc.next();
		System.out.println("Enter Student Email: ");
		String email = sc.next();
		System.out.println("Enter Student Phone: ");
		long phone = sc.nextLong();
		System.out.println("Enter Student Dob =======> ");
		System.out.println("Enter Student Year: ");
		int yy = sc.nextInt();
		System.out.println("Enter Student Month(in digit): ");
		int mm = sc.nextInt();
		System.out.println("Enter Student Date: ");
		int dd = sc.nextInt();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPhone(phone);
		student.setDob(LocalDate.of(yy,mm,dd));
		System.out.println(student);
		sds.insert(student);
		System.out.println("Main Method Ended");
		sc.close();
	}
}
