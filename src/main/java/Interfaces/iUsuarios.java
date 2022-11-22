package Interfaces;

import Model.Usuarios;

import java.sql.SQLException;
import java.util.List;

public interface iUsuarios {
    public Usuarios select(String carnet) throws SQLException;
    public List<Usuarios> selectAll() throws SQLException;
    public void insert(Usuarios usuarios) throws SQLException;
    public boolean edit(Usuarios usuarios) throws SQLException;
    public boolean delete(String carnet) throws SQLException;
    public boolean admin(String carnet, int estado) throws SQLException;
    public boolean access(String carnet, int estado) throws SQLException;
}
