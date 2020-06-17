<%@ page import="Classes.Carti" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Classes.Carti_citite" %><%--
  Created by IntelliJ IDEA.
  User: coni9
  Date: 24.05.2020
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Carti in curs de citire</title>
    <link rel="stylesheet" href="css/cartiCititePage.css">
</head>
<body>

<%
    ArrayList<Carti> carti = new ArrayList<Carti>();
    ArrayList<Carti_citite> carti_citite = new ArrayList<Carti_citite>();
    carti = Carti.selectAllEntries();
    carti_citite =Carti_citite.selectEntry((String) session.getAttribute("numeUtilizator"));
    out.print("<div class=\"table-wrapper\">");
    out.print("<table style=\"width:100%\", class=\"fl-table\"> <tr> <th>Titlu</th> <th>Autor</th> <th>Progres</th> " +
            "<th>Data Inceput</th> <th>Recenzie</th> </tr>");
    for (Carti c: carti)
    {
        for(Carti_citite cc : carti_citite)
        {
            if(cc.getProgres() < 100)
            {if(c.getIdCarte() == cc.getIdCarteCitita())
            {
                out.println("<tr> <td>" + c.getTitlu() + "</td>" + "<td>" + c.getAutor() + "</td>" + "<td>" + cc.getProgres() + "</td>"
                        + "<td>" + cc.getDataInceput() + "</td>" + "<td>" + cc.getRecenzie() + "</td> </tr>");
                out.print("<br>");
            }
            }
        }
    }
%>

</body>
</html>
