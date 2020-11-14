package be.vvd.classes;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.RepresentationDAO;
import be.vvd.dao.UtilisateurDAO;

public class Representation {
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static RepresentationDAO dao = factory.getRepresentationDAO();
	
	private java.sql.Date date;
	
	public Representation(java.sql.Date date) {
		this.date=date;
	}
	
	public java.sql.Date getDate(){
		return this.date;
	}
	
	public boolean ajouterRepresentation() {
		return Representation.dao.create(this);
	}
}
