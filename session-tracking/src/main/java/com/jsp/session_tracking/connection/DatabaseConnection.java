package com.jsp.session_tracking.connection;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * @author Shivshankar Mishra
 */
public class DatabaseConnection{
	public static Connection connect() {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url ="jdbc:mysql://localhost:3306/session_tracking";
	String user = "root";
	String pass = "root";
	Connection conn = DriverManager.getConnection(url, user, pass);
	
	return conn;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
	}

}
