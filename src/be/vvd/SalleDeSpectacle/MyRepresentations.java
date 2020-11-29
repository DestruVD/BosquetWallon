package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.components.JSpinField;

import be.vvd.classes.Representation;
import be.vvd.classes.Reservation;
import be.vvd.classes.Spectacle;
import be.vvd.classes.Utilisateur;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class MyRepresentations extends JFrame {

	private JPanel contentPane;
	private Set<Representation> listRepreFromDB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyRepresentations frame = new MyRepresentations(new Utilisateur());
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
	public MyRepresentations(Utilisateur user) {
		Set<Representation> listRepre = new HashSet<Representation>();
		setResizable(false);
		Set<Reservation> listRes = Reservation.findAllByUser(user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 447);
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
				MyRepresentations.this.dispose();
				DashboardOrga dash =  new DashboardOrga(user);
				dash.setVisible(true);
			}
		});
		btnRetour.setBounds(10, 10, 85, 21);
		contentPane.add(btnRetour);
		
		JLabel lblMyRep = new JLabel("Mes repr\u00E9sentation");
		lblMyRep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMyRep.setForeground(Color.WHITE);
		lblMyRep.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyRep.setBounds(141, 10, 173, 29);
		contentPane.add(lblMyRep);
		
		JComboBox CBDateRepre = new JComboBox();
		CBDateRepre.setMaximumRowCount(1000);
		CBDateRepre.setBounds(222, 119, 190, 21);
		contentPane.add(CBDateRepre);
		
		JComboBox CBDate = new JComboBox();
		CBDate.setMaximumRowCount(1000);
		for(var item : listRes) {
			CBDate.addItem(item.getDateDebutR()+" au "+item.getDateFinR());
		}
		CBDate.setBounds(10, 119, 183, 21);
		CBDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CBDateRepre.removeAllItems();
				long id=0;
				for(var item : listRes) {
					String date = item.getDateDebutR()+ " au "+item.getDateFinR();
					if(CBDate.getSelectedItem().equals(date)) {
						id=item.getID();
						Representation repr = new Representation(item.getPlanning().getSpectacle());
						MyRepresentations.this.listRepreFromDB = repr.findBySpectacleID();
						listRepre.clear();
						String dateDebut = item.getDateDebutR();
						String dateFin = item.getDateFinR();
						
						String dayDebutR = dateDebut.substring(0,2);
	    				String monthDebutR= dateDebut.substring(3,5);
	    				String yearDebutR= dateDebut.substring(6,10);
	    				
	    				String dayFinR = dateFin.substring(0,2);
	    				String monthFinR= dateFin.substring(3,5);
	    				String yearFinR= dateFin.substring(6,10);
						
						if(dayDebutR.lastIndexOf('0')==0) {
	    	    			dayDebutR = dayDebutR.substring(1,2);
	    	    		}
	    	    		
	    	    		if(dayFinR.lastIndexOf('0')==0) {
	    	    			dayFinR = dayFinR.substring(1,2);
	    	    		}
	    	    		
	    	    		int dayDebutRInt = Integer.parseInt(dayDebutR);
	    				int monthDebutRInt = Integer.parseInt(monthDebutR);
	    				int yearDebutRInt = Integer.parseInt(yearDebutR);
	    				
	    				be.vvd.classes.Date dateDebutR = new be.vvd.classes.Date(dayDebutRInt,monthDebutRInt,yearDebutRInt);
	    				
	    				int dayFinRInt = Integer.parseInt(dayFinR);
	    				int monthFinRInt = Integer.parseInt(monthFinR);
	    				int yearFinRInt = Integer.parseInt(yearFinR);
	    				
	    				be.vvd.classes.Date dateFinR = new be.vvd.classes.Date(dayFinRInt,monthFinRInt,yearFinRInt);
	    				
	    				int jourEntreDates = be.vvd.classes.Date.betweenTwoDate(dateDebutR, dateFinR);
	    				
	    				for(int i=0;i<=jourEntreDates;i++) {
							if(dateDebutR.getDay()<dateDebutR.getDayPerMonth()[dateDebutR.getMonth()-1]) {
								String day = Integer.toString(dateDebutR.getDay());
								if(Integer.parseInt(day)<10) {
									day = '0'+day;
								}
								String month = Integer.toString(dateDebutR.getMonth());
								if(Integer.parseInt(month)<10) {
									month = '0'+month;
								}
								String year = Integer.toString(dateDebutR.getYear());
								CBDateRepre.addItem(day+'-'+month+'-'+year);
								if(dateDebutR.getDayPerMonth()[dateDebutR.getMonth()-1]-1==Integer.parseInt(day)) {
									int dayInt = Integer.parseInt(day);
									dayInt++;
									day=Integer.toString(dayInt);
									CBDateRepre.addItem(day+'-'+month+'-'+year);
								}
								dateDebutR.add1Day();
							}else {
								dateDebutR.setDay(1);
								if(dateDebutR.getMonth()<dateDebutR.getDayPerMonth().length) {
									dateDebutR.add1Month();
								}else {
									dateDebutR.setMonth(1);
									dateDebutR.add1Year();
									boolean bool = be.vvd.classes.Date.isBissextile(dateDebutR.getYear());
									if(bool) {
										dateDebutR.setDayPerMonth(1,29);
									}else {
										dateDebutR.setDayPerMonth(1,28);
									}
								}
							}
						}
					}
				}
			}
		});
		contentPane.add(CBDate);
		
		JLabel lblNewLabel = new JLabel("Selectionner une r\u00E9servation");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 83, 183, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblSlectionnerUneDate = new JLabel("S\u00E9lectionner une date");
		lblSlectionnerUneDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlectionnerUneDate.setForeground(Color.WHITE);
		lblSlectionnerUneDate.setBounds(222, 83, 190, 13);
		contentPane.add(lblSlectionnerUneDate);
		
		JSpinField jspinHeureOuverture = new JSpinField();
		jspinHeureOuverture.setBounds(52, 195, 102, 20);
		jspinHeureOuverture.setMinimum(0);
		jspinHeureOuverture.setMaximum(24);
		contentPane.add(jspinHeureOuverture);
		
		JSpinField jspinHeureDebut = new JSpinField();
		jspinHeureDebut.setBounds(267, 195, 102, 20);
		jspinHeureDebut.setMinimum(0);
		jspinHeureDebut.setMaximum(24);
		contentPane.add(jspinHeureDebut);
		
		JSpinField jspinHeureFin = new JSpinField();
		jspinHeureFin.setBounds(52, 274, 102, 20);
		jspinHeureFin.setMinimum(0);
		jspinHeureFin.setMaximum(24);
		contentPane.add(jspinHeureFin);
		
		JButton btnAddRepre = new JButton("Ajouter  une repr\u00E9sentation");
		btnAddRepre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bool=true;
				boolean createRepres=true;
				Reservation res=null;
 				String date = (String) CBDateRepre.getSelectedItem();
				int heureOuverture = jspinHeureOuverture.getValue();
				int heureDebut = jspinHeureDebut.getValue();
				int heureFin = jspinHeureFin.getValue();
				if(date==null) {
					JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs");
					bool=false;
				} 						
				if(CBDateRepre.getSelectedIndex()==0 && (heureOuverture<12 || heureDebut < 12 || heureFin<12 )) {
					JOptionPane.showMessageDialog(null,"Vous ne pouvez pas r�server le premier jour avant 12h");
					bool=false;
				}
				
				if(CBDateRepre.getSelectedIndex()==CBDateRepre.getItemCount()-1 && (heureOuverture>12 || heureDebut > 12 || heureFin>12 )) {
					JOptionPane.showMessageDialog(null,"Vous ne pouvez pas r�server le dernier apr�s 12h");
					bool=false;
				}
				if(bool) {
					int heureDebutBis = jspinHeureDebut.getValue();
					int heureFinBis = jspinHeureFin.getValue();
					for(var itemRep : MyRepresentations.this.listRepreFromDB) {
						if(itemRep.getDate().equals((String)CBDateRepre.getSelectedItem())) {
							Set<Integer> compteEntreLesHeures = new HashSet<Integer>();
							int heureCopy = Integer.parseInt(itemRep.getHeureDebut());
							while(heureCopy<=Integer.parseInt(itemRep.getHeureFin())) {
								compteEntreLesHeures.add(heureCopy); 
								heureCopy++;
							}
							if(compteEntreLesHeures.contains(heureDebutBis) || compteEntreLesHeures.contains(heureFinBis)) {
								createRepres=false;
							}
						}
					}
					if(createRepres) {						
						for(var item : listRes) {
							String date2 = item.getDateDebutR()+ " au "+item.getDateFinR();
							if(CBDate.getSelectedItem().equals(date2)) {
								res = item.getReservationByID();
							}
						}
						Representation repres = new Representation(date,Integer.toString(heureOuverture),Integer.toString(heureDebut),Integer.toString(heureFin),res.getPlanning().getSpectacle());
						listRepre.add(repres);
						listRepreFromDB.add(repres);
						JOptionPane.showMessageDialog(null,"Repr�sentation ajout�e dans la liste");
					}else {
						JOptionPane.showMessageDialog(null,"Ces heures sont d�j� r�serv�es pour ce jour");
					}
				}
			}
		});
		btnAddRepre.setBounds(207, 273, 205, 21);
		contentPane.add(btnAddRepre);
		
		JLabel lblHeureOuverture = new JLabel("Heure d'ouverture");
		lblHeureOuverture.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureOuverture.setForeground(Color.WHITE);
		lblHeureOuverture.setBounds(10, 172, 183, 13);
		contentPane.add(lblHeureOuverture);
		
		JLabel lblHeureDebut = new JLabel("Heure d\u00E9but");
		lblHeureDebut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureDebut.setForeground(Color.WHITE);
		lblHeureDebut.setBounds(229, 172, 183, 13);
		contentPane.add(lblHeureDebut);
		
		JLabel lblHeureFin = new JLabel("HeureFin");
		lblHeureFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeureFin.setForeground(Color.WHITE);
		lblHeureFin.setBounds(10, 251, 183, 13);
		contentPane.add(lblHeureFin);
		
		JButton btnAddRepresInDb = new JButton("Creer la/les repr\u00E9sentation(s)");
		btnAddRepresInDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listRepre.isEmpty()) {					
					Representation.addListRepresentation(listRepre);
					JOptionPane.showMessageDialog(null,"Vos repr�sentations ont �t� cr��e");
				}else {
					JOptionPane.showMessageDialog(null,"Vous n'avez ajout� aucune repr�sentation");
				}
			}
		});
		btnAddRepresInDb.setBounds(222, 376, 203, 21);
		contentPane.add(btnAddRepresInDb);
	}
}
