package Servlet;

import Classes.Carti;
import Classes.Carti_citite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;

@WebServlet("/CartiCitite")
public class CartiCitite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/CartiCitite.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titlu = req.getParameter("carte");
        int idCarteAdaugat = Carti.selectEntryByTitle(titlu).getIdCarte();
        String user = req.getParameter("user");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        Carti_citite deAdaugat
                = new Carti_citite(idCarteAdaugat, user, 0,
                "Nu exista recenzie", 0, formatter.format(date).toString(), formatter.format(date).toString());
        deAdaugat.insertTable();
        req.getRequestDispatcher("/CartiCitite.jsp").forward(req,resp);
    }

}
