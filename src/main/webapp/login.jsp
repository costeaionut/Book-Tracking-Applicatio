
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina de login</title>
    <link rel="stylesheet" href="css/loginPage.css">
</head>
<body>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>

<form method="post", action="/Login", align = "center", to>
    <label for = "user" > <strong>Nume de utilizator:</strong> </label><br>
    <input type="text", id = "user", name = "name", align = "right"><br>
    <label for = "parola"><strong> Parola: </strong> </label> <br>
    <input type="password", id = "parola", name = "Parola", align = "right">
    <br>
    <br>
    <input id="submit", type="submit", value = "Login">
    <br>
</form>

<form method="get", action="/RegisterPage", align = "center">
    <input type="submit", value = "Register">
</form>

    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>
    <br>    <br>

</body>
</html>
