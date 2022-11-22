package DAO;


import Interfaces.iCategoria;
import Model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qCategoria.*;


public class CategoriaDAO implements iCategoria {

    @Override
    public Categoria select(int id) {
        Categoria categoria = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORIA);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idCategoria = rs.getInt("idcategoria");
                String nombreCategoria = rs.getString("categoria");
                categoria = new Categoria(idCategoria, nombreCategoria);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoria;
    }

    @Override
    public List<Categoria> selectAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Categoria> categoria = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIA);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idCategoria = rs.getInt("idcategoria");
                String nombreCategoria = rs.getString("categoria");
                categoria.add(new Categoria(idCategoria, nombreCategoria));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoria;
    }

    @Override
    public void insert(Categoria categoria) throws SQLException {
        System.out.println(INSERT_CATEGORIA);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORIA)) {
            preparedStatement.setString(1, categoria.getCategoria());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Categoria categoria) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORIA);) {
            System.out.println("updated Categoria:"+statement);
            statement.setString(1, categoria.getCategoria());
            statement.setInt(2, categoria.getIdcategoria());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORIA);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
