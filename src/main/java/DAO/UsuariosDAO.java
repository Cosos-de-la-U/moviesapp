package DAO;

import Interfaces.iUsuarios;
import Model.Usuarios;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qUsuarios.*;
import static Helpers.generateCarnet.createCarnet;

public class UsuariosDAO implements iUsuarios {

    @Override
    public Usuarios select(String carnetUser) throws SQLException {
        Usuarios usuarios = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIOS)) {
            //Create statement
            preparedStatement.setString(1, carnetUser);
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                String carnet = rs.getString("carnet");
                String nom_usuario = rs.getString("nom_usuario");
                String ape_usuario = rs.getString("ape_usuario");
                String tipo = rs.getString("tipo");
                String telcasa = rs.getString("telcasa");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String estado = rs.getString("estado");
                String clave = rs.getString("clave");
                int acessosistemas = rs.getInt("acessosistemas");
                int esadministrador = rs.getInt("esadministrador");
                //We create the object
                usuarios = new Usuarios(carnet, nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, acessosistemas, esadministrador);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuarios;
    }

    @Override
    public List<Usuarios> selectAll() throws SQLException {
        List<Usuarios> usuarios = new ArrayList<>();
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS)) {
            //Create statement
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                String carnet = rs.getString("carnet");
                String nom_usuario = rs.getString("nom_usuario");
                String ape_usuario = rs.getString("ape_usuario");
                String tipo = rs.getString("tipo");
                String telcasa = rs.getString("telcasa");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String estado = rs.getString("estado");
                String clave = rs.getString("clave");
                int acessosistemas = rs.getInt("acessosistemas");
                int esadministrador = rs.getInt("esadministrador");
                //We create the object
                usuarios.add(new Usuarios(carnet, nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, acessosistemas, esadministrador));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuarios;
    }

    @Override
    public void insert(Usuarios usuarios) throws SQLException{
        System.out.println(INSERT_USUARIOS);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIOS);){

            String nCarnet = createCarnet(usuarios.getNom_usuario(),  usuarios.getApe_usuario());
            System.out.println(nCarnet + " "+ StringUtils.capitalize(usuarios.getEstado().strip()));
            //Preparing the query
            preparedStatement.setString(1, nCarnet );
            preparedStatement.setString(2, StringUtils.capitalize(usuarios.getNom_usuario().strip()));
            preparedStatement.setString(3, StringUtils.capitalize( usuarios.getApe_usuario().strip()));
            preparedStatement.setString(4, StringUtils.capitalize(usuarios.getTipo().strip()));
            preparedStatement.setString(5, usuarios.getTelcasa().strip());
            preparedStatement.setString(6, usuarios.getCelular().strip());
            preparedStatement.setString(7, usuarios.getEmail().strip());
            preparedStatement.setString(8, StringUtils.capitalize(usuarios.getEstado().strip()));
            preparedStatement.setString(9, usuarios.getClave().strip());
            preparedStatement.setInt(10, usuarios.getAcessosistemas());
            preparedStatement.setInt(11, usuarios.getEsadministrador());
            //Execute statement
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Usuarios usuarios) throws SQLException{
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIOS);){
            System.out.println("Updated user: " + preparedStatement);
            //Prepare query
            preparedStatement.setString(1, StringUtils.capitalize(usuarios.getNom_usuario().strip()));
            preparedStatement.setString(2, StringUtils.capitalize(usuarios.getApe_usuario().strip()));
            preparedStatement.setString(3, StringUtils.capitalize(usuarios.getTipo().strip()));
            preparedStatement.setString(4, usuarios.getTelcasa().strip());
            preparedStatement.setString(5, usuarios.getCelular().strip());
            preparedStatement.setString(6, usuarios.getEmail().strip());
            preparedStatement.setString(7, StringUtils.capitalize(usuarios.getEstado().strip()));
            preparedStatement.setString(8, usuarios.getClave().strip());
            preparedStatement.setInt(9, usuarios.getAcessosistemas());
            preparedStatement.setInt(10, usuarios.getEsadministrador());
            preparedStatement.setString(11, usuarios.getCarnet().strip());
            //Check is there is any changes
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(String carnet) throws SQLException{
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USUARIOS);){
            //Prepare query
            preparedStatement.setString(1, carnet);
            //Check is there is any changes
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean admin(String carnet, int estado) throws SQLException{
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIOS_ADMIN);){
            System.out.println("Updated user: " + preparedStatement);
            //Prepare query
            preparedStatement.setInt(1, estado);
            preparedStatement.setString(2, carnet);
            //Check is there is any changes
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean access(String carnet, int estado) throws SQLException{
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIOS_ACCESO);){
            System.out.println("Updated user: " + preparedStatement);
            //Prepare query
            preparedStatement.setInt(1, estado);
            preparedStatement.setString(2, carnet);
            //Check is there is any changes
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
