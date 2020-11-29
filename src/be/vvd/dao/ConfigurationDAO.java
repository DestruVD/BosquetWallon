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

public class ConfigurationDAO implements DAO<be.vvd.classes.Configuration> {

	private Connection connect = null;
	
	public ConfigurationDAO(Connection connect) {
		this.connect=connect;
	}
	
	public boolean create(be.vvd.classes.Configuration obj) {
		try {
			PreparedStatement statement = this.connect.prepareStatement("INSERT INTO Configuration VALUES(null,'"+obj.getNomConfig()+"')",Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()) {
				obj.setID(res.getLong(1));
				return true;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(be.vvd.classes.Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(be.vvd.classes.Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public be.vvd.classes.Configuration find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<be.vvd.classes.Configuration> findAll() {
		return null;
	}
}
