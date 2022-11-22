package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDriver {
    private static String url = "jdbc:postgresql://localhost:5432/moviesdb";
    private static String user = "postgres";
    private static String pass = "1234";
    private static String driver = "org.postgresql.Driver";
    /*
    //RAILWAY:
    private static String url = "jdbc:postgresql://containers-us-west-23.railway.app:6843/railway";
    private static String user = "postgres";
    private static String pass = "hJU1t42lLoG8Jub2vbyK";
    private static String driver = "org.postgresql.Driver";
     */
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
