package com.jsp.form.service;
/**
 * @author Shivshankar Mishra
 */

import java.util.List;

import com.jsp.form.dao.UserDao;
import com.jsp.form.dto.User;

public class UserService {
/*
 * Here is the method for inserting data	
 */
	UserDao ud = new UserDao();
	public User insertData(User u) {
		ud.insert(u);
		return u;
		
	}
	/*
	 * Here is the method for fetching data
	 */
	public List<User> fetchData(){
		return ud.fetch();
	}
	/*
	 * Here is the method for delete user by id
	 */
	public void deleteUser(int id) {
		ud.delete(id);
	}
	/*
	 * Here is the method for fetch one data
	 */
	public User fetchOneData(int id) {
		return ud.fetchOne(id);
	}
	/*
	 * Here is the method for updating user data
	 */
	public void updateData(User u) {
		ud.update(u.getName(), u.getEmail(), u.getPhone(), u.getGender(), u.getAddress(), u.getId());
	}
}
