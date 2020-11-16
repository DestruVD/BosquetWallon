package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.Client;
import be.vvd.classes.PlanningSalle;
import be.vvd.classes.Representation;
import be.vvd.classes.Utilisateur;

public class PlanningSalleDAO implements DAO<PlanningSalle>{
	
	private Connection connect = null;
	
	public PlanningSalleDAO(Connection conn) {
		this.connect=conn;
	}

	public boolean create(PlanningSalle rep){
		try {			
			this.connect.createStatement().executeUpdate("INSERT INTO Representation VALUES(null,'"+rep.getDateDebutR()+"','"+rep.getDateFinR()+"')");
			return true;
		}catch(SQLException e) {
			return false;
		}
	}

	public boolean delete(PlanningSalle obj) {
		return false;
	}

	public boolean update(PlanningSalle obj) {
		return false;
	}

	public PlanningSalle find(int id) {
		return null;
	}

	public Set<PlanningSalle> findAll() {
		Set<PlanningSalle> listRep = new HashSet<>();
		try {			
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM PlanningSalle");
			while(result.next()) {
				PlanningSalle rep = new PlanningSalle(result.getString("DateDebutR"), result.getString("DateFinR"));
				listRep.add(rep);
			}
			return listRep;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}
}
