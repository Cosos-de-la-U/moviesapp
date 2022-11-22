package Controller;

import DAO.CategoriaDAO;
import Model.Categoria;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "categoria", urlPatterns = {
        "/categoria/nuevaCategoria","/categoria/insertarCategoria","/categoria/borrarCategoria","/categoria/editarCategoria","/categoria/actualizarCategoria","/categoria/listarCategoria"})
public class CategoriaController extends HttpServlet {
    private CategoriaDAO categoriaDao;

    public void init() {
        categoriaDao = new CategoriaDAO();
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
                case "/categoria/nuevaCategoria":
                    showNewFormCategoria(request, response);
                    break;
                case "/categoria/insertarCategoria":
                    insertCategoria(request, response);
                    break;
                case "/categoria/borrarCategoria":
                    deleteCategoria(request, response);
                    break;
                case "/categoria/editarCategoria":
                    showEditFormCategoria(request, response);
                    break;
                case "/categoria/actualizarCategoria":
                    updateCategoria(request, response);
                    break;
                case "/categoria/listarCategoria":
                    listCategoria(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCategoria(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Categoria> listaCategoria = categoriaDao.selectAll();
        request.setAttribute("listaCategoria", listaCategoria);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Categoria/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Categoria/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormCategoria(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idcategoria"));
        Categoria existingCategoria = categoriaDao.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Categoria/create.jsp");
        request.setAttribute("categoria", existingCategoria);
        dispatcher.forward(request, response);

    }

    private void insertCategoria(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nombreCategoria = request.getParameter("categoria");

        Categoria newCategoria = new Categoria(nombreCategoria);
        categoriaDao.insert(newCategoria);
        response.sendRedirect("listarCategoria");
    }

    private void updateCategoria(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
        String nombreCategoria = request.getParameter("categoria");

        Categoria newCategoria = new Categoria(idCategoria, nombreCategoria);
        categoriaDao.edit(newCategoria);
        response.sendRedirect("listarCategoria");
    }

    private void deleteCategoria(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idcategoria"));
        categoriaDao.delete(id);
        response.sendRedirect("listarCategoria");
    }
}
