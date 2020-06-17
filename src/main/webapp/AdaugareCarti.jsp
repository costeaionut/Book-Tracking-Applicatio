<%@ page import="Classes.Carti" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: coni9
  Date: 22.05.2020
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/cartiCititePage.css">
    <title>Title</title>
</head>
<body>
<h2>Carti disponibile:</h2>
<%
    ArrayList<Carti> _carti = Carti.selectAllEntries();
    out.print("<div class=\"table-wrapper\">");
    out.print("<table style=\"width:100%\", class=\"fl-table\"> <tr> <th>Titlu</th> <th>Autor</th> <th>Nr. Pagini</th> </tr>");
    for (Carti c:
         _carti)
    {
        out.println("<tr> <td>" + c.getTitlu() + " </td> <td> " + c.getAutor() + "</td> <td>" + c.getNrPagini() + "</td> </tr> <br>");
    }
    out.print("</table></div>");
%>

<form method="post", action = "/CartiCitite">
    <%  out.println("<input hidden readonly type=\"text\" id=\"user\" name=\"user\" value="+ session.getAttribute("numeUtilizator") + "><br>"); %>
    <label for = "adaugareCarte"> Carte de adaugat: </label> <br>
    <input type="text", id = "adaugareCarte", name = "carte", align = "right"><br>
    <input type="submit", value = "Adauga carte">
</form>

</body>
</html>
