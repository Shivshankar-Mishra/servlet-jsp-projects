package com.jspider.jdbc_prepared_statement_demo_project.controller;

import java.util.List;

import com.jspider.jdbc_prepared_statement_demo_project.dto.StudentDto;
import com.jspider.jdbc_prepared_statement_demo_project.service.StudentService;

/**
 * @author Shivshankar Mishra
 */
public class StudentFetchAllController {
/**
 * This is the main method for fetching all data from database
 */
	public static void main(String[] args) {
		StudentService sds = new StudentService();
		System.out.println("Main Method start");
		System.out.println("Table data printing below =========>");
		List<StudentDto> std = sds.fetchAll();
		for (StudentDto studentDto : std) {
			System.out.println(studentDto);
		}
		System.out.println("Main Method End");
	}
}
