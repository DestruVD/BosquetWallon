package be.vvd.classes;

import java.util.Set;

import be.vvd.dao.CommandeDAO;
import be.vvd.dao.DAOFactory;
import be.vvd.dao.PlaceDAO;

public class Place {
	private long id;
	private String type;
	private double prix;
	private Representation rep;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static PlaceDAO dao = factory.getPlaceDAO();
	
	public Place(String type,double prix,Representation rep) {
		this.type=type;
		this.prix=prix;
		this.rep=rep;
	}
	
	public Place(long id,String type,double prix) {
		this.id=id;
		this.type=type;
		this.prix=prix;
	}
	
	public String getType() {
		return this.type;
	}
	
	public long getID() {
		return this.id;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public Representation getRepresentation() {
		return this.rep;
	}
	
	public boolean create(long idCommande) {
		return dao.create(this,idCommande);
	}
	
	public static Set<Place> findAllByCommandID(long id){
		return dao.findAllByCommandID(id);
	}
}
