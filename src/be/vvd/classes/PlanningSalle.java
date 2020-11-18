package be.vvd.classes;

import java.util.Set;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.PlanningSalleDAO;

public class PlanningSalle {
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static PlanningSalleDAO dao = factory.getPlanningSalleDAO();
	
	private String dateDebutR;
	private String dateFinR;
	
	public PlanningSalle(String dateDebutR, String dateFinR) {
		this.dateDebutR=dateDebutR;
		this.dateFinR=dateFinR;
	}
	
	public String getDateDebutR(){
		return this.dateDebutR;
	}
	
	public String getDateFinR(){
		return this.dateFinR;
	}
	
	public boolean ajouterRepresentation() {
		return PlanningSalle.dao.create(this);
	}
	
	public static Set<PlanningSalle> findAll(){
		return PlanningSalle.dao.findAll();
	}
}
