package com.jspider.jdbc_prepared_statement_demo_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Shivshankar Mishra
 */

public class StudentDatabaseConnection {
	/**
	 * 
	 * @return Connection of jdbc and mysql
	 */

	public static Connection connect() {
		try {
			/**
			 * Here class is loaded and connection establish with mysql and jdbc
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jspider";
			String user="root";
			String pass="root";
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
