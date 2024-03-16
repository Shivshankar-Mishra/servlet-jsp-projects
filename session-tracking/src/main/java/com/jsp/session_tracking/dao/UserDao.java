package com.jsp.session_tracking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.session_tracking.connection.DatabaseConnection;
import com.jsp.session_tracking.dto.User;

/**
 * @author Shivshankar Mishra
 */
public class UserDao {
	Connection conn = DatabaseConnection.connect();
	User u = null;
	/**
	 * Here every methods are declared for database
	 */
	public void insert(User u) {
		/*
		 * This method is used for inserting data into database
		 */
		try {
			String query = "INSERT INTO users(name, email, phone, gender, address, password) VALUES(?,?,?,?,?,?)";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, u.getName());
			pt.setString(2, u.getEmail());
			pt.setLong(3, u.getPhone());
			pt.setString(4, u.getGender());
			pt.setString(5, u.getAddress());
			pt.setString(6, u.getPass());
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * here is the method for displaying all data
	 * @return List<User> it return generic list of users
	 */
	public List<User> fetchAll(){
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
				u.setPhone(rs.getLong("phone"));
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
	/**
	 * here is the method for fetching one User by there id
	 * @return User u - it returns one user data
	 */
	public User fetchOne(int id) {
		try {
			String query = "SELECT * FROM users WHERE id=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setInt(1, id);
			ResultSet rs = pt.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
			}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * here is the method for deleting one user
	 * @return void
	 */
	public void delete(int id) {
		String query = "DELETE FROM users WHERE id=?";
		try {
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setInt(1, id);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * this is the method used to update the user data
	 * @return void
	 */
	public void update(User u) {
		try {
			String query = "UPDATE users SET name=?, email=?, phone=?, gender=?, address=?, password=? WHERE id=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, u.getName());
			pt.setString(2, u.getEmail());
			pt.setLong(3, u.getPhone());
			pt.setString(4, u.getGender());
			pt.setString(5, u.getAddress());
			pt.setString(6, u.getPass());
			pt.setInt(7, u.getId());
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this is a method used to get specific user's details which have email and pass from database
	 * @return user - it returns a user data
	 */
	public User userLogin(String email, String pass) {
		try {
			String query = "SELECT * FROM users WHERE email=? AND password=?";
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1, email);
			pt.setString(2, pass);
			ResultSet rs = pt.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
				u.setPass(rs.getString("password"));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	

}
