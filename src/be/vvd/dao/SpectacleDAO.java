package be.vvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			long idSpec=0;
			Set<Long> idArtistes = new HashSet<Long>();
			for(var item : obj.getListArtiste()) {
				String nom = item.split(" ")[0];
				String prenom = item.split(" ")[1];
				ResultSet res = this.connect.createStatement().executeQuery("SELECT id FROM Artiste WHERE nom='"+nom+"' AND prenom='"+prenom+"'");
				if(res.next()) {
					idArtistes.add(res.getLong("id"));
				}
			}
			PreparedStatement statement = this.connect.prepareStatement("INSERT INTO Spectacle VALUES(null,'"+obj.getTitre()+"','"+obj.getPlaceMax()+"','"+obj.getIDConfig()+"')",Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()) {
				idSpec = res.getLong(1);
			}
			for(var item : idArtistes) {				
				this.connect.createStatement().executeUpdate("INSERT INTO Spectacle_Artiste VALUES ('"+idSpec+"','"+item+"')");
			}
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
				Spectacle spec = new Spectacle(result.getString("titre"), result.getInt("placeMax"));
				listSpec.add(spec);
			}
			return listSpec;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}

}
