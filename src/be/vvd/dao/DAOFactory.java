package be.vvd.dao;

import java.sql.Connection;

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
	public SpectacleDAO getSpectacleDAO() {
		return new SpectacleDAO(conn);
	}
}
