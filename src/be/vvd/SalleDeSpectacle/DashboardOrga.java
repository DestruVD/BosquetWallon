package be.vvd.SalleDeSpectacle;

import java.awt.BorderLayout;
import be.vvd.classes.*;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;

import javax.swing.DebugGraphics;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class DashboardOrga extends JFrame {

	private JPanel contentPane;
	private Component[] compFirstCalendar;
	private Component[] compSecondCalendar;
	private int j=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardOrga frame = new DashboardOrga(new Utilisateur());
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
	public DashboardOrga(Utilisateur user) {
		Set<Reservation> listResByUser = Reservation.findAllByUser(user);
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
		btnDeconnexion.setBounds(660, 10, 114, 21);
		contentPane.add(btnDeconnexion);
		
		JButton btnRepresentation = new JButton("Mes repr\u00E9sentations");
		btnRepresentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardOrga.this.dispose();
				MyRepresentations myRep = new MyRepresentations(user);
				myRep.setVisible(true);
			}
		});
		btnRepresentation.setBounds(329, 10, 168, 21);
		btnRepresentation.setVisible(false);
		contentPane.add(btnRepresentation);
		
		JButton btnMyRes = new JButton("Mes r\u00E9servations");
		btnMyRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyReservations myRes = new MyReservations(user);
				DashboardOrga.this.dispose();
				myRes.setVisible(true);
			}
		});
		btnMyRes.setBounds(507, 10, 143, 21);
		btnMyRes.setVisible(false);
		contentPane.add(btnMyRes);
		
		if(!listResByUser.isEmpty()) {
    		btnMyRes.setVisible(true);
    		btnRepresentation.setVisible(true);
    	}
		
		JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
	        @Override
	        public void propertyChange(PropertyChangeEvent e) {
	        	Set<Reservation> listRes = Reservation.findAll();
	        	
	        	DashboardOrga.this.compFirstCalendar = calendar.getDayChooser().getDayPanel().getComponents();
	        	
	    		int month = calendar.getMonthChooser().getMonth();
	    		int year = calendar.getYearChooser().getYear();
	    		
	    		 Calendar cal = Calendar.getInstance();
	    	     cal.set(Calendar.MONTH, month);
	    	     cal.set(Calendar.YEAR, year);
	    	     cal.set(Calendar.DAY_OF_MONTH, 1);
	    	     java.util.Date firstDayOfMonth = cal.getTime();  
	    	
	    	     DateFormat sdf = new SimpleDateFormat("EEEEEEEE");   
	    	     String strfirstDayOMonth = sdf.format(firstDayOfMonth);
	    	     
	    	     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	    	     LocalDateTime now = LocalDateTime.now();  
	    	     
	    	     String todayDay = dtf.format(now).substring(0,2);
 				 String todayMonth = dtf.format(now).substring(3,5);
 				 String todayYear = dtf.format(now).substring(6,10);
	    	     
	    	     switch(strfirstDayOMonth) {
	    	     	case "Sunday" -> j=0;
	    	     	case "Monday" -> j=1;
	    	     	case "Tuesday" -> j=2;
	    	     	case "Wednesday" -> j=3;
	    	     	case "Thursday" -> j=4;
	    	     	case "Friday" -> j=5;
	    	     	case "Saturday" -> j=6;
	    	     }
	    	     
	    	     if(month+1<Integer.parseInt(todayMonth) && year<=Integer.parseInt(todayYear)) {
 					 for(int l= 7+j ; l < compFirstCalendar.length;l++) {
 						compFirstCalendar[l].setEnabled(false);
 					 }
 				 }else if(year<Integer.parseInt(todayYear)) {
 					for(int l= 7+j ; l < compFirstCalendar.length;l++) {
 						compFirstCalendar[l].setEnabled(false);
 					 }
 				 }else if(month+1==Integer.parseInt(todayMonth) && year==Integer.parseInt(todayYear)) {
 					for(int l= 7+j ; l < compFirstCalendar.length && l-(7+j)+1 <Integer.parseInt(todayDay);l++) {
 						compFirstCalendar[l].setEnabled(false);
 					 }
 				 }
	    	     
	    		for(int i = 7+j ; i<compFirstCalendar.length;i++) {
	    			for(var item : listRes) {
	    				String strDateDebutR = item.getDateDebutR();
	    				String strDateFinR = item.getDateFinR();
	    				String dayDebutR = strDateDebutR.substring(0,2);
	    				String monthDebutR= strDateDebutR.substring(3,5);
	    				String yearDebutR= strDateDebutR.substring(6,10);
	    				
	    				String dayFinR = strDateFinR.substring(0,2);
	    				String monthFinR= strDateFinR.substring(3,5);
	    				String yearFinR= strDateFinR.substring(6,10);
	    				
	    	    		if(dayDebutR.lastIndexOf('0')==0) {
	    	    			dayDebutR = dayDebutR.substring(1,2);
	    	    		}
	    	    		
	    	    		if(dayFinR.lastIndexOf('0')==0) {
	    	    			dayFinR = dayFinR.substring(1,2);
	    	    		}
	    	    		
	    	    		int dayDebutRInt = Integer.parseInt(dayDebutR);
	    				int monthDebutRInt = Integer.parseInt(monthDebutR);
	    				int yearDebutRInt = Integer.parseInt(yearDebutR);
	    				
	    				be.vvd.classes.Date dateDebutR = new be.vvd.classes.Date(dayDebutRInt,monthDebutRInt,yearDebutRInt);
	    				
	    				int dayFinRInt = Integer.parseInt(dayFinR);
	    				int monthFinRInt = Integer.parseInt(monthFinR);
	    				int yearFinRInt = Integer.parseInt(yearFinR);
	    				
	    				be.vvd.classes.Date dateFinR = new be.vvd.classes.Date(dayFinRInt,monthFinRInt,yearFinRInt);
	    				
	    				int jourEntreDates = be.vvd.classes.Date.betweenTwoDate(dateDebutR, dateFinR);
	    				if(monthDebutRInt==monthFinRInt) {	    					
	    					if(i-((7+j)+1)==dayDebutRInt && month+1==monthDebutRInt && calendar.getYearChooser().getYear()==yearDebutRInt) {
	    						for(int k=0; k<=jourEntreDates;k++) {
	    							compFirstCalendar[k+i-2].setBackground(new Color(255,0,0));
	    							compFirstCalendar[k+i-2].setEnabled(false);
	    						}
	    					}
	    				}else {
	    					if(i-((7+j)+1)==dayDebutRInt && month+1==monthDebutRInt) {
	    						for(int k=0; k+i-2<compFirstCalendar.length;k++) {
	    							compFirstCalendar[k+i-2].setBackground(new Color(255,0,0));
	    							compFirstCalendar[k+i-2].setEnabled(false);
	    						}
	    					}
	    					be.vvd.classes.Date dateDebut2emeMois = new be.vvd.classes.Date(1,monthFinRInt,yearFinRInt);
	    					int daysCount = be.vvd.classes.Date.betweenTwoDate(dateDebut2emeMois, dateFinR);
	    					if(month+1==monthFinRInt) {	    						
	    						for(int k=0; k<=daysCount;k++) {
	    							compFirstCalendar[7+j+k].setBackground(new Color(255,0,0));
	    							compFirstCalendar[7+j+k].setEnabled(false);
	    						}
	    					}
	    				}
	    			}
	    		}
	        }
	    });
		calendar.setBounds(10, 41, 206, 152);
		contentPane.add(calendar);
		
		JCalendar secondCalendar = new JCalendar();
		secondCalendar.setBounds(10, 234, 206, 152);
		secondCalendar.addPropertyChangeListener(new PropertyChangeListener() {
	        @Override
	        public void propertyChange(PropertyChangeEvent e) {
	        	Set<Reservation> listRep = Reservation.findAll();
	        	DashboardOrga.this.compSecondCalendar = secondCalendar.getDayChooser().getDayPanel().getComponents();
	    		int secondCalendarMonth = secondCalendar.getMonthChooser().getMonth();
	    		int secondCalendarYear = secondCalendar.getYearChooser().getYear();
	    		
	    		 Calendar cal = Calendar.getInstance();
	    	     cal.set(Calendar.MONTH, secondCalendarMonth);
	    	     cal.set(Calendar.YEAR, secondCalendarYear);
	    	     cal.set(Calendar.DAY_OF_MONTH, 1);
	    	     java.util.Date firstDayOfMonth = cal.getTime();  
	    	
	    	     DateFormat sdf = new SimpleDateFormat("EEEEEEEE");   
	    	     String strfirstDayOMonth = sdf.format(firstDayOfMonth);
	    	     
	    	     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	    	     LocalDateTime now = LocalDateTime.now();  
	    	     
	    	     String todayDay = dtf.format(now).substring(0,2);
 				 String todayMonth = dtf.format(now).substring(3,5);
 				 String todayYear = dtf.format(now).substring(6,10);
	    	     
	    	     switch(strfirstDayOMonth) {
	    	     	case "Sunday" -> j=0;
	    	     	case "Monday" -> j=1;
	    	     	case "Tuesday" -> j=2;
	    	     	case "Wednesday" -> j=3;
	    	     	case "Thursday" -> j=4;
	    	     	case "Friday" -> j=5;
	    	     	case "Saturday" -> j=6;
	    	     }
	    	     
	    	     if(secondCalendarMonth+1<Integer.parseInt(todayMonth) && secondCalendarYear<=Integer.parseInt(todayYear)) {
 					 for(int l= 7+j ; l < compSecondCalendar.length;l++) {
 						compSecondCalendar[l].setEnabled(false);
 					 }
 				 }else if(secondCalendarYear<Integer.parseInt(todayYear)) {
 					for(int l= 7+j ; l < compSecondCalendar.length;l++) {
 						compSecondCalendar[l].setEnabled(false);
 					 }
 				 }else if(secondCalendarMonth+1==Integer.parseInt(todayMonth) && secondCalendarYear==Integer.parseInt(todayYear)) {
 					for(int l= 7+j ; l < compSecondCalendar.length && l-(7+j)+1 <Integer.parseInt(todayDay);l++) {
 						compSecondCalendar[l].setEnabled(false);
 					 }
 				 }
	    	     
	    		for(int i = 7+j ; i<compSecondCalendar.length;i++) {
	    			for(var item : listRep) {
	    				String strDateDebutR = item.getDateDebutR();
	    				String strDateFinR = item.getDateFinR();
	    				String dayDebutR = strDateDebutR.substring(0,2);
	    				String monthDebutR= strDateDebutR.substring(3,5);
	    				String yearDebutR= strDateDebutR.substring(6,10);
	    				
	    				String dayFinR = strDateFinR.substring(0,2);
	    				String monthFinR= strDateFinR.substring(3,5);
	    				String yearFinR= strDateFinR.substring(6,10);
	    				
	    	    		if(dayDebutR.lastIndexOf('0')==0) {
	    	    			dayDebutR = dayDebutR.substring(1,2);
	    	    		}
	    	    		
	    	    		if(dayFinR.lastIndexOf('0')==0) {
	    	    			dayFinR = dayFinR.substring(1,2);
	    	    		}
	    	    		
	    	    		int dayDebutRInt = Integer.parseInt(dayDebutR);
	    				int monthDebutRInt = Integer.parseInt(monthDebutR);
	    				int yearDebutRInt = Integer.parseInt(yearDebutR);
	    				
	    				be.vvd.classes.Date dateDebutR = new be.vvd.classes.Date(dayDebutRInt,monthDebutRInt,yearDebutRInt);
	    				
	    				int dayFinRInt = Integer.parseInt(dayFinR);
	    				int monthFinRInt = Integer.parseInt(monthFinR);
	    				int yearFinRInt = Integer.parseInt(yearFinR);
	    				
	    				be.vvd.classes.Date dateFinR = new be.vvd.classes.Date(dayFinRInt,monthFinRInt,yearFinRInt);
	    				
	    				int jourEntreDates = be.vvd.classes.Date.betweenTwoDate(dateDebutR, dateFinR);
	    				if(monthDebutRInt==monthFinRInt) {	    					
	    					if(i-((7+j)+1)==dayDebutRInt && secondCalendarMonth+1==monthDebutRInt && secondCalendar.getYearChooser().getYear()==yearDebutRInt) {
	    						for(int k=0; k<=jourEntreDates;k++) {
	    							compSecondCalendar[k+i-2].setBackground(new Color(255,0,0));
	    							compSecondCalendar[k+i-2].setEnabled(false);
	    						}
	    					}
	    				}else {
	    					if(i-((7+j)+1)==dayDebutRInt && secondCalendarMonth+1==monthDebutRInt) {
	    						for(int k=0; k+i-2<compSecondCalendar.length;k++) {
	    							compSecondCalendar[k+i-2].setBackground(new Color(255,0,0));
	    							compSecondCalendar[k+i-2].setEnabled(false);
	    						}
	    					}
	    					be.vvd.classes.Date dateDebut2emeMois = new be.vvd.classes.Date(1,monthFinRInt,yearFinRInt);
	    					int daysCount = be.vvd.classes.Date.betweenTwoDate(dateDebut2emeMois, dateFinR);
	    					if(secondCalendarMonth+1==monthFinRInt) {	    						
	    						for(int k=0; k<=daysCount;k++) {
	    							compSecondCalendar[7+j+k].setBackground(new Color(255,0,0));
	    							compSecondCalendar[7+j+k].setEnabled(false);
	    						}
	    					}
	    				}
	    			}
	    		}
	        }
	    });
		contentPane.add(secondCalendar);
		
		Set<Spectacle> listSpec = Spectacle.findAll();
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(517, 60, 111, 21);
		for(var item : listSpec) {
			if(item.getUser()!=null) {
				if(item.getUser().getID() == user.getID()) {
					comboBox.addItem(item.toString());
				}
			}
		}
		contentPane.add(comboBox);
		
		JButton btnReserver = new JButton("R\u00E9server");
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spectacle specToAdd = null;
				for(var item : listSpec) {
					String titreFromDB = item.getTitre();
					String titre= (String) comboBox.getSelectedItem();
					if(titreFromDB.equals(titre)) {
						specToAdd=item;
					}
				}
				
				int prix=0;
				boolean findDay=false;
				SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				String strDateDebutR = format1.format(calendar.getDate());
				String strDateFinR = format1.format(secondCalendar.getDate());
 				PlanningSalle planning = new PlanningSalle(strDateDebutR,strDateFinR,specToAdd);
 				
				String dayDebutR = strDateDebutR.substring(0,2);
				String monthDebutR= strDateDebutR.substring(3,5);
				String yearDebutR= strDateDebutR.substring(6,10);
				
				String dayFinR = strDateFinR.substring(0,2);
				String monthFinR= strDateFinR.substring(3,5);
				String yearFinR= strDateFinR.substring(6,10);
				
				int dayDebutRInt = Integer.parseInt(dayDebutR);
				int monthDebutRInt = Integer.parseInt(monthDebutR);
				int yearDebutRInt = Integer.parseInt(yearDebutR);
				
				be.vvd.classes.Date dateDebutR = new be.vvd.classes.Date(dayDebutRInt,monthDebutRInt,yearDebutRInt);
				
				int dayFinRInt = Integer.parseInt(dayFinR);
				int monthFinRInt = Integer.parseInt(monthFinR);
				int yearFinRInt = Integer.parseInt(yearFinR);
				
				be.vvd.classes.Date dateFinR = new be.vvd.classes.Date(dayFinRInt,monthFinRInt,yearFinRInt);
				
				int jourEntreDates = be.vvd.classes.Date.betweenTwoDate(dateDebutR, dateFinR);
				
				Calendar cal = Calendar.getInstance();
				
				cal.set(Calendar.MONTH, dateDebutR.getMonth()-1);
				cal.set(Calendar.YEAR, calendar.getYearChooser().getYear());
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
				
				if(dateFinR.getMonth()-dateDebutR.getMonth() < 2) {	
					int k=0;
					int l=0;
					boolean flag=false;
					if(dateDebutR.getMonth()!=dateFinR.getMonth()){
						for(int i = 0; i<=jourEntreDates; i++) {
							if(dayDebutRInt+i <= dateDebutR.getDayPerMonth()[calendar.getMonthChooser().getMonth()]){
								cal.set(Calendar.MONTH, dateDebutR.getMonth()-1);
								cal.set(Calendar.YEAR, secondCalendar.getYearChooser().getYear());
								cal.set(Calendar.DAY_OF_MONTH, dayDebutRInt+i);
								firstDayOfMonth = cal.getTime();
								
								sdf = new SimpleDateFormat("EEEEEEEE");   
								strfirstDayOMonth = sdf.format(firstDayOfMonth);
								
								switch(strfirstDayOMonth) {
									case "Friday" -> prix+=4500;
									case "Saturday" -> prix+=4500;
									default -> prix+=3000;
								}
								if(compFirstCalendar[7+j+dayDebutRInt+i-1].isEnabled()==false) {									
									findDay=true;
								}
							}else {
								cal.set(Calendar.MONTH, dateDebutR.getMonth());
								cal.set(Calendar.YEAR, secondCalendar.getYearChooser().getYear());
								cal.set(Calendar.DAY_OF_MONTH, 1+l);
								firstDayOfMonth = cal.getTime();
								
								sdf = new SimpleDateFormat("EEEEEEEE");   
								strfirstDayOMonth = sdf.format(firstDayOfMonth);
								
								switch(strfirstDayOMonth) {
									case "Friday" -> prix+=4500;
									case "Saturday" -> prix+=4500;
									default -> prix+=3000;
								}
								l++;
							}
						}
						if(!findDay) {							
							for(int i=0;i<=jourEntreDates;i++) {
								if(dateDebutR.getDay()<dateDebutR.getDayPerMonth()[dateDebutR.getMonth()-1]) {	
									if(dateDebutR.getMonth()==secondCalendar.getMonthChooser().getMonth()+1) {
										if(flag==false) {
											
											cal.set(Calendar.MONTH, dateDebutR.getMonth()-1);
											cal.set(Calendar.YEAR, secondCalendar.getYearChooser().getYear());
											cal.set(Calendar.DAY_OF_MONTH, 1);
											firstDayOfMonth = cal.getTime();
											
											sdf = new SimpleDateFormat("EEEEEEEE");   
											strfirstDayOMonth = sdf.format(firstDayOfMonth);
											
											switch(strfirstDayOMonth) {
											case "Sunday" -> j=0;
											case "Monday" -> j=1;
											case "Tuesday" -> j=2;
											case "Wednesday" -> j=3;
											case "Thursday" -> j=4;
											case "Friday" -> j=5;
											case "Saturday" -> j=6;
											}
											flag=true;
										}
										
										compSecondCalendar[7+j+k].setEnabled(false);
										compSecondCalendar[7+j+k].setBackground(new Color(255,0,0));
										k++;
									}else if(dateDebutR.getMonth()==calendar.getMonthChooser().getMonth()+1) {
										if(dateDebutR.getDay()==dateDebutR.getDayPerMonth()[dateDebutR.getMonth()-1]-1) {
											compFirstCalendar[7+j+dateDebutR.getDay()].setEnabled(false);
											compFirstCalendar[7+j+dateDebutR.getDay()].setBackground(new Color(255,0,0));
										}
										compFirstCalendar[7+j+dateDebutR.getDay()-1].setEnabled(false);
										compFirstCalendar[7+j+dateDebutR.getDay()-1].setBackground(new Color(255,0,0));
									}
									dateDebutR.add1Day();
								}else {
									dateDebutR.setDay(1);
									if(dateDebutR.getMonth()<dateDebutR.getDayPerMonth().length) {
										dateDebutR.add1Month();
										
									}else {
										dateDebutR.setMonth(1);
										dateDebutR.add1Year();
										boolean bool = be.vvd.classes.Date.isBissextile(dateDebutR.getYear());
										if(bool) {
											dateDebutR.setDayPerMonth(1,29);
										}else {
											dateDebutR.setDayPerMonth(1,28);
										}
									}
								}
							}
						}
					}else {
						for(int i = 0; i<=jourEntreDates; i++) {
							if(compFirstCalendar[7+j+dayDebutRInt+i-1].isEnabled()==false) {									
								findDay=true;
							}
						}
						if(!findDay) {
							for(int i=0;i<=jourEntreDates;i++) {
								cal.set(Calendar.MONTH, dateDebutR.getMonth()-1);
								cal.set(Calendar.YEAR, secondCalendar.getYearChooser().getYear());
								cal.set(Calendar.DAY_OF_MONTH, dayDebutRInt+i);
								firstDayOfMonth = cal.getTime();
								
								sdf = new SimpleDateFormat("EEEEEEEE");   
								strfirstDayOMonth = sdf.format(firstDayOfMonth);
								
								switch(strfirstDayOMonth) {
									case "Friday" -> prix+=4500;
									case "Saturday" -> prix+=4500;
									default -> prix+=3000;
								}
								if(dateDebutR.getDay()<dateDebutR.getDayPerMonth()[dateDebutR.getMonth()-1]) {									
									if(dateDebutR.getDay()==dateDebutR.getDayPerMonth()[dateDebutR.getMonth()-1]-1) {
										compFirstCalendar[7+j+dateDebutR.getDay()-1].setEnabled(false);
										compFirstCalendar[7+j+dateDebutR.getDay()-1].setBackground(new Color(255,0,0));
										compSecondCalendar[7+j+dateDebutR.getDay()-1].setEnabled(false);
										compSecondCalendar[7+j+dateDebutR.getDay()-1].setBackground(new Color(255,0,0));
										compFirstCalendar[7+j+dateDebutR.getDay()].setEnabled(false);
										compFirstCalendar[7+j+dateDebutR.getDay()].setBackground(new Color(255,0,0));
										compSecondCalendar[7+j+dateDebutR.getDay()].setEnabled(false);
										compSecondCalendar[7+j+dateDebutR.getDay()].setBackground(new Color(255,0,0));
									}
									compFirstCalendar[7+j+dateDebutR.getDay()-1].setEnabled(false);
									compFirstCalendar[7+j+dateDebutR.getDay()-1].setBackground(new Color(255,0,0));
									compSecondCalendar[7+j+dateDebutR.getDay()-1].setEnabled(false);
									compSecondCalendar[7+j+dateDebutR.getDay()-1].setBackground(new Color(255,0,0));
									dateDebutR.add1Day();
								}else {
									dateDebutR.setDay(1);
									if(dateDebutR.getMonth()<dateDebutR.getDayPerMonth().length) {
										dateDebutR.add1Month();
										
									}else {
										dateDebutR.setMonth(1);
										dateDebutR.add1Year();
										boolean bool = be.vvd.classes.Date.isBissextile(dateDebutR.getYear());
										if(bool) {
											dateDebutR.setDayPerMonth(1,29);
										}else {
											dateDebutR.setDayPerMonth(1,28);
										}
									}
								}
							}
						}
					}
					if(!findDay) {
						Reservation res = new Reservation(planning,prix,user);
						res.ajouterReservation();
						btnMyRes.setVisible(true);
						btnRepresentation.setVisible(true);
					}
				}else {
					System.out.println("Pas plus d'un mois de réservation");
				}
			}
		});
		btnReserver.setBounds(672, 395, 103, 21);
		contentPane.add(btnReserver);
		
		JButton addSpectacle = new JButton("Ajouter un spectacle");
		addSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardOrga.this.dispose();
				CreateSpectacle newSpec = new CreateSpectacle(user);
				newSpec.setVisible(true);
			}
		});
		addSpectacle.setBounds(284, 60, 168, 21);
		contentPane.add(addSpectacle);
		
		JLabel lblOu = new JLabel("ou");
		lblOu.setForeground(Color.WHITE);
		lblOu.setBounds(476, 64, 45, 13);
		contentPane.add(lblOu);
		
		JLabel lblSelectSpectacle = new JLabel("S\u00E9lectionner un spectacle");
		lblSelectSpectacle.setForeground(Color.WHITE);
		lblSelectSpectacle.setBounds(517, 37, 148, 13);
		contentPane.add(lblSelectSpectacle);
		
		JLabel lblNewLabel = new JLabel("S\u00E9lectionner la date de d\u00E9but de r\u00E9servation");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 14, 256, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblSlectionnerLaDate = new JLabel("S\u00E9lectionner la date de fin de r\u00E9servation");
		lblSlectionnerLaDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlectionnerLaDate.setForeground(Color.WHITE);
		lblSlectionnerLaDate.setBounds(10, 211, 246, 13);
		contentPane.add(lblSlectionnerLaDate);
	}
}
