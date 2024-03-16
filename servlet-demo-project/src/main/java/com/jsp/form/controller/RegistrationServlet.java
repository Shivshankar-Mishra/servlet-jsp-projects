package com.jsp.form.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jsp.form.dto.User;
import com.jsp.form.service.UserService;

public class RegistrationServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // Retrieve form data from request parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gen");
        String address = request.getParameter("address");
        User u = new User(name, email, phone, gender, address);

        PrintWriter out = response.getWriter();

        UserService us = new UserService();
		// Execute the query to insert data
		User u1 = us.insertData(u);

		// Check if the data was inserted successfully
		if (u1!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("userTable.jsp");
			rd.forward(request, response);
		} else {
		    out.println("Failed to insert data into the database.");
		}
    }

    @Override
    public String getServletInfo() {
        return "RegistrationServlet";
    }

    @Override
    public void destroy() {

    }
}