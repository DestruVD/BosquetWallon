package be.vvd.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import be.vvd.classes.Representation;

public class RepresentationDAO implements DAO<Representation> {

	private Connection connect;
	
	public RepresentationDAO(Connection conn) {
		this.connect=conn;
	}
	
	@Override
	public boolean create(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}
	//SELECT * FROM Reservation INNER JOIN Spectacle ON Reservation.idSpectacle = Spectacle.id  WHERE idUtilisateur='"+user.getID()+"'
	public boolean create(Set<Representation> obj) {
		try {			
			for(var item : obj) {
				this.connect.createStatement().executeUpdate("INSERT INTO Representation VALUES(null,'"+item.getDate()+"','"+item.getHeureOuverture()+"','"+item.getHeureDebut()+"','"+item.getHeureFin()+"','"+item.getSpectacle().getID()+"')");
			}
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Representation find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Representation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
