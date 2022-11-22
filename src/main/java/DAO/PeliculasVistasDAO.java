package DAO;


import Interfaces.iPeliculas;
import Model.Categoria;
import Model.Fotos;
import Model.PeliculaVista;
import Model.Peliculas;
import Model.ViewModel.PeliculasViewModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qCategoria.SELECT_CATEGORIA;
import static DB.Queries.qFotos.INSERT_FOTOS;
import static DB.Queries.qPeliculas.SELECT_PELICULAS_VISTA;
import static DB.Queries.qPeliculasVistas.*;


public class PeliculasVistasDAO {

    public List<PeliculasViewModel> selectTodas() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<PeliculasViewModel> peliculas = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATALOGO_VISTA_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idpelicula = rs.getInt("idpelicula");
                String nombre = rs.getString("nombre");
                String nombreIngles = rs.getString("nomb_ingles");
                byte[] foto = rs.getBytes("foto");
                String categoria = rs.getString("categoria");
                int yearp = rs.getInt("yearp");
                int duracion = rs.getInt("duracion");
                peliculas.add( new PeliculasViewModel(idpelicula, nombre, nombreIngles, foto, categoria, yearp, duracion));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return peliculas;
    }

    public PeliculaVista select(String carnet, int idpelicula) {
        PeliculaVista peliculavista = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATALOGO);) {
            preparedStatement.setString(1, carnet);
            preparedStatement.setInt(2, idpelicula);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idpeliculavista = rs.getInt("idpeliculavista");
                int idpeliculaV = rs.getInt("idpelicula");
                String carnetV = rs.getString("carnet");
                String comentario = rs.getString("comentario");
                int calificacion = rs.getInt("calificacion");
                peliculavista = new PeliculaVista(idpeliculavista, idpeliculaV, carnetV, comentario, calificacion);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return peliculavista;
    }

    public void comentar(PeliculaVista comentario) throws SQLException {
        System.out.println(INSERT_COMENTARIO);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMENTARIO)) {
            preparedStatement.setInt(1, comentario.getIdpelicula());
            preparedStatement.setString(2, comentario.getCarnet());
            preparedStatement.setString(3, comentario.getComentario());
            preparedStatement.setInt(4, comentario.getCalificacion());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void comentarUpdate(PeliculaVista comentario) throws SQLException {
        System.out.println(INSERT_COMENTARIO);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMENTARIO)) {
            preparedStatement.setInt(1, comentario.getIdpelicula());
            preparedStatement.setString(2, comentario.getCarnet());
            preparedStatement.setString(3, comentario.getComentario());
            preparedStatement.setInt(4, comentario.getCalificacion());
            preparedStatement.setString(5, comentario.getCarnet());
            preparedStatement.setInt(6, comentario.getIdpelicula());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
