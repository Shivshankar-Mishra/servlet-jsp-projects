package com.jsp.simple_jdbc_project.controller;

import java.util.Scanner;

public class UserController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char y;
		do {
			System.out.println("1. Fetch/Show Table Data");
			System.out.println("2. Insert Data into Table");
			System.out.println("3. Update Table Data");
			System.out.println("4. Delete Data from Table");
			System.out.println("5. Print Range Data");
			System.out.println("Please Select number of action which do you want to perform: ");
			int x = sc.nextInt();
			switch (x) {
			case 1: {
				System.out.println("All Table Data Printed Below");
				UserFetchController.fetch();
				break;
				}
			case 2: {
				System.out.println("You want to Insert Data into Table");
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				System.out.println("Enter name: ");
				String name= sc.next();
				System.out.println("Enter Email: ");
				String email = sc.next();
				System.out.println("Enter phone: ");
				long phone = sc.nextLong();
				UserInsertController.insert(id, name, email, phone);
				break;
			}
			case 3: {
				System.out.println("You want to Update Table Data");
				System.out.println("Enter ID where want update: ");
				int id = sc.nextInt();
				System.out.println("Column List: [ name, email, phone ]");
				System.out.println("Enter Column Name from Above List: ");
				String col = sc.next();
				System.out.println("Enter Value: ");
				String val = sc.next();
				UserUpdateController.update(col, val, id);
				break;
				}
			case 4: {
				System.out.println("You want to Delete Data from Table");
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				UserDeleteController.delete(id);
				break;
				}
			case 5: {
				System.out.println("You want to print data between a Range");
				System.out.println("Enter Lower ID Range: ");
				int lower = sc.nextInt();
				System.out.println("Enter Higher ID Range: ");
				int higher = sc.nextInt();
				UserRangeFetchController.rangeFetch(lower, higher);
				break;
				}
			default:
				throw new IllegalArgumentException("Unexpected value: " + x);
			}
		System.out.println("Press Y/y to run again: ");
		y = sc.next().charAt(0);
		}while(y == 'y' || y =='Y');
		sc.close();
	}

}
