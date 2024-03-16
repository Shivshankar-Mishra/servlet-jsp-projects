package com.jsp.session_tracking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.session_trackingservice.UserService;
/**
 * @author Shivshankar Mishra
 */
@WebServlet("/delete")
public class DeleteUserController extends HttpServlet {
	UserService us = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		us.deleteUser(id);
		resp.sendRedirect("userTable.jsp");
	}

}
