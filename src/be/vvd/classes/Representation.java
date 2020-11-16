package be.vvd.classes;

import java.util.HashSet;
import java.util.Set;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.RepresentationDAO;
import be.vvd.dao.UtilisateurDAO;

public class Representation {
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static RepresentationDAO dao = factory.getRepresentationDAO();
	
	private String date;
	
	public Representation(String date) {
		this.date=date;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public boolean ajouterRepresentation() {
		return Representation.dao.create(this);
	}
	
	public static Set<Representation> findAll(){
		return Representation.dao.findAll();
	}
}
