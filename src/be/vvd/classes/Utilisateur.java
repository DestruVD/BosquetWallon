package be.vvd.classes;
import java.io.Serializable;

public class Utilisateur implements Serializable {
	
	private int id = 0;
	private String nom = "";
	private String prenom = "";
	private String adresse = "";
	
	public Utilisateur(int id, String nom, String prenom, String adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
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

	public Utilisateur() {}
}
