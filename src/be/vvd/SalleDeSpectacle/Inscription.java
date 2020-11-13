package be.vvd.SalleDeSpectacle;

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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField tfNom;
	private JTextField tfPrenom;
	private JTextField tfEmail;
	private JTextField tfAdresse;
	private JTextField tfPassword;
	private JTextField tfConfirmPassword;

	public Inscription() {
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
				Inscription.this.dispose();
				Main main = new Main();
				main.setVisible(true);
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
		
		tfConfirmPassword = new JTextField();
		tfConfirmPassword.setBounds(183, 185, 96, 19);
		panel.add(tfConfirmPassword);
		tfConfirmPassword.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresse.setBounds(183, 110, 96, 13);
		panel.add(lblAdresse);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setBounds(32, 214, 96, 13);
		panel.add(lblRole);
		
		JLabel lblPasswdConfirm = new JLabel("Confirmation");
		lblPasswdConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswdConfirm.setBounds(183, 162, 96, 13);
		panel.add(lblPasswdConfirm);
		
		JLabel lblForm = new JLabel("Formulaire");
		lblForm.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblForm.setBounds(77, 10, 145, 38);
		panel.add(lblForm);
		
		
		Choice choiceRole = new Choice();
		choiceRole.setFont(new Font("Calibri", Font.PLAIN, 12));
		choiceRole.setBounds(32, 238, 96, 18);
		choiceRole.addItem("Client");
		choiceRole.addItem("Gestionnaire");
		choiceRole.addItem("Organisateur");
		panel.add(choiceRole);
		
		JLabel lblPassword_1 = new JLabel("Mot de passe");
		lblPassword_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword_1.setBounds(32, 162, 96, 13);
		panel.add(lblPassword_1);
		
		JButton btnNewButton = new JButton("S'enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = tfNom.getText();
				String prenom = tfPrenom.getText();
				String email = tfEmail.getText();
				String adresse = tfAdresse.getText();
				String pwd = tfPassword.getText();
				String confirmPwd = tfConfirmPassword.getText();
				String role = choiceRole.getSelectedItem();
				if(!pwd.equals(confirmPwd)) {
					System.out.println("Les mots de passe sont différents ! ");
				}else {
					Utilisateur user = new Utilisateur(nom,prenom,adresse,role,email);
					System.out.println(user.getRole());
				}
			}
		});
		btnNewButton.setBounds(170, 272, 129, 21);
		panel.add(btnNewButton);
		
	}
}
