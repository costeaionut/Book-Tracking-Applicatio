package Servlet;

import Classes.Prieteni;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Prieteni")
public class PrieteniServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Prieteni.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String prieten = req.getParameter("prieten");
        Prieteni pr = new Prieteni(user, prieten);
        pr.insertTable();
        req.getRequestDispatcher("Prieteni.jsp").forward(req,resp);
    }
}
