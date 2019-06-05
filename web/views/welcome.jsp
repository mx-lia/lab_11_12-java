<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.05.2019
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
</head>
<body>
    <div class="w3-container w3-center">
        <h2>Welcome</h2>
        <p>${user}, hello!</p>
    </div>
    <table class="w3-table-all w3-card-4 w3-margin">
        <caption>List of students</caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.phone}</td>
            </tr>
        </c:forEach>
    </table>
    <form method="post" action="Controller" class="w3-margin">
        <input type="hidden" name="command" value="add_student"/>
        <p>New:</p>
        <p>
            <label for="name">Name: </label>
            <input type="text" id="name" name="name" value=""/>
        </p>
        <p>
            <label for="email">Email: </label>
            <input type="text" id="email" name="email" value=""/>
        </p>
        <p>
            <label for="phone">Phone: </label>
            <input type="text" id="phone" name="phone" value=""/>
        </p>
        <input type="submit" value="Add" class="w3-button w3-red"/>
    </form>
    <a href="Controller?command=sign_out">Logout</a>
</body>
</html>
