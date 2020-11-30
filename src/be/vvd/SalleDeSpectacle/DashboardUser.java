package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.components.JSpinField;

import be.vvd.classes.Categorie;
import be.vvd.classes.Commande;
import be.vvd.classes.Configuration;
import be.vvd.classes.Place;
import be.vvd.classes.Representation;
import be.vvd.classes.Spectacle;
import be.vvd.classes.Utilisateur;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class DashboardUser extends JFrame {

	private JPanel contentPane;
	private Set<Spectacle> listSpec = new HashSet<Spectacle>();
	private Set<Representation> listRepres= new HashSet<Representation>();
	private Set<Categorie> listCateg= new HashSet<Categorie>();
	private Set<Place> listPlace= new HashSet<Place>();
	private double prix;
	int numberSpinBronze=0;
	int numberSpinArgent=0;
	int numberSpinOr=0;
	int numberSpinDiamant=0;
	int numberSpinDebout=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardUser frame = new DashboardUser(new Utilisateur());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private DashboardUser me;

	/**
	 * Create the frame.
	 */
	public DashboardUser(Utilisateur user) {
		me =this;
		listSpec = Spectacle.findAll();
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
		
		JButton btnDisconnect = new JButton("D\u00E9connexion");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connexion conn = new Connexion();
				DashboardUser.this.dispose();
				conn.setVisible(true);
			}
		});
		btnDisconnect.setBounds(658, 21, 116, 21);
		contentPane.add(btnDisconnect);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setBounds(66, 154, 116, 13);
		contentPane.add(lblPrix);
		
		JLabel lblPrixDebout = new JLabel("");
		lblPrixDebout.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixDebout.setForeground(Color.WHITE);
		lblPrixDebout.setBounds(66, 197, 116, 13);
		lblPrixDebout.setVisible(false);
		contentPane.add(lblPrixDebout);
		
		JLabel lblPrixBronze = new JLabel("");
		lblPrixBronze.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixBronze.setForeground(Color.WHITE);
		lblPrixBronze.setBounds(66, 197, 116, 13);
		lblPrixBronze.setVisible(false);
		contentPane.add(lblPrixBronze);
		
		JLabel lblPrixArgent = new JLabel("");
		lblPrixArgent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixArgent.setForeground(Color.WHITE);
		lblPrixArgent.setBounds(66, 231, 116, 13);
		lblPrixArgent.setVisible(false);
		contentPane.add(lblPrixArgent);
		
		JLabel lblPrixOr = new JLabel("");
		lblPrixOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixOr.setForeground(Color.WHITE);
		lblPrixOr.setBounds(66, 261, 116, 13);
		lblPrixOr.setVisible(false);
		contentPane.add(lblPrixOr);
		
		JLabel lblPrixDiamant = new JLabel("");
		lblPrixDiamant.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixDiamant.setForeground(Color.WHITE);
		lblPrixDiamant.setBounds(66, 292, 116, 13);
		lblPrixDiamant.setVisible(false);
		contentPane.add(lblPrixDiamant);
		
		JLabel lblType = new JLabel("Type");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(192, 154, 116, 13);
		contentPane.add(lblType);
		
		JLabel lblTypeDebout = new JLabel("Debout");
		lblTypeDebout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeDebout.setForeground(Color.WHITE);
		lblTypeDebout.setBounds(192, 197, 116, 13);
		lblTypeDebout.setVisible(false);
		contentPane.add(lblTypeDebout);
		
		JLabel lblTypeBronze = new JLabel("Bronze");
		lblTypeBronze.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeBronze.setForeground(Color.WHITE);
		lblTypeBronze.setBounds(192, 197, 116, 13);
		lblTypeBronze.setVisible(false);
		contentPane.add(lblTypeBronze);
		
		JLabel lblTypeArgent = new JLabel("Argent");
		lblTypeArgent.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeArgent.setForeground(Color.WHITE);
		lblTypeArgent.setBounds(192, 231, 116, 13);
		lblTypeArgent.setVisible(false);
		contentPane.add(lblTypeArgent);
		
		JLabel lblTypeOr = new JLabel("Or");
		lblTypeOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeOr.setForeground(Color.WHITE);
		lblTypeOr.setBounds(192, 261, 116, 13);
		lblTypeOr.setVisible(false);
		contentPane.add(lblTypeOr);
		
		JLabel lblTypeDiamant = new JLabel("Diamant");
		lblTypeDiamant.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeDiamant.setForeground(Color.WHITE);
		lblTypeDiamant.setBounds(192, 292, 116, 13);
		lblTypeDiamant.setVisible(false);
		contentPane.add(lblTypeDiamant);
		
		JLabel lblChoix = new JLabel("Choix");
		lblChoix.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoix.setForeground(Color.WHITE);
		lblChoix.setBounds(339, 154, 116, 13);
		contentPane.add(lblChoix);
		
		JLabel lblPrixToPayValue = new JLabel("");
		lblPrixToPayValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixToPayValue.setForeground(Color.WHITE);
		lblPrixToPayValue.setBounds(576, 402, 65, 13);
		lblPrixToPayValue.setText(Double.toString(me.prix));
		contentPane.add(lblPrixToPayValue);
		
		JButton btnMyCommands = new JButton("Mes commandes");
		btnMyCommands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardUser.this.dispose();
				MyCommands myCom = new MyCommands(user);
				myCom.setVisible(true);
			}
		});
		btnMyCommands.setBounds(469, 21, 149, 21);
		contentPane.add(btnMyCommands);
		
		JSpinField spinDebout = new JSpinField();
		spinDebout.setBounds(353, 194, 91, 20);
		spinDebout.setVisible(false);
		spinDebout.setMinimum(0);
		spinDebout.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				for(var categ : listCateg) {
					if(categ.getNomCateg().equals("debout")) {						
						if(spinDebout.getValue()>numberSpinDebout) {							
							me.prix= me.prix + categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinDebout=spinDebout.getValue();
						}else {
							me.prix= me.prix - categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinDebout=spinDebout.getValue();
						}
					}
				}
			}
		});
		contentPane.add(spinDebout);
		
		JSpinField spinBronze = new JSpinField();
		spinBronze.setBounds(353, 194, 91, 20);
		spinBronze.setVisible(false);
		spinBronze.setMinimum(0);
		spinBronze.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				for(var categ : listCateg) {
					if(categ.getNomCateg().equals("bronze")) {
						if(spinBronze.getValue()>numberSpinBronze) {							
							me.prix= me.prix + categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinBronze=spinBronze.getValue();
						}else {
							me.prix= me.prix - categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinBronze=spinBronze.getValue();
						}
					}
				}
			}
		});
		contentPane.add(spinBronze);
		
		JSpinField spinArgent = new JSpinField();
		spinArgent.setBounds(353, 228, 91, 20);
		spinArgent.setVisible(false);
		spinArgent.setMinimum(0);
		spinArgent.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				for(var categ : listCateg) {
					if(categ.getNomCateg().equals("argent")) {						
						if(spinArgent.getValue()>numberSpinArgent) {							
							me.prix= me.prix + categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinArgent=spinArgent.getValue();
						}else {
							me.prix= me.prix - categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinArgent=spinArgent.getValue();
						}
					}
				}
			}
		});
		contentPane.add(spinArgent);
		
		JSpinField spinOr = new JSpinField();
		spinOr.setBounds(353, 258, 91, 20);
		spinOr.setVisible(false);
		spinOr.setMinimum(0);
		spinOr.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				for(var categ : listCateg) {
					if(categ.getNomCateg().equals("or")) {						
						if(spinOr.getValue()>numberSpinOr) {							
							me.prix= me.prix + categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinOr=spinOr.getValue();
						}else {
							me.prix= me.prix - categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinOr=spinOr.getValue();
						}
					}
				}
			}
		});
		contentPane.add(spinOr);
		
		JSpinField spinDiamant = new JSpinField();
		spinDiamant.setBounds(353, 289, 91, 20);
		spinDiamant.setVisible(false);
		spinDiamant.setMinimum(0);
		spinDiamant.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				for(var categ : listCateg) {
					if(categ.getNomCateg().equals("diamant")) {						
						if(spinDiamant.getValue()>numberSpinDiamant) {							
							me.prix= me.prix + categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinDiamant=spinDiamant.getValue();
						}else {
							me.prix = me.prix - categ.getPrix();
							lblPrixToPayValue.setText(Double.toString(me.prix));
							numberSpinDiamant=spinDiamant.getValue();
						}
					}
				}
			}
		});
		contentPane.add(spinDiamant);
		
		JLabel lblChooseSpec = new JLabel("Choisissez un spectacle");
		lblChooseSpec.setForeground(Color.WHITE);
		lblChooseSpec.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseSpec.setBounds(40, 61, 217, 13);
		contentPane.add(lblChooseSpec);
		
		JLabel lblPlaceDispoDebout = new JLabel("");
		lblPlaceDispoDebout.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceDispoDebout.setForeground(Color.WHITE);
		lblPlaceDispoDebout.setBounds(502, 197, 116, 13);
		lblPlaceDispoDebout.setVisible(false);
		contentPane.add(lblPlaceDispoDebout);
		
		JLabel lblPlaceDispoBronze = new JLabel("");
		lblPlaceDispoBronze.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceDispoBronze.setForeground(Color.WHITE);
		lblPlaceDispoBronze.setBounds(502, 197, 116, 13);
		lblPlaceDispoBronze.setVisible(false);
		contentPane.add(lblPlaceDispoBronze);
		
		JLabel lblPlaceDispoArgent = new JLabel("");
		lblPlaceDispoArgent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceDispoArgent.setForeground(Color.WHITE);
		lblPlaceDispoArgent.setBounds(502, 231, 116, 13);
		lblPlaceDispoArgent.setVisible(false);
		contentPane.add(lblPlaceDispoArgent);
		
		JLabel lblPlaceDispoOr = new JLabel("");
		lblPlaceDispoOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceDispoOr.setForeground(Color.WHITE);
		lblPlaceDispoOr.setBounds(502, 261, 116, 13);
		lblPlaceDispoOr.setVisible(false);
		contentPane.add(lblPlaceDispoOr);
		
		JLabel lblPlaceDispoDiamant = new JLabel("");
		lblPlaceDispoDiamant.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceDispoDiamant.setForeground(Color.WHITE);
		lblPlaceDispoDiamant.setBounds(502, 292, 116, 13);
		lblPlaceDispoDiamant.setVisible(false);
		contentPane.add(lblPlaceDispoDiamant);
		
		JComboBox CBLivraison = new JComboBox();
		CBLivraison.setBounds(217, 361, 347, 21);
		CBLivraison.addItem("Reprendre les places sur place le jour du spectacle");
		CBLivraison.addItem("Se faire livrer les places par envoi avec timbres prior");
		CBLivraison.addItem("Se faire livrer les places par envoi sécurisé (+10 euros)");
		CBLivraison.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if(CBLivraison.getSelectedItem().equals("Se faire livrer les places par envoi sécurisé (+10 euros)")) {
					double prix = Double.parseDouble(lblPrixToPayValue.getText());
					lblPrixToPayValue.setText(Double.toString(prix+10.0));
					me.prix+=10;
				}else {
					double prix = Double.parseDouble(lblPrixToPayValue.getText());
					lblPrixToPayValue.setText(Double.toString(prix-10.0));
					me.prix-=10;
				}
			}
		});
		contentPane.add(CBLivraison);
		
		JComboBox CBPaiement = new JComboBox();
		CBPaiement.setBounds(40, 361, 110, 21);
		CBPaiement.addItem("Visa");
		CBPaiement.addItem("PayPal");
		CBPaiement.addItem("Sepa");
		contentPane.add(CBPaiement);
		
		JComboBox CBRepresentation = new JComboBox();
		CBRepresentation.setBounds(343, 94, 191, 21);
		CBRepresentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPrixDebout.setVisible(false);
				lblPrixBronze.setVisible(false);
				lblPrixArgent.setVisible(false);
				lblPrixOr.setVisible(false);
				lblPrixDiamant.setVisible(false);
				lblPlaceDispoDiamant.setVisible(false);
				lblPlaceDispoOr.setVisible(false);
				lblPlaceDispoArgent.setVisible(false);
				lblPlaceDispoBronze.setVisible(false);
				lblPlaceDispoDebout.setVisible(false);
				lblTypeDiamant.setVisible(false);
				lblTypeOr.setVisible(false);
				lblTypeArgent.setVisible(false);
				lblTypeBronze.setVisible(false);
				lblTypeDebout.setVisible(false);
				spinBronze.setVisible(false);
				spinBronze.setValue(0);
				spinArgent.setVisible(false);
				spinArgent.setValue(0);
				spinOr.setVisible(false);
				spinOr.setValue(0);
				spinDiamant.setVisible(false);
				spinDiamant.setValue(0);
				spinDebout.setVisible(false);
				spinDebout.setValue(0);
				me.prix=0.0;
				if(me.prix<0) {					
					lblPrixToPayValue.setText(Double.toString(me.prix+20.0));
				}else {
					lblPrixToPayValue.setText(Double.toString(me.prix));
				}
				String selectedRep = (String) CBRepresentation.getSelectedItem();
				if(!(selectedRep==null)) {					
					int index = selectedRep.lastIndexOf(':');
					long id = Long.parseLong(selectedRep.substring(0,index));
					Representation rep = new Representation(id);
					me.listCateg = rep.find();
					for(var categ : me.listCateg) {
						switch(categ.getNomCateg()) {
						case "diamant" : lblPrixDiamant.setVisible(true);
						lblPlaceDispoDiamant.setVisible(true);
						lblTypeDiamant.setVisible(true);
						spinDiamant.setVisible(true);
						lblPrixDiamant.setText(Double.toString(categ.getPrix()));
						lblPlaceDispoDiamant.setText(Integer.toString(categ.getNbrPlaceDispo()));
						break;
						case "or" : lblPrixOr.setVisible(true);
						lblPlaceDispoOr.setVisible(true);
						lblTypeOr.setVisible(true);
						spinOr.setVisible(true);
						lblPrixOr.setText(Double.toString(categ.getPrix()));
						lblPlaceDispoOr.setText(Integer.toString(categ.getNbrPlaceDispo()));
						break;
						case "argent" : lblPrixArgent.setVisible(true);
						lblPlaceDispoArgent.setVisible(true);
						lblTypeArgent.setVisible(true);
						spinArgent.setVisible(true);
						lblPrixArgent.setText(Double.toString(categ.getPrix()));
						lblPlaceDispoArgent.setText(Integer.toString(categ.getNbrPlaceDispo()));
						break;
						case "bronze" : lblPrixBronze.setVisible(true);
						lblPlaceDispoBronze.setVisible(true);
						lblTypeBronze.setVisible(true);
						spinBronze.setVisible(true);
						lblPrixBronze.setText(Double.toString(categ.getPrix()));
						lblPlaceDispoBronze.setText(Integer.toString(categ.getNbrPlaceDispo()));
						break;
						default: lblPrixDebout.setVisible(true);
						lblPlaceDispoDebout.setVisible(true);
						lblTypeDebout.setVisible(true);
						spinDebout.setVisible(true);
						lblPrixDebout.setText(Double.toString(categ.getPrix()));
						lblPlaceDispoDebout.setText(Integer.toString(categ.getNbrPlaceDispo()));
						}
					}
				}
			}
		});
		contentPane.add(CBRepresentation);
		
		JComboBox CBSpectacle = new JComboBox();
		CBSpectacle.setBounds(40, 94, 217, 21);
		for(var spec : listSpec) {
			CBSpectacle.addItem(spec.getTitre());
		}
		CBSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPrixToPayValue.setText("0.0");
				CBRepresentation.removeAllItems();
				me.listRepres = new HashSet<Representation>();
				for(var spec : me.listSpec) {				
					if(CBSpectacle.getSelectedItem().equals(spec.getTitre())) {
						Representation rep = new Representation(spec);
						listRepres = rep.findBySpectacleID();
						if(listRepres.isEmpty()) {
							JOptionPane.showMessageDialog(null,"Il n'y a pas de représentation de ce spectacle !");
						}else {							
							for(var repFromList : listRepres) {							
								CBRepresentation.addItem(repFromList.getID()+": "+repFromList.getDate()+" | "+repFromList.getHeureDebut()+"h à "+repFromList.getHeureFin()+"h");
							}
						}
					}
				}
			}
		});
		contentPane.add(CBSpectacle);
		
		JLabel lblChooseRep = new JLabel("Choisissez une repr\u00E9sentation");
		lblChooseRep.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseRep.setForeground(Color.WHITE);
		lblChooseRep.setBounds(322, 61, 240, 13);
		contentPane.add(lblChooseRep);
		
		JLabel lblPlaceDispo = new JLabel("Place disponibles");
		lblPlaceDispo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceDispo.setForeground(Color.WHITE);
		lblPlaceDispo.setBounds(502, 154, 127, 13);
		contentPane.add(lblPlaceDispo);
		
		JButton btnCommande = new JButton("Commander");
		btnCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(var spec : me.listSpec) {				
					if(CBSpectacle.getSelectedItem().equals(spec.getTitre())) {
						int spinDiamantValue=spinDiamant.getValue();
						int spinOrValue=spinOr.getValue();
						int spinArgentValue=spinArgent.getValue();
						int spinBronzeValue=spinBronze.getValue();
						int spinDeboutValue=spinDebout.getValue();
						int addition = spinDiamantValue+spinOrValue+spinArgentValue+spinBronzeValue+spinDeboutValue;
						if(spec.getPlaceMax()<addition) {
							JOptionPane.showMessageDialog(null,"Nombre de place max : "+spec.getPlaceMax()+". Vous en avez commandé : "+addition);
						}else {
							long idDiamant=0;
							long idOr=0;
							long idArgent=0;
							long idBronze=0;
							long idDebout=0;
							String Repres = (String) CBRepresentation.getSelectedItem();
							if(!(Repres==null)) {								
								int lastIndex = Repres.lastIndexOf(':');
								long idRepres = Long.parseLong(Repres.substring(0,lastIndex));
								for(var categ : me.listCateg) {
									switch(categ.getNomCateg()) {
									case "diamant": idDiamant=categ.getID();
									Categorie categDiam = new Categorie(idDiamant,(categ.getNbrPlaceDispo()-spinDiamantValue));
									Configuration configDiam = new Configuration(categDiam);
									Spectacle specDiam = new Spectacle(configDiam);
									Representation repreDiam = new Representation(idRepres,specDiam);
									repreDiam.update();
									lblPlaceDispoDiamant.setText(Integer.toString(categ.getNbrPlaceDispo()-spinDiamantValue));
									for(var repFromList : listRepres) {
										if(idRepres==repFromList.getID()) {														
											for(int i = 0 ; i< spinDiamantValue ; i++) {
												Place place= new Place("Diamant",categ.getPrix(),repFromList);
												listPlace.add(place);
											}
										}
									}
									break;
									case "or": idOr=categ.getID();
									Categorie categOr = new Categorie(idOr,(categ.getNbrPlaceDispo()-spinOrValue));
									Configuration configOr = new Configuration(categOr);
									Spectacle specOr = new Spectacle(configOr);
									Representation repreOr = new Representation(idRepres,specOr);
									repreOr.update();
									lblPlaceDispoOr.setText(Integer.toString(categ.getNbrPlaceDispo()-spinOrValue));
									for(var repFromList : listRepres) {
										if(idRepres==repFromList.getID()) {														
											for(int i = 0 ; i< spinOrValue ; i++) {
												Place place= new Place("Or",categ.getPrix(),repFromList);
												listPlace.add(place);
											}
										}
									}
									break;
									case "argent": idArgent=categ.getID();
									Categorie categArgent = new Categorie(idArgent,(categ.getNbrPlaceDispo()-spinArgentValue));
									Configuration configArgent = new Configuration(categArgent);
									Spectacle specArgent = new Spectacle(configArgent);
									Representation repreArgent = new Representation(idRepres,specArgent);
									repreArgent.update();
									lblPlaceDispoArgent.setText(Integer.toString(categ.getNbrPlaceDispo()-spinArgentValue));
									for(var repFromList : listRepres) {
										if(idRepres==repFromList.getID()) {														
											for(int i = 0 ; i< spinArgentValue ; i++) {
												Place place= new Place("Argent",categ.getPrix(),repFromList);
												listPlace.add(place);
											}
										}
									}
									break;
									case "bronze": idBronze=categ.getID();
									Categorie categBronze = new Categorie(idBronze,(categ.getNbrPlaceDispo()-spinBronzeValue));
									Configuration configBronze = new Configuration(categBronze);
									Spectacle specBronze = new Spectacle(configBronze);
									Representation repreBronze = new Representation(idRepres,specBronze);
									repreBronze.update();
									lblPlaceDispoBronze.setText(Integer.toString(categ.getNbrPlaceDispo()-spinBronzeValue));
									for(var repFromList : listRepres) {
										if(idRepres==repFromList.getID()) {														
											for(int i = 0 ; i< spinBronzeValue ; i++) {
												Place place= new Place("Bronze",categ.getPrix(),repFromList);
												listPlace.add(place);
											}
										}
									}
									break;
									default: idDebout=categ.getID();
									Categorie categDebout = new Categorie(idDebout,(categ.getNbrPlaceDispo()-spinDeboutValue));
									Configuration configDebout = new Configuration(categDebout);
									Spectacle specDebout = new Spectacle(configDebout);
									Representation repreDebout = new Representation(idRepres,specDebout);
									repreDebout.update();
									lblPlaceDispoDebout.setText(Integer.toString(categ.getNbrPlaceDispo()-spinDeboutValue));
									for(var repFromList : listRepres) {
										if(idRepres==repFromList.getID()) {														
											for(int i = 0 ; i< spinDeboutValue ; i++) {
												Place place= new Place("Debout",categ.getPrix(),repFromList);
												listPlace.add(place);
											}
										}
									}
									break;
									}
								}
							}
							if(spinDeboutValue==0 && spinBronzeValue==0 && spinArgentValue==0 && spinOrValue==0 && spinDiamantValue==0) {
								JOptionPane.showMessageDialog(null,"Aucun ticket de sélectionné");
							}else {								
								long idCommande=0;
								Commande comm = new Commande(listPlace,(String)CBPaiement.getSelectedItem(),(String)CBLivraison.getSelectedItem(),user);
								idCommande=comm.create();
								for(var place : listPlace) {
									place.create(idCommande);
								}
								JOptionPane.showMessageDialog(null,"Votre commande à été effectuée");
							}
						}
					}
				}
			}
		});
		btnCommande.setBounds(658, 398, 116, 21);
		contentPane.add(btnCommande);
		
		JLabel lblPrixToPay = new JLabel("Prix \u00E0 payer :");
		lblPrixToPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrixToPay.setForeground(Color.WHITE);
		lblPrixToPay.setBounds(469, 402, 116, 13);
		contentPane.add(lblPrixToPay);
		
		JLabel lblModePaiement = new JLabel("Mode de paiement");
		lblModePaiement.setForeground(Color.WHITE);
		lblModePaiement.setHorizontalAlignment(SwingConstants.CENTER);
		lblModePaiement.setBounds(24, 331, 143, 13);
		contentPane.add(lblModePaiement);
		
		JLabel lblModeLivraison = new JLabel("Mode de paiement");
		lblModeLivraison.setHorizontalAlignment(SwingConstants.CENTER);
		lblModeLivraison.setForeground(Color.WHITE);
		lblModeLivraison.setBounds(217, 331, 345, 13);
		contentPane.add(lblModeLivraison);
	}
}
