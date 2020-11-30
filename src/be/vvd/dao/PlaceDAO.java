package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.Commande;
import be.vvd.classes.Place;

public class PlaceDAO implements DAO<Place> {

	private Connection connect = null;
	
	public PlaceDAO(Connection connect) {
		this.connect=connect;
	}
	
	@Override
	public boolean create(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean create(Place obj,long idCommande) {
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Place VALUES(null,'"+obj.getType()+"','"+obj.getPrix()+"','"+obj.getRepresentation().getID()+"','"+idCommande+"')");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Place> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Set<Place> findAllByCommandID(long commandID) {
		try {
			Set<Place> listPlace = new HashSet<Place>();
			ResultSet res = this.connect.createStatement().executeQuery("SELECT * FROM Place WHERE idCommande='"+commandID+"'");
			while(res.next()) {
				Place pla = new Place(res.getLong("id"),res.getString("type"),res.getDouble("prix"));
				listPlace.add(pla);
			}
			return listPlace;
		}catch(SQLException e) {
			return null;
		}
	}

}
