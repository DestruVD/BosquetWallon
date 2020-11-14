package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				this.connect.createStatement().executeUpdate("INSERT INTO Utilisateur VALUES(null,'"+user.getNom()+"','"+user.getPrenom()+"','"+user.getAdresse()+"','"+user.getRole()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+((Client) user).getTelephone()+"',null,null)");
			}else if(user.getRole()=="Organisateur") {
				this.connect.createStatement().executeUpdate("INSERT INTO Utilisateur VALUES(null,'"+user.getNom()+"','"+user.getPrenom()+"','"+user.getAdresse()+"','"+user.getRole()+"','"+user.getPassword()+"','"+user.getEmail()+"',null,'"+((Organisateur) user).getNumBanque()+"',null)");
			}else if(user.getRole()=="Gestionnaire"){
				this.connect.createStatement().executeUpdate("INSERT INTO Utilisateur VALUES(null,'"+user.getNom()+"','"+user.getPrenom()+"','"+user.getAdresse()+"','"+user.getRole()+"','"+user.getPassword()+"','"+user.getEmail()+"',null,null,'"+((Gestionnaire) user).getNumNationale()+"')");
			}
			return true;
		}catch(SQLException e) {
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
	
	public String login(Utilisateur user) {
		try {
			String email = user.getEmail().toLowerCase();
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Utilisateur WHERE Email='"+email+"'");
			if(result.next()) {
				if(result.getString("Password").equals(user.getPassword())) {
					return result.getString("Role");
				}
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			return null; 
		}
	}
}