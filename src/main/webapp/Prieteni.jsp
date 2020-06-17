<%@ page import="java.util.ArrayList" %>
<%@ page import="Classes.Prieteni" %><%--
  Created by IntelliJ IDEA.
  User: coni9
  Date: 23.05.2020
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ArrayList<Prieteni> urmariri = Prieteni.selectUrmarii((String) session.getAttribute("numeUtilizator"));
    if(urmariri.isEmpty()){
        out.print("<h3 font-weight: bold>Persoane pe care le urmaresti:</h3> <br>");
        out.print("Singurul tau prieteni adevarat esti doar Tu <3");
        ///Poza ciu mana cu like si love
    }
    else {
        out.print("<h3 font-weight: bold>Persoane pe care le urmaresti</h3> <br>");
        for (Prieteni p : urmariri) {
            out.print(p.getNumeUtilizator2() + "<br>");
        }
    }
%>

<%
    ArrayList<Prieteni> urmaritori = Prieteni.selectUrmaritori((String) session.getAttribute("numeUtilizator"));
    if(urmaritori.isEmpty()){
        out.print("<h3 font-weight: bold>Persoane pe care le urmaresti:</h3> <br>");
        out.print("Singurul tau urmaritor este domnul nostru Iisus ");
    }
    else {
        out.print("<h3 font-weight: bold>Persoane care te urmaresc</h3> <br>");
        for (Prieteni p : urmaritori) {
            out.print(p.getNumeUtilizator1() + "<br>");
        }
    }
%>

<form method="post", action = "/Prieteni">
    <%  out.println("<input hidden readonly type=\"text\" id=\"user\" name=\"user\" value="+ session.getAttribute("numeUtilizator") + "><br>"); %>
    <label for = "adaugarePrieteni"> Utilizatorul de urmarit: </label> <br>
    <input type="text", id = "adaugarePrieteni", name = "prieten", align = "right"><br>
    <input type="submit", value = "Urmareste">
</form>

</body>
</html>
