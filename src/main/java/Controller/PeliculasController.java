package Controller;

import DAO.CategoriaDAO;
import DAO.PeliculasDAO;
import Model.Categoria;
import Model.Peliculas;
import Model.ViewModel.PeliculasViewModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "peliculas", urlPatterns = {
        "/peliculas/nuevaPeliculas","/peliculas/insertarPeliculas","/peliculas/borrarPeliculas","/peliculas/editarPeliculas","/peliculas/actualizarPeliculas","/peliculas/listarPeliculas"})
public class PeliculasController extends HttpServlet {
    private PeliculasDAO peliculasDao;
    private CategoriaDAO categoriaDAO;

    public void init() {
        peliculasDao = new PeliculasDAO();
        categoriaDAO = new CategoriaDAO();
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
                case "/peliculas/nuevaPeliculas":
                    System.out.println("Not done");
                    showNewFormPeliculas(request, response);
                    break;
                case "/peliculas/insertarPeliculas":
                    insertPeliculas(request, response);
                    break;
                case "/peliculas/borrarPeliculas":
                    deletePeliculas(request, response);
                    break;
                case "/peliculas/editarPeliculas":
                    showEditFormPeliculas(request, response);
                    break;
                case "/peliculas/actualizarPeliculas":
                    updatePeliculas(request, response);
                    break;
                case "/peliculas/listarPeliculas":
                    listPeliculas(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<PeliculasViewModel> listaPeliculas = peliculasDao.selectAll();
        List<Categoria> listaCategorias = categoriaDAO.selectAll();
        request.setAttribute("listaPeliculas", listaPeliculas);
        request.setAttribute("listaCategorias", listaCategorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Peliculas/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> listarCategorias = categoriaDAO.selectAll();
        request.setAttribute("listaCategorias", listarCategorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Peliculas/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idpelicula"));
        PeliculasViewModel existingPeliculas = peliculasDao.select(id);
        List<Categoria> listarCategorias = categoriaDAO.selectAll();
        request.setAttribute("peliculas", existingPeliculas);
        request.setAttribute("listaCategorias", listarCategorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Peliculas/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void insertPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String nombreIngles = request.getParameter("nombreIngles");
        int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
        int yearp = Integer.parseInt(request.getParameter("yearp"));
        int duracion = Integer.parseInt(request.getParameter("duracion"));

        Peliculas newPeliculas = new Peliculas(nombre, nombreIngles, idcategoria,yearp, duracion);
        peliculasDao.insert(newPeliculas);
        response.sendRedirect("listarPeliculas");
    }

    private void updatePeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idPeliculas = Integer.parseInt(request.getParameter("idpelicula"));
        String nombre = request.getParameter("nombre");
        String nombreIngles = request.getParameter("nombreIngles");
        int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
        int yearp = Integer.parseInt(request.getParameter("yearp"));
        int duracion = Integer.parseInt(request.getParameter("duracion"));

        Peliculas newPeliculas = new Peliculas(idPeliculas, nombre, nombreIngles, idCategoria ,yearp, duracion);
        peliculasDao.edit(newPeliculas);
        response.sendRedirect("listarPeliculas");
    }

    private void deletePeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idpelicula"));
        peliculasDao.delete(id);
        response.sendRedirect("listarPeliculas");
    }
}
