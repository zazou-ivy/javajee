package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {
	private static String url = "jdbc:mysql://localhost:3306/superhero";
	private static String user = "root";
	private static String passwd = "IVY18021994kimi";
	private static Connection connect;
	public static Connection getInstance(){
		if(connect == null){
			try {
			      Class.forName("com.mysql.jdbc.Driver"); /* va chercher le pilote adéquat */
			      // Etape 2 - récupérer la connexion 
			      connect = DriverManager.getConnection(url,user, passwd);
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Connexion Impossible" + e.getMessage());
			}
		}       
		return connect; 
	}
}
