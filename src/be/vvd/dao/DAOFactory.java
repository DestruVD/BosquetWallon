package be.vvd.dao;

import java.sql.Connection;

import be.vvd.classes.Commande;
import be.vvd.classes.Place;
import be.vvd.classes.Representation;
import be.vvd.classes.Spectacle;
import be.vvd.classes.Utilisateur;
import be.vvd.connexion.*;

public class DAOFactory extends AbstractDAOFactory{
protected static final Connection conn = connexion.getInstance();
	public UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAO(conn);
	}
	public ReservationDAO getReservationDAO() {
		return new ReservationDAO(conn);
	}
	
	public CategorieDAO getCategorieDAO() {
		return new CategorieDAO(conn);
	}
	
	public ConfigurationDAO getConfigurationDAO() {
		return new ConfigurationDAO(conn);
	}
	
	public SpectacleDAO getSpectacleDAO() {
		return new SpectacleDAO(conn);
	}
	public RepresentationDAO getRepresentationDAO() {
		return new RepresentationDAO(conn);
	}
	public CommandeDAO getCommandeDAO() {
		return new CommandeDAO(conn);
	}
	public PlaceDAO getPlaceDAO() {
		return new PlaceDAO(conn);
	}
}
