<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Alumni</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Edit Alumni</h2>

<form action="edit" method="post">

    <input type="hidden" name="id" value="<%= request.getAttribute("id") %>" />

    Name:
    <input type="text" name="name" value="<%= request.getAttribute("name") %>" required/><br/><br/>

    Email:
    <input type="email" name="email" value="<%= request.getAttribute("email") %>" required/><br/><br/>

    Year:
    <input type="number" name="year" value="<%= request.getAttribute("year") %>" required/><br/><br/>

    Course:
    <input type="text" name="course" value="<%= request.getAttribute("course") %>" required/><br/><br/>

    <button type="submit">Update</button>

</form>

</body>
</html>