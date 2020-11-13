package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vvd.classes.*;
import be.vvd.dao.*;

public class UtilisateurDAO extends DAO<Utilisateur>{
	public UtilisateurDAO(Connection conn){
		super(conn);
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
		Utilisateur user = new Utilisateur();
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT Nom,Prénom,Adresse FROM Utilisateur WHERE id="+id);
			if(result.next())
				user = new Utilisateur(id, result.getString(1), result.getString(2), result.getString(3));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
}