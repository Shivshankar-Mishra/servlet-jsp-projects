package com.jsp.session_tracking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.session_tracking.dto.User;
import com.jsp.session_trackingservice.UserService;

/**
 * @author Shivshankar Mishra
 */
@WebServlet ("/login")
public class LogIn extends HttpServlet {
	UserService us = new UserService();
	User u = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		u = us.userLogInData(email, pass);
		PrintWriter out = resp.getWriter();
		if(email.equals(u.getEmail()) && pass.equals(u.getPass())) {
			HttpSession session = req.getSession();
			session.setAttribute("uname", u.getName());
			req.getRequestDispatcher("userTable.jsp").include(req, resp);
		}
		else {
			out.println("<p style='color:red'>Please login again with right credentials</p>");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}
		
	}

}
