package be.vvd.classes;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.UtilisateurDAO;

public class Utilisateur{
	
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String role;
	protected String email;
	protected String password;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static UtilisateurDAO dao = factory.getUtilisateurDAO();

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
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom=prenom;
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
	
	public boolean findByEmail() {
		return Utilisateur.dao.findByEmail(this.email);
	}
	public String login() {
		return Utilisateur.dao.login(this);
	}
}
