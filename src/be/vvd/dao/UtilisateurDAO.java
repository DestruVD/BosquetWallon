package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.*;
import be.vvd.dao.*;

public class UtilisateurDAO implements DAO<Utilisateur>{
	private Connection connect = null;
	public UtilisateurDAO(Connection conn){
		this.connect = conn;
	}
	
	public boolean create(Utilisateur user){
		try {
			if(user.getRole()=="Client") {
				ResultSet res = this.connect.createStatement().executeQuery("SELECT * FROM Utilisateur WHERE (Nom='"+user.getNom().toLowerCase()+"' AND Prenom='"+user.getPrenom().toLowerCase()+"') OR Email='"+user.getEmail().toLowerCase()+"'");
				if(res.next()) {
					return false;
				}else {					
					this.connect.createStatement().executeUpdate("INSERT INTO Utilisateur VALUES(null,'"+user.getNom().toLowerCase()+"','"+user.getPrenom().toLowerCase()+"','"+user.getAdresse().toLowerCase()+"','"+user.getRole().toLowerCase()+"','"+user.getPassword()+"','"+user.getEmail().toLowerCase()+"','"+((Client) user).getTelephone().toLowerCase()+"',null)");
				}
			}else if(user.getRole()=="Organisateur") {
				ResultSet res = this.connect.createStatement().executeQuery("SELECT * FROM Utilisateur WHERE (Nom='"+user.getNom().toLowerCase()+"' AND Prenom='"+user.getPrenom().toLowerCase()+"') OR Email='"+user.getEmail().toLowerCase()+"'");
				if(res.next()) {
					return false;
				}else {					
					this.connect.createStatement().executeUpdate("INSERT INTO Utilisateur VALUES(null,'"+user.getNom().toLowerCase()+"','"+user.getPrenom().toLowerCase()+"','"+user.getAdresse().toLowerCase()+"','"+user.getRole().toLowerCase()+"','"+user.getPassword()+"','"+user.getEmail().toLowerCase()+"',null,'"+((Organisateur) user).getNumBanque().toLowerCase()+"')");
				}
			}else if(user.getRole()=="Artiste"){
				ResultSet res = this.connect.createStatement().executeQuery("SELECT * FROM Artiste WHERE (nom='"+user.getNom().toLowerCase()+"' AND prenom='"+user.getPrenom().toLowerCase()+"') OR email='"+user.getEmail().toLowerCase()+"'");
				if(res.next()) {
					return false;
				}else {					
					this.connect.createStatement().executeUpdate("INSERT INTO Artiste VALUES(null,'"+user.getNom().toLowerCase()+"','"+user.getPrenom().toLowerCase()+"','"+user.getAdresse().toLowerCase()+"','"+user.getRole().toLowerCase()+"','"+user.getPassword()+"','"+user.getEmail().toLowerCase()+"','"+((Artiste) user).getNumArtiste().toLowerCase()+"')");
				}
			}
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Utilisateur obj){
		return false;
	}
	
	public boolean update(Utilisateur obj){
		return false;
	}
	
	public Utilisateur find(int id){
		return null;
	}
	
	public boolean findByEmail(String email) {
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Utilisateur WHERE Email='"+email+"'");
			if(result.next()) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			return false;
		}
	}
	
	public Utilisateur login(Utilisateur user) {
		try {
			String email = user.getEmail().toLowerCase();
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Utilisateur WHERE Email='"+email+"'");
			if(result.next()) {
				if(result.getString("Password").equals(user.getPassword())) {
					Utilisateur resultUser = new Utilisateur(result.getLong("id"),result.getString("Role"));
					return resultUser;
				}
			}else {
				ResultSet resultArtiste = this.connect.createStatement().executeQuery("SELECT * FROM Artiste WHERE email='"+email+"'");
				if(resultArtiste.next()) {
					if(resultArtiste.getString("password").equals(user.getPassword())) {
						Utilisateur artisteUser = new Utilisateur(resultArtiste.getLong("id"),resultArtiste.getString("role"));
						return artisteUser;
					}
				}
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			return null; 
		}	
	}
	
	public Set<Artiste> findAllArtiste(){
		Set<Artiste> listArtiste = new HashSet<Artiste>();
		try {			
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Artiste");
			while(result.next()) {
				Artiste artiste = new Artiste(result.getString("nom"),result.getString("prenom"));
				listArtiste.add(artiste);
			}
			return listArtiste;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}

	public Set<Utilisateur> findAll() {
		return null;
	}
}