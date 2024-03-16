package com.jspider.jdbc_prepared_statement_demo_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_prepared_statement_demo_project.connection.StudentDatabaseConnection;
import com.jspider.jdbc_prepared_statement_demo_project.dto.StudentDto;

/***
 * @author Shivshankar Mishra
 * 
 * This is the dao class which is use to manipulate database
 * It is directly connected to database
 */
public class StudentDao {
	Connection conn = StudentDatabaseConnection.connect();
	/**
	 * Here is the method for inserting data into database 
	 */
	public StudentDto insertData(StudentDto student) {
		try {
			String query = "INSERT INTO student VALUES(?,?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setInt(1, student.getId());
			pt.setString(2, student.getName());
			pt.setString(3, student.getEmail());
			pt.setLong(4, student.getPhone());
			pt.setObject(5, student.getDob());
			
			pt.execute();
			System.out.println("Data Stored in Defind table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
		
	}
	/**
	 * Here is the method for fetch one data from database
	 */
	public StudentDto fetchOneRow(int id) {
		StudentDto student = null;
		try {
			String query = "SELECT * FROM student WHERE studentid=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setInt(1, id);
			ResultSet rs = pt.executeQuery();
			if(rs.next()) {
				student = new StudentDto();
				student.setId(rs.getInt("studentid"));
				student.setName(rs.getString("studentname"));
				student.setEmail(rs.getString("studentemail"));
				student.setPhone(rs.getLong("studentphone"));
				student.setDob(rs.getObject("studentdob",LocalDate.class));
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Here is the method for fetch all data from database
	 */
	public List<StudentDto> fetch() {
		try {
			String query = "SELECT * FROM student";
			StudentDto student = null;
			PreparedStatement pt = conn.prepareStatement(query);
			ResultSet rs = pt.executeQuery();
			List<StudentDto> std = new ArrayList<StudentDto>();
			while(rs.next()) {
				student = new StudentDto();
				student.setId(rs.getInt("studentid"));
				student.setName(rs.getString("studentname"));
				student.setEmail(rs.getString("studentemail"));
				student.setPhone(rs.getLong("studentphone"));
				student.setDob(rs.getObject("studentdob",LocalDate.class));
				std.add(student);
				}
			return std;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Here is the method for updating column data of database
	 */
	public int update(int id, String col, String val) {
		try {
			String query = "UPDATE student SET "+ col +"=? WHERE studentid=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, val);
			pt.setInt(2, id);
			int x = pt.executeUpdate();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * Here is the method for delete the row of database
	 */
	public int delete(int id) {
		try {
			String query = "DELETE FROM student WHERE studentid=?";
			PreparedStatement pt;
			pt = conn.prepareStatement(query);
			pt.setInt(1, id);
			int x = pt.executeUpdate();
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
