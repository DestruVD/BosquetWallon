package be.vvd.classes;

import be.vvd.dao.CategorieDAO;
import be.vvd.dao.ConfigurationDAO;
import be.vvd.dao.DAOFactory;

public class Categorie {
	private long idConfig;
	private String nomCategorie;
	private int prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static CategorieDAO dao = factory.getCategorieDAO();
	
	public Categorie(String nomCategorie,int prix,int nbrPlaceDispo,int nbrPlaceMax,long idConfig) {
		this.nomCategorie=nomCategorie;
		this.prix=prix;
		this.nbrPlaceDispo=nbrPlaceDispo;
		this.nbrPlaceMax=nbrPlaceMax;
		this.idConfig=idConfig;
	}
	
	public String getNomCateg() {
		return this.nomCategorie;
	}
	
	public int getNbrPlaceDispo() {
		return this.nbrPlaceDispo;
	}
	
	public long getIDConfig() {
		return this.idConfig;
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
