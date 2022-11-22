package DAO;


import Interfaces.iPeliculas;
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
import static DB.Queries.qPeliculas.*;


public class PeliculasDAO implements iPeliculas {

    @Override
    public PeliculasViewModel select(int id) {
        PeliculasViewModel peliculas = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PELICULAS_VISTA);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idpelicula = rs.getInt("idpelicula");
                String nombre = rs.getString("nombre");
                String nombreIngles = rs.getString("nomb_ingles");
                int idcategoria = rs.getInt("idcategoria");
                String categoria = rs.getString("categoria");
                int yearp = rs.getInt("yearp");
                int duracion = rs.getInt("duracion");
                peliculas = new PeliculasViewModel(idpelicula, nombre, nombreIngles, idcategoria, categoria, yearp, duracion);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return peliculas;
    }

    @Override
    public List<PeliculasViewModel> selectAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<PeliculasViewModel> peliculas = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PELICULAS_VISTA_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idpelicula = rs.getInt("idpelicula");
                String nombre = rs.getString("nombre");
                String nombreIngles = rs.getString("nomb_ingles");
                int idcategoria = rs.getInt("idcategoria");
                String categoria = rs.getString("categoria");
                int yearp = rs.getInt("yearp");
                int duracion = rs.getInt("duracion");
                peliculas.add( new PeliculasViewModel(idpelicula, nombre, nombreIngles, idcategoria, categoria, yearp, duracion));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return peliculas;
    }

    @Override
    public void insert(Peliculas peliculas) throws SQLException {
        System.out.println(INSERT_PELICULAS);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PELICULAS_FUNCTION)) {
            preparedStatement.setString(1, peliculas.getNombre());
            preparedStatement.setString(2, peliculas.getNomb_ingles());
            preparedStatement.setInt(3, peliculas.getIdcategoria());
            preparedStatement.setInt(4, peliculas.getYearp());
            preparedStatement.setInt(5, peliculas.getDuracion());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Peliculas peliculas) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PELICULAS);) {
            System.out.println("updated Peliculas:"+statement);
            statement.setInt(1, peliculas.getIdpelicula());
            statement.setString(2, peliculas.getNombre());
            statement.setString(3, peliculas.getNomb_ingles());
            statement.setInt(4, peliculas.getIdcategoria());
            statement.setInt(5, peliculas.getYearp());
            statement.setInt(6, peliculas.getDuracion());
            rowUpdated = statement.execute();
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PELICULAS);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
