package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.PlanningSalle;
import be.vvd.classes.Reservation;

public class ReservationDAO implements DAO<Reservation>{

	private Connection connect;
	
	public ReservationDAO(Connection conn) {
		this.connect=conn;
	}

	@Override
	public boolean create(Reservation obj) {
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Reservation VALUES(null,'"+obj.getAccompte()+"','"+obj.getSolde()+"','"+obj.getStatut()+"','"+obj.getPrix()+"','"+obj.getDateDebutR()+"','"+obj.getDateFinR()+"')");
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Reservation> findAll() {
		Set<Reservation> listRes = new HashSet<>();
		try {			
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Reservation");
			while(result.next()) {
				PlanningSalle plan = new PlanningSalle(result.getString("DateDebutR"), result.getString("DateFinR"));
				Reservation res = new Reservation(plan);
				listRes.add(res);
			}
			return listRes;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}

}
