package DB.Queries;

public class qCategoria {
    //BASIC
    public static final String SELECT_CATEGORIA = "SELECT * FROM categoria WHERE idcategoria = ?;";
    public static final String SELECT_ALL_CATEGORIA = "SELECT * FROM categoria ORDER BY categoria ASC;";
    public static final String INSERT_CATEGORIA = "INSERT INTO categoria(categoria) VALUES (?);";
    public static final String UPDATE_CATEGORIA = "UPDATE categoria SET categoria = ? WHERE idcategoria = ?;";
    public static final String DELETE_CATEGORIA = "DELETE FROM categoria WHERE idcategoria = ?;";

    //VIEW

    //EXTRA
}
