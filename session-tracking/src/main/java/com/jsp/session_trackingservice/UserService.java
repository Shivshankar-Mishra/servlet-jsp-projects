package com.jsp.session_trackingservice;

import java.util.List;

import com.jsp.session_tracking.dao.UserDao;
import com.jsp.session_tracking.dto.User;

/**
 * @author Shivshankar Mishra
 */
public class UserService {
	UserDao ud = new UserDao();
	/**
	 * this is the method which interact with dao and controller package 
	 * this method is for inserting data
	 * @return void
	 */
	public void insertUser(User u) {
		ud.insert(u);
	}
	/**
	 * this is the method which interact with dao and controller package 
	 * this method is for fetching all data
	 * @return List of users
	 */
	public List<User> fetchAllData() {
		return ud.fetchAll();
	}
	/**
	 * this is the method which interact with dao and controller package 
	 * this method is for fetching one data
	 * @return List of users
	 */
	public User fetchOneData(int id) {
		return ud.fetchOne(id);
	}
	/**
	 * this is the method which interact with dao and controller package 
	 * this method is for deleting data
	 * @return void
	 */
	public void deleteUser(int id) {
		ud.delete(id);;
	}
	/**
	 * this is the method which interact with dao and controller package 
	 * this method is for updating data
	 * @return void
	 */
	public void updateUser(User u) {
		ud.update(u);
	}
	/**
	 * this is the method which interact with dao and controller package 
	 * this method is for matching the Login data of user and database user data
	 * @return User - it returns a user data
	 */
	public User userLogInData(String email, String pass) {
		return ud.userLogin(email, pass);
	}

}
