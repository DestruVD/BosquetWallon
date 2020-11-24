package be.vvd.classes;

import java.util.Set;

public class Artiste extends Utilisateur {
	private String numArtiste;
	public Artiste(String nom, String prenom, String adresse, String role, String email,String password, String numArtiste) {
		super(nom,prenom,adresse,role,email,password);
		this.numArtiste=numArtiste;
	}
	
	public Artiste(String nom, String prenom) {
		super.setNom(nom);
		super.setPrenom(prenom);
	}
	
	public String getNumArtiste() {
		return this.numArtiste;
	}
	
	public boolean register() {
		return dao.create(this);
	}
	
	public static Set<Artiste> findAllArtist(){
		return dao.findAllArtiste();
	}
}
