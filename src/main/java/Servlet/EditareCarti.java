package Servlet;

import Classes.Carti;
import Classes.Carti_citite;
import Classes.Utilizatori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/EditareCarti")
public class EditareCarti extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("EditareCarti.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titlu = req.getParameter("carte");
        int progres = Integer.parseInt(req.getParameter("progres"));
        String user = req.getParameter("user");
        Carti_citite _carte = Carti_citite.selectEntry(Carti.selectEntryByTitle(titlu).getIdCarte(), user);
        if(progres == 100)
        {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            _carte.setDataSfarsit(formatter.format(date).toString());
        }
        Carti_citite.deleteEntry(_carte.getIdCarteCitita(), _carte.getNumeUtilizator());
        _carte.setProgres(progres);
        _carte.insertTable();

        req.getRequestDispatcher("/CartiCitite").forward(req,resp);
    }
}