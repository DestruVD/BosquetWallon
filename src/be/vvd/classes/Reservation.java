package be.vvd.classes;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.PlanningSalleDAO;
import be.vvd.dao.ReservationDAO;

import java.util.Set;

import be.vvd.classes.*;

public class Reservation {
	private int accompte;
	private int solde;
	private String statut;
	private int prix;
	private PlanningSalle planning;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static ReservationDAO dao = factory.getReservationDAO();
	
	public Reservation(PlanningSalle planning ,int prix) {
		this.planning=planning;
		this.prix=prix;
		this.statut="Actif";
		this.solde=3000;
		this.accompte=prix / 100 * 40;
	}
	
	public Reservation(PlanningSalle planning) {
		this.planning=planning;
	}
	
	public String getDateDebutR() {
		return this.planning.getDateDebutR();
	}
	
	public String getDateFinR() {
		return this.planning.getDateFinR();
	}
	
	public int getPrix() {
		return this.prix;
	}
	
	public int getAccompte() {
		return this.accompte;
	}
	
	public int getSolde() {
		return this.solde;
	}
	
	public String getStatut() {
		return this.statut;
	}
	
	public boolean ajouterReservation() {
		return dao.create(this);
	}
	
	public static Set<Reservation> findAll(){
		return dao.findAll();
	}
}
