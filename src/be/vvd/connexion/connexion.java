package be.vvd.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class connexion {
private static Connection instance = null;
	
	private connexion(){
		try{
			String url = "jdbc:sqlite:./bin/be/vvd/connexion/bosquetDB.db";
			instance = DriverManager.getConnection(url);
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) {
            JOptionPane.showMessageDialog(null, "La base de données est inaccessible, fermeture du programme.");
            System.exit(0);
        }
	}
	
	public static Connection getInstance() {
		if(instance == null){
			new connexion();
		}
		return instance;
	}
}
