package application.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {
	/** * param�tres de connexion:  URL de connection et login, pass pour la BDD */
    private static String url = "jdbc:mysql://localhost/videotheque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "Thierry";
    private static String passwd = "P97928zg!";
    /** * Objet Connection */
    private static Connection connect;
    /** * M�thode qui va nous retourner notre instance * et la cr�er si elle     n'existe pas... * @return */
    public static Connection getInstance(){
        if(connect == null){
        try {
            connect = DriverManager.getConnection(url, user, passwd);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connexion impossible "+e.getLocalizedMessage());
        }
        }
        return connect;
    }

}
