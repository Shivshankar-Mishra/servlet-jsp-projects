package com.jsp.simple_jdbc_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserFetchController {
	public static void fetch() {
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
			String query = "SELECT * FROM user";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");
				System.out.println(id +"\t" + name +"\t" + email +"\t" + phone);
//				System.out.printf("| %3d | %15s | %20s | %11d |", id, name, email, phone);
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
