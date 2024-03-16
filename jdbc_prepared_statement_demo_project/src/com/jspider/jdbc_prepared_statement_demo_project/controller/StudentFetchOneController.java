package com.jspider.jdbc_prepared_statement_demo_project.controller;

import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_demo_project.dto.StudentDto;
import com.jspider.jdbc_prepared_statement_demo_project.service.StudentService;

/**
 * @author Shivshankar Mishra
 * 
 * This is the controller class for fetching one data from database
 */
public class StudentFetchOneController {
	/**
	 * Here is the main method for fetch
	 */
	public static void main(String[] args) {
		StudentService sds = new StudentService();
		System.out.println("Main method start =========>");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student Id: ");
		int id = sc.nextInt();
		StudentDto student= sds.fetchById(id);
		System.out.println(student);
		System.out.println("main method end ===========>");
		sc.close();
	}
}
