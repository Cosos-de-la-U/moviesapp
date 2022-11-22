package DB.Queries;

public class qFotos {
    //BASIC
    public static final String SELECT_FOTOS = "SELECT * FROM fotos WHERE idfoto = ?;";
    public static final String SELECT_ALL_FOTOS = "SELECT * FROM fotos;";
    public static final String INSERT_FOTOS = "INSERT INTO fotos(idpelicula, foto, primera) VALUES (?, ?, ?);";
    public static final String UPDATE_FOTOS = "UPDATE fotos SET idpelicula =?, foto = ?, primera = ? WHERE idfoto = ?;";
    public static final String DELETE_FOTOS = "DELETE FROM fotos WHERE idfoto = ?;";

    //VIEW

    //EXTRA
    public static final String SELECT_ALL_FOTOS_VIEW = "SELECT * FROM fotosVista order by primera desc, nombre asc;";
    public static final String SELECT_FOTOS_VIEW = "SELECT * FROM fotosVista WHERE idfoto = ?;";
    public static final String UPDATE_FOTOS_PRIMERA = "SELECT updatefotosprimera(?, ?);";
}
