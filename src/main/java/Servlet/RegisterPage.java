package Servlet;

import Classes.Utilizatori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String line = req.getReader().readLine();
        String firstName = line.split("&")[0].split("=")[1];
        String lastName = line.split("&")[1].split("=")[1];
        String username = line.split("&")[2].split("=")[1];
        String parola = line.split("&")[3].split("=")[1];
        String email = line.split("&")[4].split("=")[1];

        Utilizatori user = new Utilizatori(username,firstName,lastName,parola, URLDecoder.decode(email));
        user.insertTable();
        HttpSession session = req.getSession(true);
        session.setAttribute("numeUtilizator", user.getNumeUtilizator());
        req.getRequestDispatcher("UserPage.jsp").forward(req,resp);
    }
}
