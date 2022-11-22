package Interfaces;

import Model.Usuarios;
import Enum.SesionEnum;

import java.sql.SQLException;

public interface iLogin {
    public Usuarios logIn(String carnet, String clave) throws SQLException;
}
