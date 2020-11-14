package be.vvd.classes;

public class Client extends Utilisateur {
	
	private String numTel;
	
	public Client(String email,String password) {
		super(email,password);
	}
	
	public Client(String nom, String prenom, String adresse, String role, String email,String password, String numTel) {
		super(nom,prenom,adresse,role,email,password);
		this.numTel=numTel;
	}
	
	public String getTelephone() {
		return this.numTel;
	}
	
	public boolean register() {
		if(!Utilisateur.dao.findByEmail(this.email)) {			
			return Utilisateur.dao.create(this);
		}
		return false;
	}
}
