package com.jsp.one_to_one_uni.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.one_to_one_uni.dto.Adhar;
import com.jsp.one_to_one_uni.dto.Person;
import com.jsp.one_to_one_uni.service.PersonAdharService;

/**
 * @author Shivshankar Mishra
 */
public class PersonAdharController {
	
	public static void main(String[] args) {
		PersonAdharService ps = new PersonAdharService();
		Scanner sc =new Scanner(System.in);
		Person p = null;
		Adhar a = null;
		System.out.println("<--------- Welcome to One to One Hibernate Project --------->");
		while(true) {
			System.out.println("1. Insert Data");
			System.out.println("2. Display One Data by Id");
			System.out.println("3. exit");
			System.out.println("Please Select Your Option");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// Person Details
				System.out.println("You want to insert data");
				
				System.out.println("Enter id: ");
				int id = sc.nextInt();
				System.out.println("Enter your name: ");
				String name = sc.next();
				System.out.println("Enter your email: ");
				String email = sc.next();
				System.out.println("Enter your mobile no.: ");
				long phone = sc.nextLong();
				System.out.println("Enter your gender: ");
				String gender = sc.next();
				// Adhar details
				System.out.println("Enter your adhar number: ");
				long adharNo = sc.nextLong();
				System.out.println("Enter your birth date: ");
				int dob = sc.nextInt();
				System.out.println("Enter your birth month: ");
				int mob = sc.nextInt();
				System.out.println("Enter your birth year: ");
				int yob = sc.nextInt();
				System.out.println("Enter your address: ");
				String address = sc.next();
				System.out.println("Enter your father name: ");
				sc.nextLine();
				String fatherName = sc.nextLine();
				a = new Adhar(adharNo, address, LocalDate.of(yob, mob, dob), fatherName);
				p = new Person(id, name, email, phone, gender, a);
				Person p1= ps.insertData(p, a);

				break;
			case 2:
				System.out.println("You want to display data by id");
				System.out.println("Enter id: ");
				Person p2 = ps.fetchOneData(sc.nextInt());
				System.out.println(p2);
			case 3:
				return;
			}
			
		}
		
	}

}
