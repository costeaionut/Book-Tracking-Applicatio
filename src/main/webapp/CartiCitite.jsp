<%@ page import="java.util.ArrayList" %>
<%@ page import="Classes.Carti" %>
<%@ page import="Classes.Carti_citite" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/cartiCititePage.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ArrayList<Carti> carti = new ArrayList<Carti>();
    ArrayList<Carti_citite> carti_citite = new ArrayList<Carti_citite>();
    carti = Carti.selectAllEntries();
    carti_citite =Carti_citite.selectEntry((String) session.getAttribute("numeUtilizator"));
    out.print("<div class=\"table-wrapper\">");
    out.print("<table style=\"width:100%\", class=\"fl-table\"> <tr> <th>Titlu</th> <th>Autor</th> <th>Progres</th> " +
            "<th>Data Inceput</th> <th>Data Final</th> <th>Recenzie</th> </tr>");
    for (Carti c: carti)
    {
        for(Carti_citite cc : carti_citite)
        {
            if(c.getIdCarte() == cc.getIdCarteCitita())
            {
                if(cc.getDataInceput().equals(cc.getDataSfarsit()) )
                {
                    out.println("<tr> <td>" + c.getTitlu() + "</td>" + "<td>" + c.getAutor() + "</td>" + "<td>" + cc.getProgres() + "</td>"
                            + "<td>" + cc.getDataInceput() + "</td>" + "<td> - </td>" + "<td>" + cc.getRecenzie() + "</td> </tr>");
                }
                else
                    {
                        out.println("<tr> <td>" + c.getTitlu() + "</td>" + "<td>" + c.getAutor() + "</td>" + "<td>" + cc.getProgres() + "</td>"
                                + "<td>" + cc.getDataInceput() + "</td>" + "<td>" + cc.getDataSfarsit() + "</td>" + "<td>" + cc.getRecenzie() + "</td> </tr>");
                    }
                out.print("<br>");
            }
        }
    }
    out.print("</table></div>");
%>

<form action="/AdaugareCarti.jsp", align = "center">
    <input type="submit", value = "Adaugare carte">
</form>

<form method = "get", action = "/EditareCarti", align = "center">
    <input type="submit", value = "Editare carte">
</form>

<form method = "get", action = "/StergeCarte", align = "center">
    <input type="submit", value = "Sterge carte">
</form>

<form method = "post", action = "/Recenzie", align = "center">
    <%  out.println("<input hidden readonly type=\"text\" id=\"user\" name=\"user\" value="+ session.getAttribute("numeUtilizator") + "><br>"); %>
    <label for = "recenzie"> Introdu titlul cartii: </label> <br>
    <input type="text", id = "titlu", name = "titlu", align = "right"><br>
    <label for = "recenzie"> Recenzie: </label> <br>
    <input type="text" , id = "recenzie", name = "recenzie", align = "right"><br>
    <label for = "nota"> Nota: </label> <br>
    <input type="number", id = "nota", name = "nota", align = "right"><br>
    <input type="submit", value = "Adauga recenzie si nota">
</form>

</body>
</html>
