package be.vvd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.PlanningSalle;
import be.vvd.classes.Reservation;
import be.vvd.classes.Spectacle;
import be.vvd.classes.Utilisateur;

public class ReservationDAO implements DAO<Reservation>{

	private Connection connect;
	
	public ReservationDAO(Connection conn) {
		this.connect=conn;
	}

	@Override
	public boolean create(Reservation obj) {
		try {
			int id=0;
			ResultSet res = this.connect.createStatement().executeQuery("SELECT * FROM Spectacle WHERE titre='"+obj.getTitre()+"'");
			if(res.next()) {
				id = res.getInt("id");
			}
			this.connect.createStatement().executeUpdate("INSERT INTO Reservation VALUES(null,'"+obj.getAccompte()+"','"+obj.getSolde()+"','"+obj.getStatut()+"','"+obj.getPrix()+"','"+obj.getDateDebutR()+"','"+obj.getDateFinR()+"','"+id+"','"+obj.getIDUser()+"')");
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
	
	
	public Set<Reservation> findAllByUser(Utilisateur user) {
		Set<Reservation> listRes = new HashSet<>();
		ResultSet resultSpec=null;
		try {			
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Reservation INNER JOIN Spectacle ON Reservation.idSpectacle = Spectacle.id  WHERE idUtilisateur='"+user.getID()+"'");
			while(result.next()) {
				Spectacle spec = new Spectacle(result.getString("titre"));
				PlanningSalle plan = new PlanningSalle(result.getString("DateDebutR"), result.getString("DateFinR"),spec);
				Reservation res = new Reservation(plan,result.getInt("prix"),result.getString("statut"),result.getInt("solde"),result.getInt("accompte"));
				listRes.add(res);
			}
			return listRes;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}
}
