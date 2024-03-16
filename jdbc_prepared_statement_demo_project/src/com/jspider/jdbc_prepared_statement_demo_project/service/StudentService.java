package com.jspider.jdbc_prepared_statement_demo_project.service;

import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_prepared_statement_demo_project.dao.StudentDao;
import com.jspider.jdbc_prepared_statement_demo_project.dto.StudentDto;

//import java.sql.Connection;


/**
 * @author Shivshankar Mishra
 * 
 * Here is the business logic
 * It is the mediator of controller and dao package
 */
public class StudentService {
	/**
	 * Here is the method for inserting data
	 * @return student object
	 */
	StudentDao sd = new StudentDao();
	public  StudentDto insert(StudentDto student) {
		if(student.getId()!= 0) {
			sd.insertData(student);
		}
		else {
			System.out.println("Enter valid id");
		}
		return student;
		
	}
	/**
	 * Here is the method for fetching one data from database
	 */
	public StudentDto fetchById(int id) {
		StudentDto student = sd.fetchOneRow(id);
		return student;
	}
	/**
	 * Here is the method for fetching all data of the database
	 */
	public List<StudentDto> fetchAll() {
		return sd.fetch();
	}
	/**
	 * Here is the method for update data according to id number
	 */
	public void updateData(int id, String col, String val) {
		int a = sd.update(id, col, val);
		if(a==1) {
			System.out.println("Your data is updated");
		}
		else {
			System.out.println("Something bad happen data had not updated");
		}
	}
	/**
	 * Here is the method for the delete row from table
	 */
	public void deleteData(int id) {
		System.out.println("Do you really want to delete if yes type: Y/y");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		char x = sc.next().charAt(0);
		if(x =='y' || x == 'Y') {
			int a = sd.delete(id);
			if(a==1) {
				System.out.println("Your desired row deleted from databse");
			}
			else {
				System.out.println("Something bad happen data not deleted");
			}
		}
		sc.close();
	}
	/**
	 * Here is the method for fetch data by filter the database and print specific type of of data or filter by name
	 */
	public List<StudentDto> fetchByName(String name){
		List<StudentDto> std = fetchAll();
		List<StudentDto> student = new ArrayList<StudentDto>();
		for (StudentDto stud : std) {
			if(stud.getName().equals(name)) {
				student.add(stud);
			}	
		}
		return student;
	}
}
