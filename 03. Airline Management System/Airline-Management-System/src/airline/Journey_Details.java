package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;

    public static void main(String[] args){
        new Journey_Details();
    }
    
    public Journey_Details(){
                
	setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(860,600);
        setLocation(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("JOURNEY_DETAILS");
        
	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
        		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(30, 100, 100, 27);
	add(Source);
        String[] items1 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
        
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
	String[] items2 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);        
	
	JButton Show1 = new JButton("SHOW");
	Show1.setBounds(680, 100, 100, 30);
	add(Show1);
        
        JButton Show2 = new JButton("Create new Flight");
	Show2.setBounds(30, 200, 200, 30);
	add(Show2);
               
        JButton Show3 = new JButton("Show All Flights");
	Show3.setBounds(250, 200, 200, 30);
	add(Show3);
        
        JButton Show4 = new JButton("Back to Home");
	Show4.setBounds(470, 200, 200, 30);
	add(Show4);
		
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
	
            Pnrno = new JLabel("PNR_NO");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Pnrno.setBounds(79, 270, 83, 20);
            add(Pnrno);

            Ticketid = new JLabel("TICKET_ID");
            Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Ticketid.setBounds(172, 270, 71, 20);
            add(Ticketid);

            Fcode = new JLabel("F_CODE");
            Fcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Fcode.setBounds(297, 270, 103, 20);
            add(Fcode);

            Jnydate = new JLabel("JNY_DATE");
            Jnydate.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Jnydate.setBounds(390, 270, 94, 20);
            add(Jnydate);

            Jnytime = new JLabel("JNY_TIME");
            Jnytime.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Jnytime.setBounds(494, 270, 83, 20);
            add(Jnytime);

            Source = new JLabel("SOURCE");
            Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Source.setBounds(613, 270, 94, 20);
            add(Source);

            Destination = new JLabel("DESTINATION");
            Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Destination.setBounds(717, 270, 94, 20);
            add(Destination);

	Show1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    conn c = new conn();
                    String str = "select * from reservation where src = '"+src+"' and dst = '"+dst+"'";
                    ResultSet rs= c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));		                   	
		}catch(Exception e){}
            }
	});
        
        Show2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddNewFlight();
                setVisible(false);
            }
        });
        
      
        Show3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    conn c = new conn();
                    String str = "select * from reservation";
                    ResultSet rs= c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));		                   	
		}catch(Exception e){}
            }
	});
        
        Show4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Mainframe();
                setVisible(false);
            }
        });
        
        
        setVisible(true);   
    }
}
