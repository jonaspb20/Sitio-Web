package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String usuario =
                request.getParameter("usuario");

        String password =
                request.getParameter("password");

        // VALIDACION SIMPLE

        if(usuario.equals("admin")
                && password.equals("123")){

            // CREAR SESION

            HttpSession sesion =
                    request.getSession();

            sesion.setAttribute("usuario", usuario);

            // REDIRECCION

            response.sendRedirect(
                    "views/dashboard.jsp"
            );

        }else{

            // ERROR LOGIN

            request.setAttribute(
                    "error",
                    "Usuario o contraseña incorrectos"
            );

            request.getRequestDispatcher(
                    "views/login.jsp"
            ).forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(
                "views/login.jsp"
        );
    }
}