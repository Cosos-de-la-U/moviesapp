package Controller;

import DAO.LoginDAO;
import Model.Usuarios;
import Enum.SesionEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static Helpers.SessionChecker.checkSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private LoginDAO loginDAO;

    public void init() {
        loginDAO = new LoginDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (checkSession(session) == SesionEnum.NULA) {
            try {
                Usuarios usuarioSession = null;
                //Get session
                usuarioSession = loginDAO.logIn( request.getParameter("carnet"), request.getParameter("clave"));
                session.setAttribute("usuarioSession", usuarioSession);
                response.sendRedirect("welcome");
            } catch (SQLException e) {
                //If it fails send msg
                boolean errorLogin = true;
                request.setAttribute("errorLogin", errorLogin);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        }
        //If there is an available user
        response.sendRedirect("welcome");

    }

}
