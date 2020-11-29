package be.vvd.classes;

import be.vvd.dao.CategorieDAO;
import be.vvd.dao.ConfigurationDAO;
import be.vvd.dao.DAOFactory;

public class Categorie {
	private be.vvd.classes.Configuration config;
	private String nomCategorie;
	private int prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static CategorieDAO dao = factory.getCategorieDAO();
	
	public Categorie(String nomCategorie,int prix,int nbrPlaceDispo,int nbrPlaceMax,be.vvd.classes.Configuration config) {
		this.nomCategorie=nomCategorie;
		this.prix=prix;
		this.nbrPlaceDispo=nbrPlaceDispo;
		this.nbrPlaceMax=nbrPlaceMax;
		this.config=config;
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
	
	public int getPrix() {
		return this.prix;
	}
	
	public int getNbrPlaceMax() {
		return this.nbrPlaceMax;
	}
	
	public boolean ajouterCategorie() {
		return dao.create(this);
	}
}
