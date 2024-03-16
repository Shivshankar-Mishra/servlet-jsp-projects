package com.jspider.jdbc_prepared_statement_demo_project.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_demo_project.dto.StudentDto;
import com.jspider.jdbc_prepared_statement_demo_project.service.StudentService;

/**
 * @author Shivshankar Mishra
 */
public class StudentFetchByNameController {
/**
 * Here is the main method for fetch data by the specific name
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService sds = new StudentService();
		System.out.println("main method start ========>");
		System.out.println("Enter student name you want: ");
		String name = sc.next();
		List<StudentDto> student = sds.fetchByName(name);
		for (StudentDto std : student) {
			System.out.println(std);
		}
		sc.close();
	}
}
