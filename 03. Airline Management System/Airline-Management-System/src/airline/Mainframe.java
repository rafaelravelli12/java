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
        setLocation(100,100);        
        setSize(860,600);        
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
                
                JMenuItem TicketPurchase= new JMenuItem("Ticket Purchase");
                AirlineSystem.add(TicketPurchase);

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
        
        TicketPurchase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new TicketPurchase();
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
