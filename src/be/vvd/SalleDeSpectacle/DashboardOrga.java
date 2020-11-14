package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;

import be.vvd.classes.Representation;

public class DashboardOrga extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardOrga frame = new DashboardOrga();
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
	public DashboardOrga() {
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
		
		JButton btnDeconnexion = new JButton("D\u00E9connexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardOrga.this.dispose();
				Main main = new Main();
				main.setVisible(true);
			}
		});
		btnDeconnexion.setBounds(10, 10, 114, 21);
		contentPane.add(btnDeconnexion);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 41, 206, 152);
		
		contentPane.add(calendar);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date parsed=null;
				SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				String strDate = format1.format(calendar.getDate());
				try {
					parsed = format1.parse(strDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				java.sql.Date date = new java.sql.Date(parsed.getTime());
				Representation rep = new Representation(date);
				Component comp[] = calendar.getDayChooser().getDayPanel().getComponents();
				for(int i = 7 ; i< comp.length; i++) {
					comp[i].setBackground(new Color(255,0,0));
					comp[i].setEnabled(false);
				}
//				rep.ajouterRepresentation();
			}
		});
		btnNewButton.setBounds(72, 203, 85, 21);
		contentPane.add(btnNewButton);
	}
}
