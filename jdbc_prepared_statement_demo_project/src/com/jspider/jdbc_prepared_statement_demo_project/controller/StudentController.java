package com.jspider.jdbc_prepared_statement_demo_project.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_demo_project.dto.StudentDto;
import com.jspider.jdbc_prepared_statement_demo_project.service.StudentService;

/**
 * @author Shivshankar Mishra
 * 
 * This is going to be automatic class it run the code until you exit the program
 */
public class StudentController {
/**
 * Here is the main method for the all operations
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService sds = new StudentService();
		StudentDto student = new StudentDto();
		char x;
		do {
			System.out.println("1. Fetch Any of One Data");
			System.out.println("2. Fetch All Data");
			System.out.println("3. Insert data");
			System.out.println("4. Update data");
			System.out.println("5. Delete data");
			System.out.println("6. Fetch By Name");
			System.out.println("Please Select the operation number which you want to perform: ");
			char choice = sc.next().charAt(0);
		/**
		 * Here is the switch statement and for automation do-while loop is used
		 */
			switch(choice) {
			case '1':
				System.out.println("You select to fetch any of one data");
				System.out.println("Please enter the id which you want to fetch: ");
				int id = sc.nextInt();
				student = sds.fetchById(id);
				System.out.println(student);
				break;
			case '2':
				System.out.println("You selected to fetch all data");
				System.out.println("Table data printed below");
				List<StudentDto> std = sds.fetchAll();
				for (StudentDto studentDto : std) {
					System.out.println(studentDto);
				}
				break;
			case '3':
				System.out.println("You select to insert data into databse");
				System.out.println("Enter Student Id: ");
				int id1 = sc.nextInt();
				System.out.println("Enter Student Name: ");
				String name = sc.next();
				System.out.println("Enter Student Email: ");
				String email = sc.next();
				System.out.println("Enter Student Phone: ");
				long phone = sc.nextLong();
				System.out.println("Enter Student Dob =======> ");
				System.out.println("Enter Dob Year(yyyy): ");
				int yy = sc.nextInt();
				System.out.println("Enter Dob Month(mm): ");
				int mm = sc.nextInt();
				System.out.println("Enter Dob Date(dd): ");
				int dd = sc.nextInt();
				student.setId(id1);
				student.setName(name);
				student.setEmail(email);
				student.setPhone(phone);
				student.setDob(LocalDate.of(yy,mm,dd));
				sds.insert(student);
				break;
			case '4':
				System.out.println("You select to update data of databse");
				System.out.println("Enter the id you want to update: ");
				int id2 = sc.nextInt();
				System.out.println("Enter the column you want to change: ");
				String col = sc.next();
				System.out.println("Enter the value: ");
				String val = sc.next();
				sds.updateData(id2, col, val);
				break;
			case '5':
				System.out.println("You select to delete data from table");
				System.out.println("Enter the id of the row: ");
				int del = sc.nextInt();
				sds.deleteData(del);
				break;
			case '6':
				System.out.println("You selected to fetch by name");
				System.out.println("Enter student name you want: ");
				String studentname = sc.next();
				List<StudentDto> stud = sds.fetchByName(studentname);
				for (StudentDto stu : stud) {
					System.out.println(stu);
				}
			default:
				System.out.println("Please Enter valid option number");
			}
			System.out.println("Are you want to again run if yes press y/Y: ");
			x = sc.next().charAt(0);
		}while(x =='y' || x == 'Y');
		sc.close();
	}
}
