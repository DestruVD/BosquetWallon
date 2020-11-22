package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.Client;
import be.vvd.classes.PlanningSalle;
import be.vvd.classes.Spectacle;

public class SpectacleDAO implements DAO<Spectacle> {

	private Connection connect = null;
	
	public SpectacleDAO(Connection connect) {
		this.connect=connect;
	}
	
	@Override
	public boolean create(Spectacle obj) {
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Spectacle VALUES(null,'"+obj.getTitre()+"','"+obj.getPlaceMax()+"')");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spectacle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Spectacle> findAll() {
		Set<Spectacle> listSpec = new HashSet<>();
		try {			
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Spectacle");
			while(result.next()) {
				Spectacle rep = new Spectacle(result.getString("titre"), result.getInt("placeMax"));
				listSpec.add(rep);
			}
			return listSpec;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}

}
