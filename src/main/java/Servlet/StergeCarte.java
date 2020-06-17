package Servlet;

import Classes.Carti;
import Classes.Carti_citite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StergeCarte")
public class StergeCarte extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("StergeCarti.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titlu = req.getParameter("carte");
        String user = req.getParameter("user");
        int id_carte = Carti.selectEntryByTitle(titlu).getIdCarte();
        Carti_citite.deleteEntry(id_carte, user);
        req.getRequestDispatcher("/CartiCitite.jsp").forward(req,resp);
    }
}
