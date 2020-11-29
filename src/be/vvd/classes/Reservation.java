package be.vvd.classes;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.ReservationDAO;

import java.util.Set;

import be.vvd.classes.*;

public class Reservation {
	
	private long id;
	private int accompte;
	private int solde;
	private String statut;
	private int prix;
	private PlanningSalle planning;
	private Utilisateur orga;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static ReservationDAO dao = factory.getReservationDAO();
	
	public Reservation(PlanningSalle planning ,int prix,Utilisateur orga) {
		this.planning=planning;
		this.prix=prix;
		this.orga=orga;
		this.statut="Non payé";
		this.solde=prix;
		this.accompte=prix / 100 * 40;
	}
	
	public Reservation(long id,PlanningSalle planning ,int prix ,String statut, int solde, int accompte) {
		this.id=id;
		this.planning=planning;
		this.prix=prix;
		this.statut=statut;
		this.solde=solde;
		this.accompte=accompte;
	}
	
	public Reservation(int prix ,String statut, int solde, int accompte) {
		this.prix=prix;
		this.statut=statut;
		this.solde=solde;
		this.accompte=accompte;
	}
	
	public Reservation(PlanningSalle planning) {
		this.planning=planning;
	}
	
	public Reservation(long id) {
		this.id=id;
	}
	
	public void setSolde(int solde) {
		this.solde=solde;
	}
	
	public void setStatut(String statut) {
		this.statut=statut;
	}
	
	public String getDateDebutR() {
		return this.planning.getDateDebutR();
	}
	
	public String getDateFinR() {
		return this.planning.getDateFinR();
	}
	
	public long getIDUser() {
		return this.orga.getID();
	}
	
	public String getTitre() {
		return this.planning.getTitre();
	}
	
	public int getPlaceMax(){
		return this.planning.getPlaceMax();
	}
	
	public PlanningSalle getPlanning() {
		return this.planning;
	}
	
	public long getID() {
		return this.id;
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
	
	public boolean updateReservation() {
		return dao.update(this);
	}
	
	public boolean paiementAccompte() {
		return dao.paiementAccompte(this);
	}
	
	public Reservation getReservationByID() {
		return dao.find(this.id);
	}
	
	public static Set<Reservation> findAll(){
		return dao.findAll();
	}
	
	public static Set<Reservation> findAllByUser(Utilisateur user){
		return dao.findAllByUser(user);
	}
}
