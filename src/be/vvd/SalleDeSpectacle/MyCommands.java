package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.vvd.classes.Commande;
import be.vvd.classes.Place;
import be.vvd.classes.Utilisateur;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class MyCommands extends JFrame {

	private JPanel contentPane;
	private Set<Commande> listCommand = new HashSet<Commande>();
	private Set<Place> listPlace = new HashSet<Place>();
	private int idCommande;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCommands frame = new MyCommands(new Utilisateur());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyCommands(Utilisateur user) {
		this.listCommand=Commande.findAllByUserID(user.getID());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 470);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("theatre.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
          }; 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyCommands.this.dispose();
				DashboardUser dUser = new DashboardUser(user);
				dUser.setVisible(true);
			}
		});
		btnRetour.setBounds(10, 10, 85, 21);
		contentPane.add(btnRetour);
		
		JLabel lblMesCommandes = new JLabel("Mes commandes");
		lblMesCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesCommandes.setForeground(Color.WHITE);
		lblMesCommandes.setBounds(316, 37, 98, 13);
		contentPane.add(lblMesCommandes);
		JLabel lblCout = new JLabel("Cout : ");
		lblCout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCout.setForeground(Color.WHITE);
		lblCout.setBounds(103, 184, 141, 13);
		contentPane.add(lblCout);
		
		JLabel lblCoutValue = new JLabel("");
		lblCoutValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoutValue.setForeground(Color.WHITE);
		lblCoutValue.setBounds(103, 207, 141, 13);
		contentPane.add(lblCoutValue);
		
		JLabel lblModeDePaiement = new JLabel("Mode de paiement :");
		lblModeDePaiement.setHorizontalAlignment(SwingConstants.CENTER);
		lblModeDePaiement.setForeground(Color.WHITE);
		lblModeDePaiement.setBounds(259, 184, 141, 13);
		contentPane.add(lblModeDePaiement);
		
		JLabel lblModeDeLivraison = new JLabel("Mode de livraison  :");
		lblModeDeLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblModeDeLivraison.setForeground(Color.WHITE);
		lblModeDeLivraison.setBounds(415, 184, 141, 13);
		contentPane.add(lblModeDeLivraison);
		
		JLabel lblPayValue = new JLabel("");
		lblPayValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayValue.setForeground(Color.WHITE);
		lblPayValue.setBounds(269, 207, 141, 13);
		contentPane.add(lblPayValue);
		
		JLabel lblLivraisonValue = new JLabel("");
		lblLivraisonValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivraisonValue.setForeground(Color.WHITE);
		lblLivraisonValue.setBounds(425, 207, 258, 13);
		contentPane.add(lblLivraisonValue);
		
		JLabel lblChooseCommand = new JLabel("S\u00E9lectionnez une commande");
		lblChooseCommand.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseCommand.setForeground(Color.WHITE);
		lblChooseCommand.setBounds(51, 77, 181, 13);
		contentPane.add(lblChooseCommand);
		
		JLabel lblTypeValue = new JLabel("");
		lblTypeValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeValue.setForeground(Color.WHITE);
		lblTypeValue.setBounds(412, 106, 98, 13);
		contentPane.add(lblTypeValue);
		
		JLabel lblPrixValue = new JLabel("");
		lblPrixValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixValue.setForeground(Color.WHITE);
		lblPrixValue.setBounds(521, 106, 98, 13);
		contentPane.add(lblPrixValue);
		
		JComboBox CBPlace = new JComboBox();
		CBPlace.setBounds(249, 102, 135, 21);
		CBPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(var place : listPlace) {
					String selectedItem = (String)CBPlace.getSelectedItem();
					if(!(selectedItem==null)) {						
						int index = selectedItem.lastIndexOf(':');
						int id = Integer.parseInt(selectedItem.substring(0,index));
						if(id==place.getID()) {
							lblPrixValue.setText(Double.toString(place.getPrix()));
							lblTypeValue.setText(place.getType());
						}
					}
				}
			}
		});
		contentPane.add(CBPlace);
		
		JComboBox CBCommand = new JComboBox();
		CBCommand.setBounds(71, 102, 135, 21);
		for(var command : this.listCommand) {
			CBCommand.addItem(command.getID()+": "+command.getCout());
		}
		CBCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CBPlace.removeAllItems();
				lblCoutValue.setText("");
				lblPayValue.setText("");
				lblLivraisonValue.setText("");
				for(var command : MyCommands.this.listCommand) {
					String selectedItem = (String)CBCommand.getSelectedItem();
					int index = selectedItem.lastIndexOf(':');
					MyCommands.this.idCommande = Integer.parseInt(selectedItem.substring(0,index));
					if(command.getID()==MyCommands.this.idCommande) {
						lblCoutValue.setText(Double.toString(command.getCout()));
						lblPayValue.setText(command.getModePaiement());
						lblLivraisonValue.setText(command.getModeLivraison());
					}
				}
				listPlace = Place.findAllByCommandID(MyCommands.this.idCommande);
				for(var place : listPlace) {
					CBPlace.addItem(place.getID()+": "+place.getType());
				}
			}
		});
		contentPane.add(CBCommand);
		
		JLabel lblInfoCommands = new JLabel("Information de la commande");
		lblInfoCommands.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoCommands.setForeground(Color.WHITE);
		lblInfoCommands.setBounds(51, 150, 248, 13);
		contentPane.add(lblInfoCommands);
		
		JLabel lblPlace = new JLabel("S\u00E9lectionnez une place");
		lblPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlace.setForeground(Color.WHITE);
		lblPlace.setBounds(233, 77, 181, 13);
		contentPane.add(lblPlace);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(415, 77, 85, 13);
		contentPane.add(lblType);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setBounds(520, 77, 85, 13);
		contentPane.add(lblPrix);
	}
}
