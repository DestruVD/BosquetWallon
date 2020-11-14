package be.vvd.dao;

import java.sql.Connection;
import java.sql.SQLException;

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
}
