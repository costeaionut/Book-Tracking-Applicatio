package Servlet;

import Classes.Utilizatori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class LoginPage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String line = req.getReader().readLine();
        String nume = new String();
        String parola = new String();
        nume = line.split("&")[0];
        parola = line.split("&")[1];

        nume = nume.split("=")[1];
        parola = parola.split("=")[1];

        Utilizatori user = new Utilizatori();
        user = Utilizatori.selectEntry(nume);

        System.out.println(user.getParola());
        if(parola.equals(user.getParola()))
        {
            HttpSession session = req.getSession(true);
            session.setAttribute("numeUtilizator", user.getNumeUtilizator());
            req.getRequestDispatcher("UserPage.jsp").forward(req,resp);
        }
    }
}
