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
import jdk.jfr.Configuration;

public class CategorieDAO implements DAO<be.vvd.classes.Categorie> {

	private Connection connect = null;
	
	public CategorieDAO(Connection connect) {
		this.connect=connect;
	}
	
	public boolean create(be.vvd.classes.Categorie obj) {
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Categorie VALUES(null,'"+obj.getNomCateg()+"','"+obj.getPrix()+"','"+obj.getNbrPlaceDispo()+"','"+obj.getNbrPlaceMax()+"','"+obj.getIDConfig()+"')");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(be.vvd.classes.Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(be.vvd.classes.Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public be.vvd.classes.Categorie find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<be.vvd.classes.Categorie> findAll() {
		return null;
	}
}
