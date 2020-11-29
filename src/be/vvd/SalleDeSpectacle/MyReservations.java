package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.vvd.classes.Categorie;
import be.vvd.classes.Reservation;
import be.vvd.classes.Spectacle;
import be.vvd.classes.Utilisateur;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Label;

public class MyReservations extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyReservations frame = new MyReservations(new Utilisateur());
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
	public MyReservations(Utilisateur user) {
		setResizable(false);
		Set<Reservation> listRes = Reservation.findAllByUser(user);
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
		

		Panel panel = new Panel();
		panel.setBounds(71, 113, 553, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInfo = new JLabel("Informations");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(10, 10, 397, 13);
		panel.add(lblInfo);
		
		JLabel lblAccompte = new JLabel("Accompte");
		lblAccompte.setForeground(new Color(102, 0, 0));
		lblAccompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccompte.setBounds(10, 45, 128, 13);
		panel.add(lblAccompte);
		
		JLabel lblAccompteValue = new JLabel("");
		lblAccompteValue.setForeground(Color.DARK_GRAY);
		lblAccompteValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccompteValue.setBounds(10, 66, 128, 13);
		panel.add(lblAccompteValue);
		
		JLabel lblStatut = new JLabel("Statut");
		lblStatut.setForeground(new Color(102, 0, 51));
		lblStatut.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatut.setBounds(148, 45, 124, 13);
		panel.add(lblStatut);
		
		JLabel lblStatutValue = new JLabel("");
		lblStatutValue.setForeground(Color.DARK_GRAY);
		lblStatutValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatutValue.setBounds(148, 66, 124, 13);
		panel.add(lblStatutValue);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setForeground(new Color(102, 0, 51));
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setBounds(282, 45, 125, 13);
		panel.add(lblPrix);
		
		JLabel lblPrixValue = new JLabel("");
		lblPrixValue.setForeground(Color.DARK_GRAY);
		lblPrixValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixValue.setBounds(282, 66, 125, 13);
		panel.add(lblPrixValue);
		
		JLabel lblSolde = new JLabel("Solde");
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setForeground(new Color(102, 0, 51));
		lblSolde.setBounds(418, 45, 125, 13);
		panel.add(lblSolde);
		
		JLabel lblSoldeValue = new JLabel("");
		lblSoldeValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoldeValue.setForeground(Color.DARK_GRAY);
		lblSoldeValue.setBounds(418, 66, 125, 13);
		panel.add(lblSoldeValue);
		
		JLabel lblModePaiement = new JLabel("Mode de paiement");
		lblModePaiement.setHorizontalAlignment(SwingConstants.CENTER);
		lblModePaiement.setForeground(new Color(102, 0, 0));
		lblModePaiement.setBounds(10, 105, 128, 13);
		panel.add(lblModePaiement);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 130, 101, 21);
		comboBox.addItem("Visa");
		comboBox.addItem("PayPal");
		panel.add(comboBox);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardOrga dashborga = new DashboardOrga(user);
				MyReservations.this.dispose();
				dashborga.setVisible(true);
			}
		});
		btnRetour.setBounds(10, 10, 85, 21);
		contentPane.add(btnRetour);
		
		JLabel lblReservations = new JLabel("Vos r\u00E9servations");
		lblReservations.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservations.setForeground(Color.WHITE);
		lblReservations.setBounds(251, 14, 244, 13);
		contentPane.add(lblReservations);
		
		JLabel lblSelect = new JLabel("S\u00E9lectionner une r\u00E9servation");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setForeground(Color.WHITE);
		lblSelect.setBounds(37, 41, 244, 13);
		contentPane.add(lblSelect);
		
		JComboBox CBRes = new JComboBox();
		CBRes.setMaximumRowCount(10000);
		for(var item : listRes) {
			CBRes.addItem(item.getDateDebutR()+" au "+item.getDateFinR());
		}
		CBRes.setBounds(72, 64, 176, 21);
		CBRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(var item : listRes) {
					String date = item.getDateDebutR()+ " au "+item.getDateFinR();
					if(CBRes.getSelectedItem().equals(date)) {
						lblAccompteValue.setText(Integer.toString(item.getAccompte()));
						lblStatutValue.setText(item.getStatut());
						lblPrixValue.setText(Integer.toString(item.getPrix()));
						lblSoldeValue.setText(Integer.toString(item.getSolde()));
					}
				}
			}
		});
		contentPane.add(CBRes);
		
		for(var item : listRes) {
			String date = item.getDateDebutR()+ " au "+item.getDateFinR();
			if(CBRes.getSelectedItem().equals(date)) {
				lblAccompteValue.setText(Integer.toString(item.getAccompte()));
				lblStatutValue.setText(item.getStatut());
				lblPrixValue.setText(Integer.toString(item.getPrix()));
				lblSoldeValue.setText(Integer.toString(item.getSolde()));
			}
		}
		
		JButton btnPayerTotalit = new JButton("Payer totalit\u00E9");
		btnPayerTotalit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation res = null;
				for(var item : listRes) {
					String date = item.getDateDebutR()+ " au "+item.getDateFinR();
					if(CBRes.getSelectedItem().equals(date)) {		
						if(!item.getStatut().equals("Payé")) {							
							res = item;
							item.setSolde(0);
							item.setStatut("Payé");
							lblSoldeValue.setText(Integer.toString(item.getSolde()));
							lblStatutValue.setText(item.getStatut());
							res.updateReservation();
							if(comboBox.getSelectedItem().equals("Visa")) {								
								JOptionPane.showMessageDialog(null,"Réservation payé avec Visa");
							}else {
								JOptionPane.showMessageDialog(null,"Réservation payé avec PayPal");
							}
						}else {
							JOptionPane.showMessageDialog(null,"Réservation déjà payée");
						}
					}
				}
			}
		});
		btnPayerTotalit.setBounds(418, 174, 132, 21);
		panel.add(btnPayerTotalit);
		
		JButton btnPay = new JButton("Payer accompte");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation res = null;
				for(var item : listRes) {
					String date = item.getDateDebutR()+ " au "+item.getDateFinR();
					if(CBRes.getSelectedItem().equals(date)) {
						if(!item.getStatut().equals("Payé")) {
							if(!item.getStatut().equals("Accompte payé")) {								
								res = item;
								item.setSolde(item.getPrix()-item.getAccompte());
								item.setStatut("Accompte payé");
								lblSoldeValue.setText(Integer.toString(item.getSolde()));
								lblStatutValue.setText("Accompte payé");
								res.paiementAccompte();
								if(comboBox.getSelectedItem().equals("Visa")) {								
									JOptionPane.showMessageDialog(null,"Accompte payé avec Visa");
								}else {
									JOptionPane.showMessageDialog(null,"Accompte payé avec PayPal");
								}
							}else {
								JOptionPane.showMessageDialog(null,"Accompte déjà payé");
							}
						}else {
							JOptionPane.showMessageDialog(null,"Réservation déjà payée");
						}
					}
				}
			}
		});
		btnPay.setBounds(266, 174, 141, 21);
		panel.add(btnPay);
	}
}
