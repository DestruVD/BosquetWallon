package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.vvd.classes.Artiste;
import be.vvd.classes.Categorie;
import be.vvd.classes.Configuration;
import be.vvd.classes.Spectacle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CreateSpectacle extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitre;
	private JTextField tfPlaceMax;
	private JTextField tfPrixOr;
	private JTextField tfPrixArgent;
	private JTextField tfPrixBronze;
	private JTextField tfPrixDiamant;
	private JTextField tfPrixPlaceDebout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateSpectacle frame = new CreateSpectacle();
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
	@SuppressWarnings("unchecked")
	public CreateSpectacle() {
		Set<Artiste> listArtiste = Artiste.findAllArtist();
		Set<String> listArtisteToAdd = new HashSet<>();
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
		
		JLabel lblCreateSpectacle = new JLabel("Cr\u00E9ation de spectacle");
		lblCreateSpectacle.setForeground(Color.WHITE);
		lblCreateSpectacle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateSpectacle.setBounds(267, 14, 140, 13);
		contentPane.add(lblCreateSpectacle);
		
		tfTitre = new JTextField();
		tfTitre.setBounds(122, 54, 96, 19);
		contentPane.add(tfTitre);
		tfTitre.setColumns(10);
		
		tfPlaceMax = new JTextField();
		tfPlaceMax.setBounds(482, 54, 96, 19);
		contentPane.add(tfPlaceMax);
		tfPlaceMax.setColumns(10);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(149, 31, 45, 13);
		contentPane.add(lblTitre);
		
		JLabel lblPlaceMax = new JLabel("Maximum d'achat de place par client");
		lblPlaceMax.setForeground(Color.WHITE);
		lblPlaceMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceMax.setBounds(428, 31, 211, 13);
		contentPane.add(lblPlaceMax);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateSpectacle.this.dispose();
				DashboardOrga dashboard = new DashboardOrga();
				dashboard.setVisible(true);
			}
		});
		btnRetour.setBounds(10, 10, 85, 21);
		contentPane.add(btnRetour);
		
		JLabel lblOr = new JLabel("Or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setForeground(Color.WHITE);
		lblOr.setBounds(190, 215, 96, 13);
		lblOr.setVisible(false);
		contentPane.add(lblOr);
		
		JLabel lblArgent = new JLabel("Argent");
		lblArgent.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgent.setForeground(Color.WHITE);
		lblArgent.setBounds(311, 167, 96, 13);
		lblArgent.setVisible(false);
		contentPane.add(lblArgent);
		
		JLabel lblBronze = new JLabel("Bronze");
		lblBronze.setHorizontalAlignment(SwingConstants.CENTER);
		lblBronze.setForeground(Color.WHITE);
		lblBronze.setBounds(190, 167, 96, 13);
		lblBronze.setVisible(false);
		contentPane.add(lblBronze);
		
		tfPrixOr = new JTextField();
		tfPrixOr.setColumns(10);
		tfPrixOr.setBounds(190, 238, 96, 19);
		tfPrixOr.setVisible(false);
		contentPane.add(tfPrixOr);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setBounds(122, 193, 37, 13);
		contentPane.add(lblPrix);
		
		tfPrixArgent = new JTextField();
		tfPrixArgent.setColumns(10);
		tfPrixArgent.setBounds(311, 190, 96, 19);
		tfPrixArgent.setVisible(false);
		contentPane.add(tfPrixArgent);
		
		tfPrixBronze = new JTextField();
		tfPrixBronze.setColumns(10);
		tfPrixBronze.setBounds(190, 190, 96, 19);
		tfPrixBronze.setVisible(false);
		contentPane.add(tfPrixBronze);
		
		tfPrixPlaceDebout = new JTextField();
		tfPrixPlaceDebout.setColumns(10);
		tfPrixPlaceDebout.setBounds(190, 190, 96, 19);
		tfPrixPlaceDebout.setVisible(false);
		contentPane.add(tfPrixPlaceDebout);
		
		JLabel lblDiamant = new JLabel("Diamant");
		lblDiamant.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiamant.setForeground(Color.WHITE);
		lblDiamant.setBounds(311, 215, 96, 13);
		lblDiamant.setVisible(false);
		contentPane.add(lblDiamant);
		
		tfPrixDiamant = new JTextField();
		tfPrixDiamant.setBounds(311, 238, 96, 19);
		tfPrixDiamant.setColumns(10);
		tfPrixDiamant.setVisible(false);
		contentPane.add(tfPrixDiamant);
		
		@SuppressWarnings("rawtypes")
		JComboBox CBConfig = new JComboBox();
		CBConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String config = (String) CBConfig.getSelectedItem();
				if(config=="Concert"){
					tfPrixPlaceDebout.setVisible(false);
					tfPrixDiamant.setVisible(false);
					lblDiamant.setVisible(false);
					lblOr.setVisible(true);
					lblArgent.setVisible(true);
					lblBronze.setVisible(true);
					tfPrixOr.setVisible(true);
					tfPrixArgent.setVisible(true);
					tfPrixBronze.setVisible(true);
				}else if(config=="Cirque") {
					tfPrixPlaceDebout.setVisible(false);
					lblOr.setVisible(true);
					lblArgent.setVisible(true);
					lblBronze.setVisible(true);
					tfPrixOr.setVisible(true);
					tfPrixArgent.setVisible(true);
					tfPrixBronze.setVisible(true);
					tfPrixDiamant.setVisible(true);
					lblDiamant.setVisible(true);
				}else {
					tfPrixPlaceDebout.setVisible(true);
					tfPrixDiamant.setVisible(false);
					lblDiamant.setVisible(false);
					lblOr.setVisible(false);
					lblArgent.setVisible(false);
					lblBronze.setVisible(false);
					tfPrixOr.setVisible(false);
					tfPrixArgent.setVisible(false);
					tfPrixBronze.setVisible(false);
				}
			}
		});
		CBConfig.setBounds(122, 134, 96, 21);
		CBConfig.addItem("Debout");
		CBConfig.addItem("Concert");
		CBConfig.addItem("Cirque");
		contentPane.add(CBConfig);
		
		JLabel lblConfig = new JLabel("Configuration");
		lblConfig.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfig.setForeground(Color.WHITE);
		lblConfig.setBounds(122, 108, 96, 13);
		contentPane.add(lblConfig);
		
		JComboBox CBArtiste = new JComboBox();
		for(var item : listArtiste ) { 
			CBArtiste.addItem(item.getNom()+" "+item.getPrenom());
		}
		CBArtiste.setBounds(456, 163, 150, 21);
		contentPane.add(CBArtiste);
		
		JButton btnAddArtiste = new JButton("Ajouter un artiste");
		
		btnAddArtiste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean exists=false;
				for(var item : listArtisteToAdd) {
					if(item.equals((String) CBArtiste.getSelectedItem())) {
						exists=true;
					}
				}
				if(!exists) {
					listArtisteToAdd.add((String) CBArtiste.getSelectedItem());
				}
			}
		});
		
		
		btnAddArtiste.setBounds(616, 163, 140, 21);
		contentPane.add(btnAddArtiste);
		
		JButton btnCreateSpectacle = new JButton("Ajouter");
		btnCreateSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomConfig = (String) CBConfig.getSelectedItem();
				Set<Categorie> listCateg = new HashSet<Categorie>();
				be.vvd.classes.Configuration config= new be.vvd.classes.Configuration(nomConfig);
				config.ajouterConfig();
				
				switch(nomConfig) {
				case "Debout": listCateg.add(new Categorie("debout",Integer.parseInt(tfPrixPlaceDebout.getText()),8000,8000,config.getID()));
					break;
				case "Concert": listCateg.add(new Categorie("or",Integer.parseInt(tfPrixOr.getText()),500,500,config.getID()));
								listCateg.add(new Categorie("argent",Integer.parseInt(tfPrixArgent.getText()),1500,1500,config.getID()));
								listCateg.add(new Categorie("bronze",Integer.parseInt(tfPrixBronze.getText()),3000,3000,config.getID()));
					break;
				case "Cirque": 	listCateg.add(new Categorie("diamant",Integer.parseInt(tfPrixDiamant.getText()),1000,1000,config.getID()));
								listCateg.add(new Categorie("or",Integer.parseInt(tfPrixOr.getText()),2000,2000,config.getID()));
								listCateg.add(new Categorie("argent",Integer.parseInt(tfPrixArgent.getText()),1500,1500,config.getID()));
								listCateg.add(new Categorie("bronze",Integer.parseInt(tfPrixBronze.getText()),1500,1500,config.getID()));
					break;
				}
				for(var item : listCateg) {
					item.ajouterCategorie();
				}
				
				String titre = tfTitre.getText();
				int placeMax = Integer.parseInt(tfPlaceMax.getText());
				
				Spectacle spec = new Spectacle(titre,placeMax,listArtisteToAdd,config.getID());
				spec.ajouterSpectacle();
				
				CreateSpectacle.this.dispose();
				DashboardOrga dashboard = new DashboardOrga();
				dashboard.setVisible(true);
			}
		});
		btnCreateSpectacle.setBounds(344, 341, 85, 21);
		contentPane.add(btnCreateSpectacle);
		
		JLabel lblListeArtiste = new JLabel("Liste des artistes inscrits");
		lblListeArtiste.setForeground(Color.WHITE);
		lblListeArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeArtiste.setBounds(446, 138, 165, 13);
		contentPane.add(lblListeArtiste);
	}
}
