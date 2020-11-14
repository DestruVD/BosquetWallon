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
	
	public boolean create(Utilisateur obj){		
		return false;
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
	
	public boolean login(Utilisateur user) {
		try {
			String email = user.getEmail().toLowerCase();
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Utilisateur WHERE Email='"+email+"'");
			if(result.next()) {
				if(result.getString("Password").equals(user.getPassword())) {
					return true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}
}