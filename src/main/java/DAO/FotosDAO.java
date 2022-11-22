package DAO;


import Interfaces.iFotos;
import Model.Fotos;
import Model.ViewModel.FotosViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qFotos.*;


public class FotosDAO implements iFotos {

    @Override
    public FotosViewModel select(int id) {
        FotosViewModel fotos = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOTOS_VIEW);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idfoto = rs.getInt("idfoto");
                String nombre = rs.getString("nombre");
                int idpelicula = rs.getInt("idpelicula");
                byte[] foto = rs.getBytes("foto");
                String primera = rs.getString("primera");
                fotos = new FotosViewModel(idfoto, nombre, idpelicula, foto, primera);
            }
        } catch (SQLException | IOException e) {
            printSQLException((SQLException) e);
        }
        return fotos;
    }

    @Override
    public List<FotosViewModel> selectAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<FotosViewModel> fotos = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOTOS_VIEW);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idfoto = rs.getInt("idfoto");
                String nombre = rs.getString("nombre");
                int idpelicula = rs.getInt("idpelicula");
                byte[] foto = rs.getBytes("foto");
                String primera = rs.getString("primera");
                fotos.add(new FotosViewModel(idfoto, nombre, idpelicula, foto, primera));
            }
        } catch (SQLException | IOException e) {
            printSQLException((SQLException) e);
        }
        return fotos;
    }

    @Override
    public void insert(Fotos fotos) throws SQLException {
        System.out.println(INSERT_FOTOS);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FOTOS)) {
            preparedStatement.setInt(1, fotos.getIdpelicula());
            preparedStatement.setBinaryStream(2, fotos.getFoto());
            preparedStatement.setString(3, fotos.getPrimera());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Fotos fotos) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FOTOS);) {
            System.out.println("updated Fotos:"+statement);
            statement.setInt(1, fotos.getIdpelicula());
            statement.setBinaryStream(2, fotos.getFoto());
            statement.setString(3, fotos.getPrimera());
            statement.setInt(4, fotos.getIdfoto());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FOTOS);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean show(int idfoto, int idpelicula) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FOTOS_PRIMERA)) {
            statement.setInt(1, idfoto);
            statement.setInt(2, idpelicula);
            rowUpdated = statement.execute();
        }
        return rowUpdated;
    }
}
