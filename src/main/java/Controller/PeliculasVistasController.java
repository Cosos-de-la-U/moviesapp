package Controller;

import DAO.CategoriaDAO;
import DAO.PeliculasDAO;
import DAO.PeliculasVistasDAO;
import Model.*;
import Model.ViewModel.PeliculasViewModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "peliculasVistas", urlPatterns = {
        "/peliculasVistas/todas", "/peliculasVistas/vistas", "/peliculasVistas/noVistas", "/peliculasVistas/comentar"})

public class PeliculasVistasController extends HttpServlet {
    private PeliculasVistasDAO peliculasVistasDAO;

    public void init() {
        peliculasVistasDAO = new PeliculasVistasDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();


        try {
            switch (action) {
                case "/peliculasVistas/todas":
                    listTodas(request, response);
                    break;
                case "/peliculasVistas/vistas":
                    listVistas(request,response);
                    break;
                case "/peliculasVistas/noVistas":
                    listNoVistas(request,response);
                    break;
                case "/peliculasVistas/comentar":
                    comentario(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void listTodas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<PeliculasViewModel> listaPeliculasVistas = peliculasVistasDAO.selectTodas();
        request.setAttribute("listaPeliculasVistas", listaPeliculasVistas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Catalogo/index.jsp");
        dispatcher.forward(request, response);
    }

    private void listVistas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

    }

    private void listNoVistas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

    }

    private void comentario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //get session data
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioSession");
        String carnet = usuario.getCarnet();
        //All the stuff
        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        int calificacion = Integer.parseInt(request.getParameter("calificacion"));
        String comentario = request.getParameter("comentario");

        PeliculaVista peliculaV = new PeliculaVista(idpelicula, carnet, comentario, calificacion);
        peliculasVistasDAO.comentar(peliculaV);
        response.sendRedirect("listarPeliculas");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Usuarios/create.jsp");
        dispatcher.forward(request, response);
    }


}
