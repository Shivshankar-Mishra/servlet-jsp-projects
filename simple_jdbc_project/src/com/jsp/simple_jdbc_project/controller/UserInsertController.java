package com.jsp.simple_jdbc_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInsertController {
	public static void insert(int id, String name, String email, long phone){
		Connection conn = null;
//		First step: Load the class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Second Step: Register the connection
			String url="jdbc:mysql://localhost:3306/jffsrd-m4";
			String user="root";
			String pass="root";
			conn = DriverManager.getConnection(url, user, pass);
			
//			Third Step: Create Statement
			Statement st= conn.createStatement();
			
//			Forth Step: Execute Query
			String query = "INSERT INTO user VALUES("+id+",'"+name+"','"+email+"',"+phone+")";
			st.execute(query);
			System.out.println("Data Inserted Into The Table");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
