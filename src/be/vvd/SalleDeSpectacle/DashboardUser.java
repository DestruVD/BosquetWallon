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

import be.vvd.classes.Representation;
import be.vvd.classes.Spectacle;
import be.vvd.classes.Utilisateur;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardUser extends JFrame {

	private JPanel contentPane;
	private Set<Spectacle> listSpec = new HashSet<Spectacle>();

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
		
		JLabel lblChooseSpec = new JLabel("Choisissez un spectacle");
		lblChooseSpec.setForeground(Color.WHITE);
		lblChooseSpec.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseSpec.setBounds(40, 61, 217, 13);
		contentPane.add(lblChooseSpec);
		
		JComboBox CBRepresentation = new JComboBox();
		CBRepresentation.setBounds(343, 94, 191, 21);
		contentPane.add(CBRepresentation);
		
		JComboBox CBSpectacle = new JComboBox();
		CBSpectacle.setBounds(40, 94, 217, 21);
		for(var spec : listSpec) {
			CBSpectacle.addItem(spec.getTitre());
		}
		CBSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CBRepresentation.removeAllItems();
				Set<Representation> listRepres = new HashSet<Representation>();
				for(var spec : me.listSpec) {				
					if(CBSpectacle.getSelectedItem().equals(spec.getTitre())) {
						Representation rep = new Representation(spec);
						listRepres = rep.findBySpectacleID();
						for(var repFromList : listRepres) {							
							CBRepresentation.addItem(repFromList.getDate());
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
	}
}
