<%--
  Created by IntelliJ IDEA.
  User: coni9
  Date: 20.05.2020
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet", href="css/user.css">
</head>
<body>

<%
        out.println("<h1>Bun venit " + session.getAttribute("numeUtilizator")+ "</h1>");
%>

<form method = "get", action = "/CartiCitite">
    <input type = "submit", value="Vizualizeaza cartile citite">
</form>

<form method = "get", action = "/InCursDeCitire">
    <input type = "submit", value="Vizualizeaza carti in curs de citire">
</form>

<form method = "get", action = "/Prieteni">
    <input type = "submit", value="Vezi prieteni">
</form>

</body>
</html>
