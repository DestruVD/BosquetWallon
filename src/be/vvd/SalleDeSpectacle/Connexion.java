package be.vvd.SalleDeSpectacle;

import be.vvd.classes.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import be.vvd.classes.Utilisateur;
import be.vvd.dao.DAO;
import be.vvd.dao.DAOFactory;
import be.vvd.dao.UtilisateurDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField Email;
	private JTextField Password;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Connexion() {
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 470);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(Connexion.class.getResource("theatre.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
          }; 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel RegisterLabel = new JLabel("Connexion");
		RegisterLabel.setForeground(new Color(255, 255, 255));
		RegisterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RegisterLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		RegisterLabel.setBounds(307, 10, 156, 34);
		contentPane.add(RegisterLabel);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connexion.this.dispose();
				Main main = new Main();
				main.setVisible(true);
			}
		});
		btnRetour.setBounds(10, 10, 85, 21);
		contentPane.add(btnRetour);
		
		JPanel panel = new JPanel();
		panel.setBounds(237, 102, 321, 133);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Email = new JTextField();
		Email.setBounds(52, 58, 96, 19);
		panel.add(Email);
		Email.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(178, 58, 96, 19);
		panel.add(Password);
		Password.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
		labelEmail.setBounds(52, 30, 96, 13);
		panel.add(labelEmail);
		
		JLabel LabelPassword = new JLabel("Mot de passe");
		LabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPassword.setBounds(178, 30, 96, 13);
		panel.add(LabelPassword);
		
		JButton btnConnect = new JButton("Connexion");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = Email.getText();
				String password = Password.getText();
				Utilisateur user = new Utilisateur(email,password);
				Utilisateur ResponseUser = user.login();
				if(ResponseUser!=null){
					switch(ResponseUser.getRole()) {
						case "client": Connexion.this.dispose();
									   DashboardUser dashbUser = new DashboardUser(ResponseUser);
									   dashbUser.setVisible(true);
							break;
						case "organisateur": Connexion.this.dispose();
											 DashboardOrga dashbOrga = new DashboardOrga(ResponseUser);
											 dashbOrga.setVisible(true);
							break;
						case "artiste": System.out.println("Artiste");
							break;
					}
				}
			}
		});
		btnConnect.setBounds(106, 102, 102, 21);
		panel.add(btnConnect);
	}
}
