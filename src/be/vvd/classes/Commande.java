package be.vvd.classes;

import java.util.Set;

import be.vvd.dao.CommandeDAO;
import be.vvd.dao.DAOFactory;
import be.vvd.dao.ReservationDAO;

public class Commande {
	private long id;
	private Set<Place> listPlace;
	private double cout;
	private String modePaiement;
	private String modeLivraison;
	private Utilisateur user;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static CommandeDAO dao = factory.getCommandeDAO();
	
	public Commande(Set<Place> listPlace,String modePaiement,String modeLivraison,Utilisateur user) {
		this.listPlace=listPlace;
		for(var place : listPlace) {			
			this.cout=this.cout+place.getPrix();
		}
		this.modePaiement=modePaiement;
		this.modeLivraison=modeLivraison;
		this.user=user;
	}
	
	public Commande(long id,double cout,String modePaiement,String modeLivraison) {
		this.id=id;
		this.cout=cout;
		this.modePaiement=modePaiement;
		this.modeLivraison=modeLivraison;
	}
	
	public long getID(){
		return this.id;
	}
	
	public String getModePaiement(){
		return this.modePaiement;
	}
	
	public String getModeLivraison(){
		return this.modeLivraison;
	}
	
	public double getCout(){
		return this.cout;
	}
	
	public Utilisateur getUser(){
		return this.user;
	}
	
	public Set<Place> getListPlace(){
		return this.listPlace;
	}
	
	public long create() {
		return dao.createAndSendID(this);
	}
	
	public static Set<Commande> findAllByUserID(long id){
		return dao.findAllByUserID(id);
	}
}
