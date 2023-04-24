package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
    private void initialize() {
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(860,600);
        setLocation(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home Page");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(860, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 860, 600); 
        add(NewLabel);
        
        JLabel AirlineManagementSystem = new JLabel("AIR INDIA WELCOMES YOU");
	AirlineManagementSystem.setForeground(Color.BLUE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
	AirlineManagementSystem.setBounds(200, 60, 1000, 55);
	NewLabel.add(AirlineManagementSystem); 
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
            JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
            AirlineSystem.setForeground(Color.BLUE);
            menuBar.add(AirlineSystem);
            
                JMenuItem PlaneInfo = new JMenuItem("Plane Info");
                AirlineSystem.add(PlaneInfo);
                
                JMenuItem FlightDetails = new JMenuItem("Flight Info");
                AirlineSystem.add(FlightDetails);

                JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
                AirlineSystem.add(ReservationDetails);

                JMenuItem PassengerDetails = new JMenuItem("Journey Details");
                AirlineSystem.add(PassengerDetails);

                JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");
                AirlineSystem.add(SectorDetails_1);

                JMenuItem Cancellation = new JMenuItem("CANCELLATION");
                AirlineSystem.add(Cancellation);

            JMenu exit = new JMenu("Logout");
            exit.setForeground(Color.RED);
            menuBar.add(exit);

                JMenuItem logout = new JMenuItem("Logout");
                exit.add(logout);    
                		
	PlaneInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new PlaneInfo();
                setVisible(false);
            }
	});
        
	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new FlightInfo();
                setVisible(false);
            }
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
                    setVisible(false);
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        SectorDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment_Details();
                    setVisible(false);
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
                setVisible(false);
            }
	});
        
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new Login().setVisible(true);
            }
	});
        
        
        setVisible(true);
    }
}
