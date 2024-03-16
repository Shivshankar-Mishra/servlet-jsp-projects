<%@page import="com.jsp.form.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.form.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Table</title>
</head>
<body>
<table>
	<% UserService us = new UserService();
		List<User> users = us.fetchData();
	%>
	<thead>
		<tr><th>Id</th><th>Name</th><th>Email</th><th>Phone</th><th>Gender</th><th>Address</th><th>Delete</th><th>Edit</th></tr>
	</thead>
	<tbody>
		<% for(User u: users){ %>
		<tr>
			<td><%= u.getId() %></td><td><%= u.getName() %></td><td><%= u.getEmail() %></td><td><%= u.getPhone() %></td>
			<td><%= u.getGender() %></td><td><%= u.getAddress() %></td><td><a href="delete?id=<%= u.getId() %>"><button>Delete</button></a></td><td><a href="edit?id=<%= u.getId() %>"><button>Edit</button></a></td>
		</tr>
		<%} %>
	</tbody>
</table>

</body>
</html>