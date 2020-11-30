package be.vvd.classes;

import java.util.Set;

import be.vvd.dao.ConfigurationDAO;
import be.vvd.dao.DAOFactory;

public class Configuration {
	private long id;
	private String nomConfiguration;
	private Set<Categorie> listCateg;
	private Categorie categ;
	
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static ConfigurationDAO dao = factory.getConfigurationDAO();
	
	public Configuration(String nomConfiguration,Set<Categorie> listCateg) {
		this.nomConfiguration=nomConfiguration;
		this.listCateg=listCateg;
	}
	
	public Configuration(String nomConfiguration) {
		this.nomConfiguration=nomConfiguration;
	}
	
	public Configuration(Categorie categ) {
		this.categ=categ;
	}

	public void setID(long id) {
		this.id=id;
	}
	
	public Categorie getCateg() {
		return this.categ;
	}
	
	public long getID() {
		return this.id;
	}
	
	public String getNomConfig() {
		return this.nomConfiguration;
	}
	
	public Set<Categorie> getListCateg(){
		return this.listCateg;
	}
	
	public boolean ajouterConfig() {
		return dao.create(this);
	}
}
