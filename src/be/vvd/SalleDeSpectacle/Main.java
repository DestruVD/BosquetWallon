package be.vvd.SalleDeSpectacle;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
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
		
		JButton Inscription = new JButton("Inscription");
		Inscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.this.dispose();
				Inscription insc = new Inscription();
				insc.setVisible(true);
			}
		});
		Inscription.setBounds(452, 325, 99, 21);
		contentPane.add(Inscription);
		
		JLabel lblNewLabel = new JLabel("Bienvenu au Bosquet Wallon");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNewLabel.setMaximumSize(new Dimension(139, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(193, 52, 358, 107);
		contentPane.add(lblNewLabel);
		
		JButton Connexion = new JButton("Connexion");
		Connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.this.dispose();
				Connexion conn = new Connexion();
				conn.setVisible(true);
			}
		});
		Connexion.setBounds(193, 325, 99, 21);
		contentPane.add(Connexion);
	}
}
