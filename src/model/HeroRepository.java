package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import entity.Hero;
import entity.TypeIncident;
import model.Myconnection;
public class HeroRepository {
    private Connection connection;
	public HeroRepository() {
		connection = Myconnection.getInstance();
	}
	public  int creer(Hero hero) {
		    	int id=0;
		    	
		        try {
		            PreparedStatement prepare = this.connection.prepareStatement(
		                          "INSERT INTO hero (nom, tel, latitude, longitude) "+
		                          "VALUES (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS
		                      );
		            prepare.setString(1, hero.getNom());
		            prepare.setString(2, hero.getTelephone());
		            prepare.setDouble(3, hero.getLatitude());
		            prepare.setDouble(4, hero.getLongitude());
		            prepare.executeUpdate();
		            
		            ResultSet rs=prepare.getGeneratedKeys();
		            if(rs.next()){
		        		id=rs.getInt(1);
		        		}
		            prepare.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return id;
		    }
	public ArrayList<TypeIncident> findAllTypeIncident() {
		ArrayList<TypeIncident> typeIncidents = new ArrayList<>(); 
		ResultSet result;
		try {
			result = this.connection.createStatement().executeQuery("SELECT * FROM typeIncident");
			while (result.next()) {
				TypeIncident typeIncident = new TypeIncident();
				typeIncident.setName(result.getString("nom"));
				typeIncident.setId(result.getLong("id"));

				typeIncidents.add(typeIncident);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typeIncidents;
	}

	public void insertTypeIncidents (int idhero, int idTypeIncident) {
		
		try {
			PreparedStatement prepare = this.connection.prepareStatement(
					"INSERT INTO herotypeincident (idhero, idtypeincident)" + "VALUES (?, ?)"
					);
			prepare.setInt(1, idhero);
            prepare.setInt(2, idTypeIncident);
            prepare.executeUpdate();
            prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
