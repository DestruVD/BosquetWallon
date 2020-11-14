package be.vvd.classes;

public class Organisateur extends Utilisateur {
	
	private String numBanque;
	public Organisateur(String email,String password) {
		super(email,password);
	}
	
	public Organisateur(String nom, String prenom, String adresse, String role, String email,String password, String numBanque) {
		super(nom,prenom,adresse,role,email,password);
		this.numBanque=numBanque;
	}
	
	public String getNumBanque() {
		return this.numBanque;
	}
	
	public boolean register() {
		if(!Utilisateur.dao.findByEmail(this.email)) {			
			return Utilisateur.dao.create(this);
		}
		return false;
	}
}
