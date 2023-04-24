package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame{

    JTable table;

    public static void main(String[] args){
        new FlightInfo();
    }
    
    public FlightInfo(){
        
	setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(860,600);
        setLocation(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Flight Info");
        
	JLabel SubTitle = new JLabel("Flight Info");
	SubTitle.setForeground(Color.BLUE);
	SubTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
	SubTitle.setBounds(30, 30, 400, 50);
        SubTitle.setVerticalAlignment(SwingConstants.CENTER);
	add(SubTitle);
        		       
        JButton Add = new JButton("Add new Flight");
	Add.setBounds(30, 100, 200, 30);
	add(Add);
               
        JButton Show = new JButton("Show All Flights");
	Show.setBounds(250, 100, 200, 30);
	add(Show);
        
        JButton Back = new JButton("Back to Home");
	Back.setBounds(470, 100, 200, 30);
	add(Back);
		
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
	
            JLabel Company = new JLabel("Company");
            Company.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Company.setBounds(79, 270, 83, 20);
            add(Company);

            JLabel Source = new JLabel("Source");
            Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Source.setBounds(172, 270, 71, 20);
            add(Source);

            JLabel Destination = new JLabel("Destination");
            Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Destination.setBounds(297, 270, 103, 20);
            add(Destination);
            
            JLabel Date = new JLabel("Date");
            Date.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Date.setBounds(297, 270, 103, 20);
            add(Date);
            
            JLabel Time = new JLabel("Time");
            Time.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Time.setBounds(297, 270, 103, 20);
            add(Time);
            
            JLabel Code = new JLabel("Code");
            Code.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Code.setBounds(297, 270, 103, 20);
            add(Code);        
            
        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddNewFlight();
                setVisible(false);
            }
        });
              
        Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    conn c = new conn();
                    String str = "select * from flight_info";
                    ResultSet rs= c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));		                   	
		}catch(Exception e){}
            }
	});
        
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Mainframe();
                setVisible(false);
            }
        });
        
        
        setVisible(true);   
    }
}
