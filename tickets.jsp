package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String u = req.getParameter("usuario");
        String p = req.getParameter("password");

        if (u.equals("admin") && p.equals("123")) {
            resp.sendRedirect("views/menu.jsp");
        } else {
            resp.sendRedirect("views/login.jsp?error=1"); // 🔥 CORREGIDO
        }
    }
}