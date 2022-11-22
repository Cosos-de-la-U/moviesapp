package Controller;

import DAO.FotosDAO;
import DAO.PeliculasDAO;
import Model.Fotos;
import Model.Peliculas;
import Model.ViewModel.FotosViewModel;
import Model.ViewModel.PeliculasViewModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "fotos", urlPatterns = {
        "/fotos/nuevaFotos","/fotos/insertarFotos","/fotos/borrarFotos","/fotos/editarFotos","/fotos/actualizarFotos","/fotos/listarFotos","/fotos/mostrarFotos"})
@MultipartConfig(maxFileSize = 16177215) //Up to 16MB photos
public class FotosController extends HttpServlet {
    private FotosDAO fotosDao;
    private PeliculasDAO peliculasDAO;

    public void init() {
        fotosDao = new FotosDAO();
        peliculasDAO = new PeliculasDAO();
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
                case "/fotos/nuevaFotos":
                    System.out.println("Not done");
                    showNewFormFotos(request, response);
                    break;
                case "/fotos/insertarFotos":
                    insertFotos(request, response);
                    break;
                case "/fotos/borrarFotos":
                    deleteFotos(request, response);
                    break;
                case "/fotos/editarFotos":
                    showEditFormFotos(request, response);
                    break;
                case "/fotos/actualizarFotos":
                    updateFotos(request, response);
                    break;
                case "/fotos/listarFotos":
                    listFotos(request, response);
                    break;
                case "/fotos/mostrarFotos":
                    showFotos(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFotos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<FotosViewModel> listaFotos = fotosDao.selectAll();
        request.setAttribute("listaFotos", listaFotos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Fotos/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormFotos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PeliculasViewModel> existingPeliculas = peliculasDAO.selectAll();
        request.setAttribute("peliculas", existingPeliculas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Fotos/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormFotos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idfoto"));
        FotosViewModel existingFotos = fotosDao.select(id);
        List<PeliculasViewModel> existingPeliculas = peliculasDAO.selectAll();
        request.setAttribute("fotos", existingFotos);
        request.setAttribute("peliculas", existingPeliculas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Fotos/create.jsp");
        dispatcher.forward(request, response);

    }

    private void insertFotos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        String primera = (request.getParameter("primera") != null ? request.getParameter("primera") : "n");
        //Photo
        InputStream foto = null;
        Part archivo = request.getPart("foto");
        if (archivo != null){
            foto = archivo.getInputStream();
        };

        Fotos newFotos = new Fotos(idpelicula, foto, primera);
        fotosDao.insert(newFotos);
        response.sendRedirect("listarFotos");
    }

    private void updateFotos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idfoto = Integer.parseInt(request.getParameter("idfoto"));
        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        String primera = (request.getParameter("primera") != null ? request.getParameter("primera") : "n");
        //Photo
        InputStream foto = null;
        Part archivo = request.getPart("foto");
        if (archivo != null){
            foto = archivo.getInputStream();
            Fotos newFotos = new Fotos(idfoto, idpelicula, foto, primera);
            fotosDao.edit(newFotos);
            response.sendRedirect("listarFotos");
        }
    }

    private void deleteFotos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idfoto"));
        fotosDao.delete(id);
        response.sendRedirect("listarFotos");
    }

    private void showFotos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idfoto = Integer.parseInt(request.getParameter("idfoto"));
        int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
        fotosDao.show(idfoto, idpelicula);
        response.sendRedirect("listarFotos");
    }
}
