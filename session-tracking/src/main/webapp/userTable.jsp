
<%@page import="com.jsp.session_tracking.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.session_trackingservice.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% HttpSession session2 = request.getSession();
    if (session2 != null) {
    	String username = (String) session.getAttribute("uname");
     	int maxInactiveSeconds = 10;
     	session.setMaxInactiveInterval(maxInactiveSeconds);
        if (username != null) {
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Table</title>
</head>
<body>
<table>
	<% UserService us = new UserService();
		List<User> users = us.fetchAllData();
	%>
	<thead>
		<tr><th>Id</th><th>Name</th><th>Email</th><th>Phone</th><th>Gender</th><th>Address</th><th>Delete</th><th>Edit</th></tr>
	</thead>
	<tbody>
		<% for(User u: users){ %>
		<tr>
			<td><%= u.getId() %></td><td><%= u.getName() %></td><td><%= u.getEmail() %></td><td><%= u.getPhone() %></td>
			<td><%= u.getGender() %></td><td><%= u.getAddress() %></td><td><a href="delete?id=<%= u.getId() %>"><button>Delete</button></a></td><td><a href="updateForm.jsp?id=<%= u.getId() %>"><button>Edit</button></a></td>
		</tr>
		<%} %>
	</tbody>
</table>
<a href="logout"><button>Logout</button></a>

</body>
</html>
<% } else {
    response.sendRedirect("login.jsp");
}
}else{
	response.sendRedirect("login.jsp");
}%>