package be.vvd.dao;
import java.sql.*;

import javax.swing.JOptionPane;

import be.vvd.classes.Utilisateur;
import be.vvd.connexion.connexion;

public class test {

	public static void main(String[] args) throws SQLException {
		try {			
			/*Connection conn = connexion.getInstance();
			String requete="SELECT Nom FROM Utilisateur";
			Statement stmt = conn.createStatement();
			ResultSet res=stmt.executeQuery(requete);
			String nom;*/
			DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
			DAO<Utilisateur> dao = factory.getUtilisateurDAO();
			Utilisateur user = dao.find(2);
			System.out.println(user.getNom());
			/*while(res.next())
            {
                nom=res.getString(1);
                System.out.println(nom);
            }*/
		}catch(Exception err) {
			JOptionPane.showMessageDialog(null,"Classe de driver introuvable" + err.getMessage());
		}
	}

}
