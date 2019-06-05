<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.05.2019
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" type="text/css"/>
</head>
<body>
<div class="w3-container">
    <div class="w3-display-topmiddle">
        <c:import url="/views/header.html"/>
    </div>
    <div class="w3-card-4 w3-display-middle w3-hide-small" style="width:30%">
        <div class="w3-container w3-green w3-center">
            <h2>Register form</h2>
        </div>
        <form name="registerForm" method="post" action="http://localhost:8080/JAVA_LR11_12_war_exploded/Controller" class="w3-container">
            <input type="hidden" name="command" value="register"/>
            <div class="w3-row-padding">
                <p>
                    <label>Login: </label>
                    <input  type="text" name="login" value=""
                            class="w3-input w3-border"
                            placeholder="Your login..."/>
                </p>
            </div>
            <div class="w3-row-padding">
                <p>
                    <label>Password: </label>
                    <input  class="w3-input w3-border"
                            type="password" name="password"
                            value="" placeholder="Your password..."/>
                </p>
            </div>
            <br/>
            <div class="w3-row-padding">
                ${errorLoginPassMessage}
                <br/>
                ${wrongAction}
                <br/>
                ${nullPage}
                <br/>
            </div>
            <div class="w3-center">
                <input type="submit" value="Register" class="w3-button w3-red w3-margin-right" style="width: 30%"/>
                <a href="http://localhost:8080/JAVA_LR11_12_war_exploded/index.jsp" class="w3-bar-item w3-button w3-hover-none w3-border-green w3-bottombar w3-hover-border-black w3-margin-left">Login</a>
            </div>
        </form>
    </div>
    <div class="w3-display-bottommiddle">
        <c:import url="/views/footer.html"/>
    </div>
</div>
</body>
</html>
