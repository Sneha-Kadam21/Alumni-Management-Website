<%@ page import="java.util.List" %>
<%
    // 🔐 Session Protection
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<String[]> list = (List<String[]>) request.getAttribute("alumniList");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Alumni List</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">

    <h2>Alumni List</h2>

    <!-- 🔍 SEARCH FORM -->
    <form action="search" method="post" style="margin-bottom:20px;">
        <input type="text" name="keyword" placeholder="Enter search value" required />

        <select name="type">
            <option value="name">Search by Name</option>
            <option value="email">Search by Email</option>
            <option value="year">Search by Year</option>
        </select>

        <button type="submit">Search</button>
        <a href="list">Reset</a>
    </form>

    <!-- 📋 TABLE -->
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Year</th>
            <th>Course</th>
            <th>Action</th>
        </tr>

        <%
            if (list != null && !list.isEmpty()) {
                for (String[] row : list) {
        %>
        <tr>
            <td><%= row[0] %></td>
            <td><%= row[1] %></td>
            <td><%= row[2] %></td>
            <td><%= row[3] %></td>
            <td><%= row[4] %></td>
            <td>
                <a href="edit?id=<%= row[0] %>&name=<%= row[1] %>&email=<%= row[2] %>&year=<%= row[3] %>&course=<%= row[4] %>">
                    Edit
                </a>
                |
                <a href="delete?id=<%= row[0] %>" 
                   onclick="return confirm('Are you sure you want to delete this record?');">
                    Delete
                </a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No alumni records found.</td>
        </tr>
        <%
            }
        %>

    </table>

    <br>
    <a href="index.jsp">➕ Add New Alumni</a>
    <br><br>
    <a href="logout" class="logout">🚪 Logout</a>

</div>

</body>
</html>