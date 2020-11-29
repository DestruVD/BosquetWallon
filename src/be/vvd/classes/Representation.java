package be.vvd.classes;

import java.util.Set;

import be.vvd.dao.DAOFactory;
import be.vvd.dao.RepresentationDAO;
import be.vvd.dao.ReservationDAO;

public class Representation {
	private String date;
	private String heureOuverture;
	private String heureDebut;
	private String heureFin;
	private Spectacle spec;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static RepresentationDAO dao = factory.getRepresentationDAO();
	
	public Representation(String date,String heureOuverture,String heureDebut,String heureFin,Spectacle spec) {
		this.date=date;
		this.heureOuverture=heureOuverture;
		this.heureDebut=heureDebut;
		this.heureFin=heureFin;
		this.spec=spec;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getHeureOuverture() {
		return this.heureOuverture;
	}
	
	public String getHeureDebut() {
		return this.heureDebut;
	}
	
	public String getHeureFin() {
		return this.heureFin;
	}
	
	public Spectacle getSpectacle() {
		return this.spec;
	}
	
	public static boolean addListRepresentation(Set<Representation> list) {
		return dao.create(list);
	}
}
