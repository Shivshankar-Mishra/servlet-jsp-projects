package com.jsp.simple_jdbc_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserUpdateController {
	public static void update(String col,String val, int id) {
		Connection conn= null;
		
		try {
//		First Step: Load/Register connection
			Class.forName("com.mysql.cj.jdbc.Driver");
//		Second Step: Connection
			String url = "jdbc:mysql://localhost:3306/jffsrd-m4";
			String user = "root";
			String pass = "root";
			conn = DriverManager.getConnection(url, user, pass);
			
//		Third Step: Create Statement
			Statement st = conn.createStatement();
			
//		Forth Step: Execute Statement
			String query = "UPDATE user SET "+col+"="+val+" WHERE id="+id;
			int update = st.executeUpdate(query);
			
			if(update==1) {
				System.out.println("Table Data Updated from java program....");
			}else {
				System.out.println("Table Data could not Updated from java program....");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//		Fifth Step: Close Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
