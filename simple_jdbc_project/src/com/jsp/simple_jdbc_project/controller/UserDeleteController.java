package com.jsp.simple_jdbc_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDeleteController {
	public static void delete(int id) {
		Connection conn=null;
		
		try {
//		first Step: Load The Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Second Step: Load The Class
			String url = "jdbc:mysql://localhost:3306/jffsrd-m4";
			String user = "root";
			String pass = "root";
			conn = DriverManager.getConnection(url, user, pass);
			
//			Third Step: Create Statement
			Statement st = conn.createStatement();
			
//			Forth Step: Execute Query
			String query = "DELETE FROM user WHERE id="+id;
			int del = st.executeUpdate(query);
			if(del == 1) {
				System.out.println("Table Row Deleted....");
			}else {
				System.out.println("Table Row could not Deleted....");				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//			Fifth Step: Close Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
