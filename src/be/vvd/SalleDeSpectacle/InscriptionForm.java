package be.vvd.SalleDeSpectacle;

import be.vvd.classes.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import be.vvd.classes.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;

public class InscriptionForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfNom;
	private JTextField tfPrenom;
	private JTextField tfEmail;
	private JTextField tfAdresse;
	private JTextField tfPassword;
	private JTextField tfConfirmPassword;
	private JTextField tfTelephone;
	private JTextField tfNumCpt;
	private JTextField tfNumNationale;
	
	private boolean client;
	private boolean orga;
	private boolean gestio;
	private boolean artiste;
	private JTextField tfNumArtiste;

	public InscriptionForm(String role) {
		this.client=false;
		this.orga=false;
		this.gestio=false;
		
		switch(role) {
			case "Client" -> this.client = true;
			case "Organisateur"-> this.orga = true;
			case "Artiste" -> this.artiste=true;
		}
		
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
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 1, 432, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscriptionForm.this.dispose();
				InscriptionPage insc = new InscriptionPage();
				insc.setVisible(true);
			}
		});
		btnRetour.setBounds(10, 10, 85, 21);
		contentPane.add(btnRetour);
		
		JPanel panel = new JPanel();
		panel.setBounds(241, 50, 309, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfNom = new JTextField();
		tfNom.setBounds(32, 81, 96, 19);
		panel.add(tfNom);
		tfNom.setColumns(10);
		
		tfPrenom = new JTextField();
		tfPrenom.setBounds(183, 81, 96, 19);
		panel.add(tfPrenom);
		tfPrenom.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(32, 133, 96, 19);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(32, 110, 96, 13);
		panel.add(lblEmail);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setBounds(183, 58, 96, 13);
		panel.add(lblPrenom);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(32, 58, 96, 13);
		panel.add(lblNom);
		
		tfAdresse = new JTextField();
		tfAdresse.setBounds(183, 133, 96, 19);
		panel.add(tfAdresse);
		tfAdresse.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(32, 185, 96, 19);
		panel.add(tfPassword);
		tfPassword.setColumns(10);
		
		tfConfirmPassword = new JPasswordField();
		tfConfirmPassword.setBounds(183, 185, 96, 19);
		panel.add(tfConfirmPassword);
		tfConfirmPassword.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresse.setBounds(183, 110, 96, 13);
		panel.add(lblAdresse);
		
		JLabel lblPasswdConfirm = new JLabel("Confirmation");
		lblPasswdConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswdConfirm.setBounds(183, 162, 96, 13);
		panel.add(lblPasswdConfirm);
		
		JLabel lblForm = new JLabel("Formulaire");
		lblForm.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblForm.setBounds(77, 10, 145, 38);
		panel.add(lblForm);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(32, 162, 96, 13);
		panel.add(lblPassword);
		if(this.client) {			
			JLabel lblNumTel = new JLabel("T\u00E9l\u00E9phone");
			lblNumTel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumTel.setBounds(32, 214, 96, 13);
			panel.add(lblNumTel);
			
			tfTelephone = new JTextField();
			tfTelephone.setBounds(32, 237, 96, 19);
			panel.add(tfTelephone);
			tfTelephone.setColumns(10);
		}else if(this.orga) {
			JLabel lblNumCpt = new JLabel("Numéro de compte");
			lblNumCpt.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumCpt.setBounds(15, 214, 130, 13);
			panel.add(lblNumCpt);
			
			tfNumCpt = new JTextField();
			tfNumCpt.setBounds(32, 237, 96, 19);
			panel.add(tfNumCpt);
			tfNumCpt.setColumns(10);
		}else {
			JLabel lblNumArtiste = new JLabel("Numéro artiste");
			lblNumArtiste.setHorizontalAlignment(SwingConstants.CENTER);
			lblNumArtiste.setBounds(15, 214, 130, 13);
			panel.add(lblNumArtiste);
			
			tfNumArtiste = new JTextField();
			tfNumArtiste.setBounds(32, 237, 96, 19);
			panel.add(tfNumArtiste);
			tfNumArtiste.setColumns(10);
		}
		
		JButton btnNewButton = new JButton("S'enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = tfNom.getText();
				String prenom = tfPrenom.getText();
				String email = tfEmail.getText();
				String adresse = tfAdresse.getText();
				String pwd = tfPassword.getText();
				String confirmPwd = tfConfirmPassword.getText();
				String numTel="";
				String numBanque="";
				String numArtiste="";
				boolean isValid=false;
				if(nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || adresse.isEmpty() || pwd.isEmpty() || confirmPwd.isEmpty()) {
					System.out.println("Formulaire incorrect");
				}else {					
					if(InscriptionForm.this.client) {
						numTel = tfTelephone.getText();
					}else if(InscriptionForm.this.orga) {
						numBanque= tfNumCpt.getText();
					}else {
						numArtiste=tfNumArtiste.getText();
					}
					if(!pwd.equals(confirmPwd) ){
						JOptionPane.showMessageDialog(null,"Les mots de passes sont différents");
					}else if(InscriptionForm.this.client && numTel.isEmpty()) {
						JOptionPane.showMessageDialog(null,"Le numéro de téléphone est manquant");
					}else if(InscriptionForm.this.orga && numBanque.isEmpty()) {
						JOptionPane.showMessageDialog(null,"Le numéro de banque est manquant");
					}else if(InscriptionForm.this.artiste && numArtiste.isEmpty()) {
						JOptionPane.showMessageDialog(null,"Le numéro d'artiste est manquant");
					}else {
						if(InscriptionForm.this.client) {						
							Client client = new Client(nom,prenom,adresse,role,email,pwd,numTel);
							isValid = client.register();
						}else if(InscriptionForm.this.orga) {
							Organisateur orga = new Organisateur(nom,prenom,adresse,role,email,pwd,numBanque);
							isValid = orga.register();
						}else {
							Artiste artiste = new Artiste(nom,prenom,adresse,role,email,pwd,numArtiste);
							isValid = artiste.register();
						}
						if(isValid) {							
							InscriptionForm.this.dispose();
							Main main = new Main();
							main.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"Ce compte existe déjà");
						}
					}
				}
			}
		});
		btnNewButton.setBounds(170, 272, 129, 21);
		panel.add(btnNewButton);
		
	}
}
