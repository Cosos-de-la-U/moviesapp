package Routes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "routes", urlPatterns = {"/welcome", "/401", "/404"})
public class RoutesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/welcome":
                dispatch(request, response, "/View/Shared/welcome.jsp");
                break;
            case "/401":
                dispatch(request, response, "/View/Shared/401.jsp");
                break;
            case "/404":
                dispatch(request, response, "/View/Shared/404.jsp");
                break;
        }
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
