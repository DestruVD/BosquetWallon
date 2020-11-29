package be.vvd.classes;

import java.util.Set;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.SpectacleDAO;
import be.vvd.dao.UtilisateurDAO;

public class Spectacle {
	private String titre;
	private int nbrPlaceParClient;
	private Set<String> listArtiste;
	private Utilisateur user;
	private be.vvd.classes.Configuration config;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static SpectacleDAO dao = factory.getSpectacleDAO();
	
	public Spectacle(String titre, int nbrPlaceParClient, Set<String> listArtiste,be.vvd.classes.Configuration config,Utilisateur user) {
		this.titre=titre;
		this.nbrPlaceParClient=nbrPlaceParClient;
		this.listArtiste=listArtiste;
		this.config=config;
		this.user=user;
	}
	public Spectacle(String titre, int nbrPlaceParClient, Utilisateur user) {
		this.titre=titre;
		this.nbrPlaceParClient=nbrPlaceParClient;
		this.user=user;
	}
	
	public Spectacle(String titre) {
		this.titre=titre;
	}
	
	public Utilisateur getUser() {
		return this.user;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public int getPlaceMax() {
		return this.nbrPlaceParClient;
	}
	
	public be.vvd.classes.Configuration getConfig() {
		return this.config;
	}
	
	public Set<String> getListArtiste() {
		return this.listArtiste;
	}
	
	public boolean ajouterSpectacle() {
		return dao.create(this);
	}
	
	public static Set<Spectacle> findAll() {
		return dao.findAll();
	}
	
	@Override
	public String toString() {
		return this.titre;
	}
}
