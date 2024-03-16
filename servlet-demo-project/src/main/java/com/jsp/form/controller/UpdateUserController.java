package com.jsp.form.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jsp.form.dto.User;
import com.jsp.form.service.UserService;

/**
 * @author Shivshankar Mishra
 */
public class UpdateUserController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		UserService us = new UserService();
		User u = new User();
		u.setName(req.getParameter("name"));
		u.setEmail(req.getParameter("email"));
		u.setPhone(req.getParameter("phone"));
		u.setGender(req.getParameter("gen"));
		u.setAddress(req.getParameter("address"));
		u.setId(Integer.parseInt(req.getParameter("id")));
		
		us.updateData(u);
		
		RequestDispatcher rd = req.getRequestDispatcher("userTable.jsp");
		rd.forward(req, res);
	}

}
