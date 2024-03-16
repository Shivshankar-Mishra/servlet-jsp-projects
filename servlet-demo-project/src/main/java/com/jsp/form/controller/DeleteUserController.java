package com.jsp.form.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jsp.form.service.UserService;
/**
 * @author Shivshankar Mishra
 */
public class DeleteUserController extends GenericServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		us.deleteUser(id);
		RequestDispatcher rd = req.getRequestDispatcher("userTable.jsp");
		rd.forward(req, res);
		
		
	}

}
