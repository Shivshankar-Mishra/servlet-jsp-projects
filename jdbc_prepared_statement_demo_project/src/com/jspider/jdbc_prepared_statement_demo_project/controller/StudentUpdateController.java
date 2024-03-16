package com.jspider.jdbc_prepared_statement_demo_project.controller;

import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_demo_project.service.StudentService;

/**
 * @author Shivshankar Mishra
 */
public class StudentUpdateController {
/**
 * Here is the main method for update database value
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService sds = new StudentService();
		System.out.println("Enter the id you want to update: ");
		int id = sc.nextInt();
		System.out.println("Enter the column you want to change: ");
		String col = sc.next();
		System.out.println("Enter the value: ");
		String val = sc.next();
		sds.updateData(id, col, val);
		sc.close();
	}
}
