package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class InscriptionPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionPage frame = new InscriptionPage();
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
	public InscriptionPage() {
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
		
		Panel panel = new Panel();
		panel.setBounds(195, 61, 351, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton Client = new JButton("Client");
		Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscriptionPage.this.dispose();
				InscriptionForm insc = new InscriptionForm("Client");
				insc.setVisible(true);
			}
		});
		Client.setBounds(111, 32, 130, 21);
		panel.add(Client);
		
		JButton Organisateur = new JButton("Organisateur");
		Organisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscriptionPage.this.dispose();
				InscriptionForm insc = new InscriptionForm("Organisateur");
				insc.setVisible(true);
			}
		});
		Organisateur.setBounds(111, 82, 130, 21);
		panel.add(Organisateur);
		
		JButton Gestionnaire = new JButton("Gestionnaire");
		Gestionnaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscriptionPage.this.dispose();
				InscriptionForm insc = new InscriptionForm("Gestionnaire");
				insc.setVisible(true);
			}
		});
		Gestionnaire.setBounds(111, 135, 130, 21);
		panel.add(Gestionnaire);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscriptionPage.this.dispose();
				Main main = new Main();
				main.setVisible(true);
			}
		});
		Retour.setBounds(10, 10, 85, 21);
		contentPane.add(Retour);
		
		JLabel Choice = new JLabel("Choice");
		Choice.setForeground(Color.WHITE);
		Choice.setFont(new Font("Calibri", Font.PLAIN, 25));
		Choice.setHorizontalAlignment(SwingConstants.CENTER);
		Choice.setBounds(195, 10, 351, 37);
		contentPane.add(Choice);
	}
}
