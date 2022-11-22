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
        "/peliculasVistas/todas", "/peliculasVistas/vistas", "/peliculasVistas/noVistas", "/peliculasVistas/comentario", "/peliculasVistas/editarComentario", "/peliculasVistas/nuevoComentario","/peliculasVistas/insertComentario", "/peliculasVistas/updateComentario"})

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
                case "/peliculasVistas/comentario":
                    comentario(request,response);
                    break;
                case "/peliculasVistas/nuevoComentario":
                    showNewFormComentario(request, response);
                    break;
                case "/peliculasVistas/editarComentario":
                    showEditFormComentario(request, response);
                    break;
                case "/peliculasVistas/insertComentario":
                    insertComentario(request, response);
                    break;
                case "/peliculasVistas/updateComentario":
                    updateComentario(request, response);
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
            throws SQLException, ServletException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioSession");
        String carnet = usuario.getCarnet();

        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));

        PeliculaVista pv = peliculasVistasDAO.select(carnet, idpelicula);
        if(pv != null){
            response.sendRedirect("editarComentario");
        }else {
            response.sendRedirect("nuevoComentario");
            //response.sendRedirect("showEditFormComentario");
        }
    }

    private void showNewFormComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioSession");
        String carnet = usuario.getCarnet();

        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        PeliculaVista comentario = peliculasVistasDAO.select(carnet, idpelicula);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Catalogo/create.jsp");
        request.setAttribute("comentario", comentario);
        dispatcher.forward(request, response);
    }
    private void showEditFormComentario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioSession");
        String carnet = usuario.getCarnet();

        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        PeliculaVista comentario = peliculasVistasDAO.select(carnet, idpelicula);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Catalogo/create.jsp");
        request.setAttribute("comentario", comentario);
        dispatcher.forward(request, response);

    }
    private void insertComentario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioSession");
        String carnet = usuario.getCarnet();
        //All the stuff
        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        String comentario = request.getParameter("comentario");
        int calificacion = Integer.parseInt(request.getParameter("calificacion"));

        PeliculaVista peliculaV = new PeliculaVista(idpelicula, carnet, comentario, calificacion);
        peliculasVistasDAO.comentar(peliculaV);
        response.sendRedirect("todas");
    }
    private void updateComentario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        //get session data
        HttpSession session = request.getSession();
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioSession");
        String carnet = usuario.getCarnet();
        //All the stuff
        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        String comentario = request.getParameter("comentario");
        int calificacion = Integer.parseInt(request.getParameter("calificacion"));

        PeliculaVista peliculaV = new PeliculaVista(idpelicula, carnet, comentario, calificacion);
        peliculasVistasDAO.comentarUpdate(peliculaV);
        response.sendRedirect("todas");
    }
}
