package be.vvd.classes;

import java.util.Set;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.PlanningSalleDAO;

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
	
	public String getDateDebutR(){
		return this.dateDebutR;
	}
	
	public String getDateFinR(){
		return this.dateFinR;
	}
}
