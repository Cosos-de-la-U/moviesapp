package Helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.Random;

import static DB.PostgresDriver.getConnection;
import static DB.Queries.qUsuarios.CHECK_CARNET;

public class generateCarnet {
    public static String createCarnet(String nom_usuario, String ape_usuario) throws SQLException {
        String newCarnet = null;
        //boolean to check query
        boolean rowExist;
        try (Connection connection = getConnection();) {
            do {
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_CARNET);
                //Generate carnet
                newCarnet = giveCarnet(nom_usuario.toUpperCase(), ape_usuario.toUpperCase());
                //Prepare query
                preparedStatement.setString(1, newCarnet);
                //Check is there is any changes
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()){
                    String carnet = rs.getString("carnet");
                    rowExist = true;
                    System.out.println(newCarnet + " " + rowExist + " " + carnet);
                }else {
                    rowExist = false;
                    System.out.println(newCarnet + " " + rowExist);
                }
            } while (rowExist);
        }
        return newCarnet;
    }

    private static String giveCarnet(String nom_usuario, String ape_usuario){
        char nomChar = nom_usuario.charAt(0);
        char apeChar = ape_usuario.charAt(0);
        int year = Year.now().getValue();
        Random rand = new Random();
        int newRandom = rand.nextInt(1000);
        //Concat and give
        return "" + year + nomChar + apeChar + newRandom + "";
    }
}
