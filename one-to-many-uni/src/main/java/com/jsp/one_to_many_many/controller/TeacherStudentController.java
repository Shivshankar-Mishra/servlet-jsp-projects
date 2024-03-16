package com.jsp.one_to_many_many.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jsp.one_to_many_many.dto.Student;
import com.jsp.one_to_many_many.dto.Teacher;
import com.jsp.one_to_many_many.service.TeacherStudentService;

/**
 * @author Shivshankar Mishra
 */
public class TeacherStudentController {
	public static void main(String[] args) {
		TeacherStudentService tss = new TeacherStudentService();
		Scanner sc = new Scanner(System.in);
		char c;
		do {
			System.out.println("1. Insert Data");
			System.out.println("2. Display All Data");
			System.out.println("3. Display Data by Id");
			System.out.println("4. Update Data");
			System.out.println("5. Delete Teacher");
			System.out.println("6. Delete Student");
			System.out.println("7. Display Student by Id");
			System.out.println("Select Your option: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("<------------- You select to insert data -------------->");
				System.out.println("Insert teacher data---------->");
				System.out.println("Enter teacher id:");
				int tid = sc.nextInt();
				System.out.println("Enter teacher name:");
				String tname = sc.next();
				System.out.println("Enter teacher email:");
				String temail = sc.next();
				System.out.println("Enter teacher phone:");
				long tphone = sc.nextLong();
				System.out.println("Enter students detail-------->");
				System.out.println("How many students do you want to enter: ");
				int n = sc.nextInt();
				List<Student> students = new ArrayList<Student>();
				for(int i = 0; i<n; i++) {
					System.out.println("Enter student id: ");
					int sid = sc.nextInt();
					System.out.println("Enter student name: ");
					sc.nextLine();
					String sname = sc.nextLine();
					System.out.println("Enter student email: ");
					String semail = sc.nextLine();
					System.out.println("Enter your gender: ");
					String sgender = sc.next();
					System.out.println("Enter student phone: ");
					long phone = sc.nextLong();
					
					Student st = new Student(sid, sname, semail, sgender, phone);
					students.add(st);
					
				}
				
				Teacher t = new Teacher(tid, tname, temail, tphone, students);
				tss.insertData(t);
				System.out.println("Data Inserted");
				break;
			case 2:
				System.out.println("<------------- You wanted to display all data ------------>");
				List<Teacher> teachers = tss.fetchAllData();
				for(Teacher tcher: teachers) {
					System.out.println("Teacher Id: "+tcher.getId()+"\tTeacher Name: "+tcher.getName()+"\tTeacher Email: "+tcher.getEmail()+"\tTeacher Phone: "+tcher.getPhone());
					List<Student> studentAll = tcher.getStudent();
					for(Student std : studentAll) {
						System.out.println(std);
					}
				}
				break;
			case 3:
				System.out.println("<--------- You want to display One Data by Id --------->");
				System.out.println("Enter Teacher id: ");
				int tid1 = sc.nextInt();
				Teacher teacher = tss.fetchOneData(tid1);
				System.out.println("Teacher Id: "+teacher.getId()+"\tTeacher Name: "+teacher.getName()+"\tTeacher Email: "+teacher.getEmail()+"\tTeacher Phone: "+teacher.getPhone());
				List<Student> studentAll = teacher.getStudent();
				for(Student std : studentAll) {
					System.out.println(std);
				}
				break;
			case 4:
				System.out.println("<--------- You want to Update the data --------->");
				System.out.println("Enter Teacher Id: ");
				int tid2 = sc.nextInt();
				Teacher teacher2= tss.fetchOneData(tid2);
				System.out.println("What you want to update of Teacher:");
				System.out.println("1. Name\n2. Email\n3. Phone\n4. All Teacher Data\n5. Students Data\nSelect a number from list: ");
//				int choice_for_update = sc.nextInt();
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter new name: ");
					sc.nextLine();
					teacher2.setName(sc.nextLine());
					Teacher teacher3 = tss.updateTeacherData(teacher2);
					if(teacher3!=null) {
						System.out.println("Data Updated!!!");
					}
					else {
						System.out.println("Please update again. There are some problem occurred");
					}
					break;
				case 2:
					System.out.println("Enter new email: ");
					sc.nextLine();
					teacher2.setEmail(sc.nextLine());
					Teacher teacher4 = tss.updateTeacherData(teacher2);
					if(teacher4!=null) {
						System.out.println("Data Updated!!!");
					}
					else {
						System.out.println("Please update again. There are some problem occurred");
					}
					break;
				case 3:
					System.out.println("Enter new phone: ");
//					sc.nextLine();
					teacher2.setPhone(sc.nextLong());
					Teacher teacher5 = tss.updateTeacherData(teacher2);
					if(teacher5!=null) {
						System.out.println("Data Updated!!!");
					}
					else {
						System.out.println("Please update again. There are some problem occurred");
					}
					break;
				case 4:
					System.out.println("Enter new name: ");
					sc.nextLine();
					teacher2.setName(sc.nextLine());
					System.out.println("Enter new email: ");
					teacher2.setEmail(sc.nextLine());
					System.out.println("Enter new phone: ");
					teacher2.setPhone(sc.nextLong());
					Teacher teacher6 = tss.updateTeacherData(teacher2);
					if(teacher6!=null) {
						System.out.println("Data Updated!!!");
					}
					else {
						System.out.println("Please update again. There are some problem occurred");
					}
					break;
				case 5:
					System.out.println("You want to Update student data from teacher------>");
					System.out.println("Enter student id: ");
					int sid = sc.nextInt();
					for(Student st : teacher2.getStudent()) {
						if(sid==st.getId()) {
							
							System.out.println("What you want to update --------->");
							System.out.println("1. Student Name\n2. Student Email\n3. Student Phone\n4. All Student Data\nSelect your option from list: ");
							switch(sc.nextInt()) {
							case 1:
								System.out.println("Enter new student name: ");
								sc.nextLine();
								st.setName(sc.nextLine());
								Teacher teacher7 = tss.updateTeacherData(teacher2);
								if(teacher7!=null) {
									System.out.println("Data Updated!!!");
								}
								else {
									System.out.println("Please update again. There are some problem occurred");
								}
								break;
							case 2:
								System.out.println("Enter new student email: ");
								sc.nextLine();
								st.setEmail(sc.nextLine());
								Teacher teacher8 = tss.updateTeacherData(teacher2);
								if(teacher8!=null) {
									System.out.println("Data Updated!!!");
								}
								else {
									System.out.println("Please update again. There are some problem occurred");
								}
								break;
							case 3:
								System.out.println("Enter new student phone: ");
//								sc.nextLine();
								st.setPhone(sc.nextLong());
								Teacher teacher9 = tss.updateTeacherData(teacher2);
								if(teacher9!=null) {
									System.out.println("Data Updated!!!");
								}
								else {
									System.out.println("Please update again. There are some problem occurred");
								}
								break;
							case 4:
								System.out.println("You want update all student data --------->");
								System.out.println("Enter student new name: ");
								sc.nextLine();
								st.setName(sc.nextLine());
								System.out.println("Enter new student email: ");
								st.setEmail(sc.nextLine());
								System.out.println("Enter  student gender: ");
								st.setGender(sc.next());
								System.out.println("Enter new student phone: ");
								st.setPhone(sc.nextLong());
								Teacher teacher10 = tss.updateTeacherData(teacher2);
								if(teacher10!=null) {
									System.out.println("Data Updated!!!");
								}
								else {
									System.out.println("Please update again. There are some problem occurred");
								}
								break;
							default:
								System.out.println("Please Enter valid option!!!");
							}
						}
					}
					break;
				default:
					System.out.println("Please enter valid option from list!!!");
				}
				break;
			case 5:
				System.out.println("You want to delete the Teacher");
				System.out.println("Enter teacher id: ");
				tss.deleteTeacherData(sc.nextInt());
				System.out.println("Teacher data deleted!!!");
				break;
			case 6:
				System.out.println("You want to delete student data");
				System.out.println("Enter teacher id belongs to that student: ");
				int tid4 = sc.nextInt();
				System.out.println("Enter student id: ");
				int sid4 = sc.nextInt();
				Teacher teacher3 = tss.fetchOneData(tid4);
				Student student = tss.fetchOneStudent(tid4, sid4);
				List<Student> students1 = teacher3.getStudent();
				students1.remove(student);
				teacher3.setStudent(students1);
				Teacher teacher4 = tss.updateTeacherData(teacher3);
				if(teacher4 != null) {
					System.out.println("Student deleted by the refernce of teacher");
				}else {
					System.out.println("Something bad happens!!!  Try again....");
				}
				break;
			case 7:
				System.out.println("You want to display student");
				System.out.println("Enter teacher id: ");
				int tid3 = sc.nextInt();
				System.out.println("Enter student Id: ");
				int sid3 = sc.nextInt();
				Student st = tss.fetchOneStudent(tid3, sid3);
				System.out.println(st);
				break;
			default:
				System.out.println("please enter valid option!!!");
			}
			System.out.println("For running again press [y/Y]: ");
			c = sc.next().charAt(0);
		}while(c=='y'||c=='Y');
	}

}
