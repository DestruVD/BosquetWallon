package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;

import be.vvd.classes.Representation;
import javax.swing.DebugGraphics;

public class DashboardOrga extends JFrame {

	private JPanel contentPane;
	private Component[] comp;
	private int j=0;

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
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
	        @Override
	        public void propertyChange(PropertyChangeEvent e) {
	        	Set<Representation> listRep = Representation.findAll();
	        	DashboardOrga.this.comp = calendar.getDayChooser().getDayPanel().getComponents();
	        	int day = calendar.getDayChooser().getDay();
	    		int month = calendar.getMonthChooser().getMonth();		
	    		int year = calendar.getYearChooser().getYear();
	    		
	    		 Calendar cal = Calendar.getInstance();
	    	     cal.set(Calendar.MONTH, month);
	    	     cal.set(Calendar.YEAR, year);
	    	     cal.set(Calendar.DAY_OF_MONTH, 1);
	    	     java.util.Date firstDayOfMonth = cal.getTime();  
	    	
	    	     DateFormat sdf = new SimpleDateFormat("EEEEEEEE");   
	    	     String strfirstDayOMonth = sdf.format(firstDayOfMonth);
	    	     
	    	     switch(strfirstDayOMonth) {
	    	     	case "Sunday" -> j=0;
	    	     	case "Monday" -> j=1;
	    	     	case "Tuesday" -> j=2;
	    	     	case "Wednesday" -> j=3;
	    	     	case "Thursday" -> j=4;
	    	     	case "Friday" -> j=5;
	    	     	case "Saturday" -> j=6;
	    	     }
	    		
	    		for(int i = 7+j ; i<comp.length;i++) {
	    			for(var item : listRep) {
	    				String date = item.getDate();
	    				String daydb = date.substring(0,2);
	    	    		String monthdb = date.substring(3,5);
	    	    		String yeardb = date.substring(6,10);
	    	    		if(daydb.lastIndexOf('0')==0) {
	    	    			daydb = daydb.substring(1,2);
	    	    		}
	    				if(Integer.parseInt(yeardb)==year && Integer.parseInt(monthdb)==month+1) {
	    					if(i-((7+j)+1)==Integer.parseInt(daydb)) {
	    						comp[i-2].setBackground(new Color(255,0,0));
	    						comp[i-2].setEnabled(false);
	    					}
	    				}
	    			}
	    		}
	    		
	        }
	    });
		calendar.setBounds(10, 41, 206, 152);
		
		contentPane.add(calendar);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date parsed=null;
				SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				String strDate = format1.format(calendar.getDate());
				Representation rep = new Representation(strDate);
				String day = strDate.substring(0,2);
				int dayInt = Integer.parseInt(day);
				comp[7+j+dayInt-1].setEnabled(false);
				comp[7+j+dayInt-1].setBackground(new Color(255,0,0));
				rep.ajouterRepresentation();
			}
		});
		btnNewButton.setBounds(72, 203, 85, 21);
		contentPane.add(btnNewButton);
	}
}
