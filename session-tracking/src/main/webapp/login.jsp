<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
// Disable caching for this page
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
response.setHeader("Pragma", "no-cache"); 
response.setHeader("Expires", "0"); 
%>
<%
if (session.getAttribute("uname") != null) {
    response.sendRedirect("userTable.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In Form</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script type="text/javascript" src="script.js"></script>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<div class="container">
        <h2>Log-In Form</h2>
        <form id="registration-form" action="login" method="post">
            <div class="form-group">
                <label for="email"><span class="icon-envelope"></span> Email</label>
                <input type="email" id="email" name="email" required>
                <div class="error-message" id="email-error"></div>
            </div>
            <div class="form-group">
                <label for="pass"><span class="fa-solid fa-key"></span> Password</label>
                <input type="password" id="pass" name="pass" required>
                <div class="error-message" id="email-error"></div>
            </div>
            <div class="form-group">
                <input type="submit" class="submit-btn" value="Log-In">
            </div>
            <div class="form-group">
            	<p>If you are not registered please click on:</p>
            	<a href="register.jsp" style="text-align: center, text-decoration: none">Register</a>
            </div>
        </form>
    </div>
    
    <script type="text/javascript">
var isLoggedIn = <%= session.getAttribute("uname") != null %>;

if (isLoggedIn) {
    window.location.replace("userTable.jsp");
}
</script>

</body>
</html>