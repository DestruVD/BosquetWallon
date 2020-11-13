package be.vvd.classes;
import java.io.Serializable;

public class Utilisateur implements Serializable {
	
	private String nom = "";
	private String prenom = "";
	private String adresse = "";
	private String role = "";
	private String email = "";

	public Utilisateur() {}
	
	public Utilisateur(String nom, String prenom, String adresse, String role, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.role=role;
		this.email=email;
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
}
