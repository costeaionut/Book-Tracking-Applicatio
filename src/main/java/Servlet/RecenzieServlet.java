package Servlet;

import Classes.Carti;
import Classes.Carti_citite;
import Classes.Prieteni;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Recenzie")
public class RecenzieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titlu = req.getParameter("titlu");
        String recenzie = req.getParameter("recenzie");
        int nota = Integer.parseInt(req.getParameter("nota"));
        String user = req.getParameter("user");

        Carti_citite _carte = Carti_citite.selectEntry(Carti.selectEntryByTitle(titlu).getIdCarte(), user);
        Carti_citite.deleteEntry(_carte.getIdCarteCitita(), _carte.getNumeUtilizator());
        _carte.setNota(nota);
        _carte.setRecenzie(recenzie);
        _carte.insertTable();
        req.getRequestDispatcher("/CartiCitite").forward(req,resp);
    }
}
