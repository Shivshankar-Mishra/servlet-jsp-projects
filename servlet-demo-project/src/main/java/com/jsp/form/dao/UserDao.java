package com.jsp.form.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.form.connection.DbConnection;
import com.jsp.form.dto.User;

/**
 * @author Shivshankar Mishra
 * 
 * This is Dao class that interact with the database
 */
public class UserDao {
	Connection conn = DbConnection.connect();
	User u = null;
	/*
	 * Here is the method for inserting data into database
	 */
	public User insert(User u) {
		try {
			String query= "INSERT INTO users(name,email,phone,gender,address) VALUES(?,?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, u.getName());
			pt.setString(2, u.getEmail());
			pt.setString(3, u.getPhone());
			pt.setString(4, u.getGender());
			pt.setString(5, u.getAddress());
			pt.execute();

			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return null;
	}
	/*
	 * Here is the code for display data
	 */
	public List<User> fetch() {
		try {
			String query = "SELECT * FROM users";
			PreparedStatement pt = conn.prepareStatement(query);
			ResultSet rs = pt.executeQuery();
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
				users.add(u);
				
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	 * Here is the delete method
	 */
	public void delete(int id) {
		try {
			String query = "DELETE FROM users WHERE id=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setInt(1, id);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Here is the method for fetch data by Id
	 */
	public User fetchOne(int id) {
		try {
			String query = "SELECT * FROM users WHERE id=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setInt(1, id);
			ResultSet rs = pt.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId(id);
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
			}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	 * Here is the method for updating value user in database
	 */
	public void update(String name,String email, String phone, String gender, String address, int id) {
		try {
			String query = "UPDATE users SET name=?, email=?, phone=?, gender=?, address=? WHERE id=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setString(3, phone);
			pt.setString(4, gender);
			pt.setString(5, address);
			pt.setInt(6, id);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
