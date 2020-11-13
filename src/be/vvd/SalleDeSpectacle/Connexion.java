package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Connexion() {		
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
		btnRetour.setBounds(10, 17, 85, 21);
		contentPane.add(btnRetour);
	}
}
