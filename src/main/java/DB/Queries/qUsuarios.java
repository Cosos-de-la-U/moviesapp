package DB.Queries;

public class qUsuarios {
    //BASIC
    public static final String SELECT_USUARIOS = "SELECT * FROM usuarios WHERE carnet = ?;";
    public static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuarios;";
    public static final String INSERT_USUARIOS = "INSERT INTO usuarios(carnet, nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, acessosistemas, esadministrador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_USUARIOS = "UPDATE  usuarios SET nom_usuario = ?, ape_usuario = ?, tipo = ?, telcasa = ?, celular = ?, email = ?, estado = ?, clave = ?, acessosistemas = ?, esadministrador = ? WHERE carnet = ?;";
    public static final String DELETE_USUARIOS = "DELETE FROM usuarios WHERE carnet = ?;";

    //VIEW


    //EXTRA
    public static final String SELECT_USUARIOS_LOGIN = "SELECT * FROM usuarios WHERE carnet = ? AND clave = ?;";
    public static final String CHECK_CARNET = "SELECT carnet FROM usuarios WHERE carnet = ?";
    public static final String UPDATE_USUARIOS_ADMIN = "UPDATE  usuarios SET esadministrador = ? WHERE carnet = ?;";
    public static final String UPDATE_USUARIOS_ACCESO = "UPDATE  usuarios SET acessosistemas = ? WHERE carnet = ?;";
}
