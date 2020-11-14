package be.vvd.classes;

public class Gestionnaire extends Utilisateur {
	private String numNationale;
	public Gestionnaire(String email,String password) {
		super(email,password);
	}
	
	public Gestionnaire(String nom, String prenom, String adresse, String role, String email,String password, String numNationale) {
		super(nom,prenom,adresse,role,email,password);
		this.numNationale=numNationale;
	}
	
	public String getNumNationale() {
		return this.numNationale;
	}
	
	public boolean register() {
		if(!Utilisateur.dao.findByEmail(this.email)) {			
			return Utilisateur.dao.create(this);
		}
		return false;
	}
}
