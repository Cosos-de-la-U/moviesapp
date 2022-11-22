package DB.Queries;

public class qPeliculasVistas {
    //BASIC
    public static final String SELECT_CATALOGO = "SELECT * FROM peliculavista WHERE carnet = ? AND idpelicula = ?;";
    public static final String SELECT_ALL_CATALOGO = "SELECT * FROM CATALOGO;";
    public static final String INSERT_CATALOGO = "INSERT INTO CATALOGO(nombre, nomb_ingles, yearp, duracion) VALUES (?, ?, ?, ?);";
    public static final String UPDATE_CATALOGO = "SELECT updatePelicula(?, ?, ?, ?, ?, ?)";
    public static final String DELETE_CATALOGO = "DELETE FROM CATALOGO WHERE idpelicula = ?;";

    //VIEW


    //EXTRA
    public static final String SELECT_CATALOGO_VISTA_ALL = "select * from peliculaCatalogoVista;";
    public static final String INSERT_CATALOGO_FUNCTION = "SELECT insertarPelicula(?, ?, ?, ?, ?)";
    public static final String INSERT_COMENTARIO = "INSERT INTO peliculavista(idpelicula, carnet, comentario, calificacion) values (?, ?, ? ,?);";
    public static final String UPDATE_COMENTARIO = "UPDATE SET idpelicula = ?, carnet = ?, comentario = ?, calificacion = ? WHERE carnet = ? AND idpelicula = ?;";

}
