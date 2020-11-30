package be.vvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import be.vvd.classes.Commande;


public class CommandeDAO implements DAO<Commande>{
	
	private Connection connect = null;
	
	public CommandeDAO(Connection connect) {
		this.connect=connect;
	}
	
	@Override
	public boolean create(Commande obj) {
		return false;
	}
	public long createAndSendID(Commande obj) {
		try {
			long idComm=0;
			PreparedStatement statement = this.connect.prepareStatement("INSERT INTO Commande VALUES(null,'"+obj.getCout()+"','"+obj.getModePaiement()+"','"+obj.getModeLivraison()+"','"+obj.getUser().getID()+"')",Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()) {
				idComm = res.getLong(1);
			}
			return idComm;
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Commande> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Commande> findAllByUserID(long userID) {
		try {
			Set<Commande> listCommands = new HashSet<Commande>();
			ResultSet res = this.connect.createStatement().executeQuery("SELECT * FROM Commande WHERE idUtilisateur='"+userID+"'");
			while(res.next()) {
				Commande com = new Commande(res.getLong("id"),res.getDouble("cout"),res.getString("modePaiement"),res.getString("modeLivraison"));
				listCommands.add(com);
			}
			return listCommands;
		}catch(SQLException e) {
			return null;
		}
	}
}
