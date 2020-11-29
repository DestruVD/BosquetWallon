package be.vvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		try {
			PreparedStatement s = this.connect.prepareStatement("UPDATE Reservation SET statut = 'Payé', solde = 0 WHERE id='"+obj.getID()+"'");
			s.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Reservation find(long id) {
		try {
			Reservation reserv=null;
			PlanningSalle planning=null;
			Spectacle spec=null;
			ResultSet res = this.connect.createStatement().executeQuery("SELECT * FROM Reservation WHERE id='"+id+"'");
			if(res.next()) {
				spec = new Spectacle(res.getInt("idSpectacle"));
				planning = new PlanningSalle(res.getString("DateDebutR"),res.getString("DateFinR"),spec);
				reserv = new Reservation(planning);
			}
			return reserv;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean paiementAccompte(Reservation obj) {
		try {
			PreparedStatement s = this.connect.prepareStatement("UPDATE Reservation SET solde = '"+obj.getSolde()+"' WHERE id='"+obj.getID()+"'");
			s.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
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
				Spectacle spec = new Spectacle(((long)result.getInt("idSpectacle")),result.getString("titre"));
				PlanningSalle plan = new PlanningSalle(result.getString("DateDebutR"), result.getString("DateFinR"),spec);
				Reservation res = new Reservation(result.getLong("id"),plan,result.getInt("prix"),result.getString("statut"),result.getInt("solde"),result.getInt("accompte"));
				listRes.add(res);
			}
			return listRes;
		}catch(SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}
}
