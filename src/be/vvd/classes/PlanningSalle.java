package be.vvd.classes;

import java.util.Set;
import be.vvd.dao.DAOFactory;

public class PlanningSalle {
	private String dateDebutR;
	private String dateFinR;
	private Spectacle spectacle;
	
	public PlanningSalle(String dateDebutR, String dateFinR) {
		this.dateDebutR=dateDebutR;
		this.dateFinR=dateFinR;
	}
	
	public PlanningSalle(String dateDebutR, String dateFinR,Spectacle spectacle) {
		this.dateDebutR=dateDebutR;
		this.dateFinR=dateFinR;
		this.spectacle=spectacle;
	}
	
	public String getTitre(){
		return this.spectacle.getTitre();
	}
	
	public int getPlaceMax(){
		return this.spectacle.getPlaceMax();
	}
	
	public Spectacle getSpectacle(){
		return this.spectacle;
	}
	
	public String getDateDebutR(){
		return this.dateDebutR;
	}
	
	public String getDateFinR(){
		return this.dateFinR;
	}
}
