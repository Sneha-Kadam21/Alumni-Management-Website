<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Alumni</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Add Alumni</h2>
<form action="add" method="post">
Name:<input type="text" name="name" required /><br/><br/>
Email:<input type="email" name="email" required /><br/><br/>
Graduation Year:<input type="number" name="year" required/><br/><br/>
Course:<input type="text" name="course" required /><br/><br/>

<input type="submit" value="Add Alumni" />


</form>
<br/>

<a href="list">View Alumni</a>
</body>
</html>