package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.Client;
import be.vvd.classes.Representation;
import be.vvd.classes.Utilisateur;

public class RepresentationDAO implements DAO<Representation>{
	
	private Connection connect = null;
	
	public RepresentationDAO(Connection conn) {
		this.connect=conn;
	}

	public boolean create(Representation rep){
		try {			
			this.connect.createStatement().executeUpdate("INSERT INTO Representation VALUES(null,'"+rep.getDate()+"')");
			return true;
		}catch(SQLException e) {
			return false;
		}
	}

	public boolean delete(Representation obj) {
		return false;
	}

	public boolean update(Representation obj) {
		return false;
	}

	public Representation find(int id) {
		return null;
	}

	public Set<Representation> findAll() {
		Set<Representation> listRep = new HashSet<>();
		try {			
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Representation");
			while(result.next()) {
				Representation rep = new Representation(result.getString("Date"));
				listRep.add(rep);
			}
			return listRep;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}
}
