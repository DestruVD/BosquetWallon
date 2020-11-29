package be.vvd.dao;

import java.sql.Connection;
import java.util.Set;

import be.vvd.classes.Representation;

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
	
	public boolean create(Set<Representation> obj) {
		return false;
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
	public Representation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Representation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
