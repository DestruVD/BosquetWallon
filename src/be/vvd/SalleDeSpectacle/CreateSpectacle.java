package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.vvd.classes.Spectacle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateSpectacle extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitre;
	private JTextField tfPlaceMax;

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
	public CreateSpectacle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		lblCreateSpectacle.setBounds(121, 10, 140, 13);
		contentPane.add(lblCreateSpectacle);
		
		tfTitre = new JTextField();
		tfTitre.setBounds(57, 54, 96, 19);
		contentPane.add(tfTitre);
		tfTitre.setColumns(10);
		
		tfPlaceMax = new JTextField();
		tfPlaceMax.setBounds(233, 54, 96, 19);
		contentPane.add(tfPlaceMax);
		tfPlaceMax.setColumns(10);
		
		JButton btnCreateSpectacle = new JButton("Ajouter");
		btnCreateSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = tfTitre.getText();
				int placeMax = Integer.parseInt(tfPlaceMax.getText()); 
				Spectacle spec = new Spectacle(titre,placeMax);
				spec.ajouterSpectacle();
				CreateSpectacle.this.dispose();
				DashboardOrga dashboard = new DashboardOrga();
				dashboard.setVisible(true);
			}
		});
		btnCreateSpectacle.setBounds(164, 207, 85, 21);
		contentPane.add(btnCreateSpectacle);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(78, 33, 45, 13);
		contentPane.add(lblTitre);
		
		JLabel lblPlaceMax = new JLabel("Place maximum");
		lblPlaceMax.setForeground(Color.WHITE);
		lblPlaceMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceMax.setBounds(233, 33, 96, 13);
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
	}

}
