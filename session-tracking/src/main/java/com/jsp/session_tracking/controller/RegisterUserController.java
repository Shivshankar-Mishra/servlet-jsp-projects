package com.jsp.session_tracking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.session_tracking.dto.User;
import com.jsp.session_trackingservice.UserService;

/**
 * @author Shivshankar Mishra
 */
@WebServlet ("/registration")
public class RegisterUserController extends HttpServlet {
	User u = null;
	UserService us = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		String gender = req.getParameter("gen");
		String address = req.getParameter("address");
		String pass = req.getParameter("pass");
		u = new User(name, email, phone, gender, address, pass);
		us.insertUser(u);
		req.getRequestDispatcher("userTable.jsp").forward(req, resp);
		
	}

}
