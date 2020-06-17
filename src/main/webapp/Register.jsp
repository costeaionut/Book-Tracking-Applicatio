<%--
  Created by IntelliJ IDEA.
  User: coni9
  Date: 20.05.2020
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post", action="/RegisterPage", align = "center">
    <label for = "firstName"> First name: </label><br>
    <input type="text", id = "firstName", name = "firstName"><br>
    <label for = "lastName"> Last Name:   </label> <br>
    <input type="text", id = "lastName", name = "Parola"><br>
    <label for = "username"> Username:   </label> <br>
    <input type="text", id = "username", name = "username"><br>
    <label for = "parola"> Parola:  </label> <br>
    <input type="text", id = "parola", name = "Parola"><br>
    <label for = "email"> Email:  </label> <br>
    <input type="text", id = "email", name = "email"><br>
    <input type="submit", value = "Submit">
</form>

</body>
</html>
