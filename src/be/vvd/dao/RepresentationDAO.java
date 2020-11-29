package be.vvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.Categorie;
import be.vvd.classes.Representation;
import be.vvd.classes.Spectacle;

public class RepresentationDAO implements DAO<Representation> {

	private Connection connect;
	
	public RepresentationDAO(Connection conn) {
		this.connect=conn;
	}
	
	@Override
	public boolean create(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}
	//SELECT * FROM Reservation INNER JOIN Spectacle ON Reservation.idSpectacle = Spectacle.id  WHERE idUtilisateur='"+user.getID()+"'
	public boolean create(Set<Representation> obj) {
		try {
			long idSpec = 0;
			boolean alreadySet=false;
			Set<Categorie> listCateg = new HashSet<Categorie>();
			Set<Long> listReprID = new HashSet<Long>();
			for(var item : obj) {
				if(!alreadySet) {
					idSpec=item.getSpectacle().getID();
					alreadySet=true;
				}
				PreparedStatement statement = this.connect.prepareStatement("INSERT INTO Representation VALUES(null,'"+item.getDate()+"','"+item.getHeureOuverture()+"','"+item.getHeureDebut()+"','"+item.getHeureFin()+"','"+item.getSpectacle().getID()+"')",Statement.RETURN_GENERATED_KEYS);
				statement.executeUpdate();
				ResultSet res = statement.getGeneratedKeys();
				if(res.next()) {
					listReprID.add(res.getLong(1));
				}
			}
			ResultSet allCateg = this.connect.createStatement().executeQuery("SELECT * FROM Categorie INNER JOIN Configuration ON Categorie.idConfiguration = Configuration.id INNER JOIN Spectacle ON Spectacle.idConfiguration=Configuration.id WHERE Spectacle.id='"+idSpec+"'");
			while(allCateg.next()) {
				Categorie categ = new Categorie(allCateg.getLong("id"),allCateg.getString("nom"),allCateg.getDouble("prix"),allCateg.getInt("nbrPlaceMax"));
				listCateg.add(categ);
			}
			
			for(var rep : listReprID) {
				for(var categ : listCateg) {
					this.connect.createStatement().executeUpdate("INSERT INTO Categorie_Representation VALUES('"+categ.getID()+"','"+rep+"','"+categ.getNbrPlaceMax()+"')");
				}
			}
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Representation find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Set<Representation> findBySpectacleID(long id){
		try {
			Set<Representation> listRep = new HashSet<Representation>();
			ResultSet res =this.connect.createStatement().executeQuery("SELECT * FROM Representation WHERE idSpectacle='"+id+"'");
			while(res.next()) {
				Representation rep = new Representation(res.getString("Date"),res.getString("HeureOuverture"),res.getString("HeureDebut"),res.getString("HeureFin"));
				listRep.add(rep);
			}
			return listRep;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Set<Representation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
