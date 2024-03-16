package com.jspider.jdbc_prepared_statement_demo_project.controller;

import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_demo_project.service.StudentService;

/**
 * @author Shivshankar Mishra
 */
public class StudentDeleteController {
/**
 * Here is the main method for deleting row from database
 */
	public static void main(String[] args) {
		StudentService sds = new StudentService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the row: ");
		int x = sc.nextInt();
		sds.deleteData(x);
		sc.close();
	}
}
