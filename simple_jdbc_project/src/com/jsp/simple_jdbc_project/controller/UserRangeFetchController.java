package com.jsp.simple_jdbc_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRangeFetchController {
	public static void rangeFetch(int lower, int higher) {
		Connection conn = null;
		try {
//		First Step: Load The class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//		Second Step: Register The connection
			String url = "jdbc:mysql://localhost:3306/jffsrd-m4";
			String user = "root";
			String pass = "root";
			conn = DriverManager.getConnection(url, user, pass);
			
//		Third Step: Create Statement
			Statement st = conn.createStatement();
			
//		Forth Step: Execute Query
			String query = "SELECT * FROM user WHERE id BETWEEN "+lower+" AND "+higher;
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+ "\t" + rs.getString("name")+ "\t" + rs.getString("email")+ "\t" + rs.getLong("phone"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
//			Fifth Step: CLose Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
