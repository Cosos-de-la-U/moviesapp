package DB.Queries;

public class qPeliculas {
    //BASIC
    public static final String SELECT_PELICULAS = "SELECT * FROM peliculas WHERE idpelicula = ?;";
    public static final String SELECT_ALL_PELICULAS = "SELECT * FROM peliculas;";
    public static final String INSERT_PELICULAS = "INSERT INTO peliculas(nombre, nomb_ingles, yearp, duracion) VALUES (?, ?, ?, ?);";
    public static final String UPDATE_PELICULAS = "SELECT updatePelicula(?, ?, ?, ?, ?, ?)";
    public static final String DELETE_PELICULAS = "DELETE FROM peliculas WHERE idpelicula = ?;";

    //VIEW


    //EXTRA
    public static final String SELECT_PELICULAS_VISTA_ALL = "SELECT * FROM peliculasVista order by nombre asc;";
    public static final String SELECT_PELICULAS_VISTA = "SELECT * FROM peliculasVista WHERE idpelicula = ?;";
    public static final String INSERT_PELICULAS_FUNCTION = "SELECT insertarPelicula(?, ?, ?, ?, ?)";

}
