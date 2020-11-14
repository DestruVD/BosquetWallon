package be.vvd.classes;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.UtilisateurDAO;

public class Utilisateur{
	
	private String nom = "";
	private String prenom = "";
	private String adresse = "";
	private String role = "";
	private String email = "";
	private String password ="";
	
	private static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	private static UtilisateurDAO dao = factory.getUtilisateurDAO();

	public Utilisateur() {}
	
	public Utilisateur(String nom, String prenom, String adresse, String role, String email,String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.role=role;
		this.email=email;
		this.password=password;
	}
	
	public Utilisateur(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public String getRole() {
		return this.role;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean login() {
		return Utilisateur.dao.login(this);
	}
}
