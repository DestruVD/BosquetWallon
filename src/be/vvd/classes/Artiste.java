package be.vvd.classes;

public class Artiste extends Utilisateur {
	private String numArtiste;
	public Artiste(String nom, String prenom, String adresse, String role, String email,String password, String numArtiste) {
		super(nom,prenom,adresse,role,email,password);
		this.numArtiste=numArtiste;
	}
	
	public String getNumArtiste() {
		return this.numArtiste;
	}
}
