package be.vvd.dao;

import java.sql.Connection;

import be.vvd.classes.Utilisateur;
import be.vvd.connexion.*;

public class DAOFactory extends AbstractDAOFactory{
protected static final Connection conn = connexion.getInstance();
	public DAO<Utilisateur> getUtilisateurDAO() {
		return new UtilisateurDAO(conn);
	}
}
