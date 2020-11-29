package be.vvd.classes;

import be.vvd.dao.CategorieDAO;
import be.vvd.dao.ConfigurationDAO;
import be.vvd.dao.DAOFactory;

public class Categorie {
	private be.vvd.classes.Configuration config;
	private long id;
	private String nomCategorie;
	private double prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static CategorieDAO dao = factory.getCategorieDAO();
	
	public Categorie(String nomCategorie,double prix,int nbrPlaceMax,be.vvd.classes.Configuration config) {
		this.nomCategorie=nomCategorie;
		this.prix=prix;
		this.nbrPlaceMax=nbrPlaceMax;
		this.config=config;
	}
	
	public Categorie(long id,String nomCategorie,double prix,int nbrPlaceMax) {
		this.id=id;
		this.nomCategorie=nomCategorie;
		this.prix=prix;
		this.nbrPlaceMax=nbrPlaceMax;
	}
	
	public String getNomCateg() {
		return this.nomCategorie;
	}
	
	public int getNbrPlaceDispo() {
		return this.nbrPlaceDispo;
	}
	
	public be.vvd.classes.Configuration getConfig() {
		return this.config;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public long getID() {
		return this.id;
	}
	
	public int getNbrPlaceMax() {
		return this.nbrPlaceMax;
	}
	
	public boolean ajouterCategorie() {
		return dao.create(this);
	}
}
