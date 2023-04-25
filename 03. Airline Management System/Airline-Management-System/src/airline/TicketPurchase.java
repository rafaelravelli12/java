package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class TicketPurchase extends JFrame{

    JTable table;

    public static void main(String[] args){
        new TicketPurchase();
    }
    
    public TicketPurchase(){
        
	setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(100,100);       
        setSize(860,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ticket Purchase");
        
	JLabel SubTitle = new JLabel("Ticket Purchase");
	SubTitle.setForeground(Color.BLUE);
	SubTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
	SubTitle.setBounds(30, 30, 400, 50);
        SubTitle.setVerticalAlignment(SwingConstants.CENTER);
	add(SubTitle);
        		       
        JButton Add = new JButton("Add new Ticket");
	Add.setBounds(30, 100, 200, 30);
	add(Add);
               
        JButton Show = new JButton("Show All Tickets");
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
            
        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddNewTicket();
                setVisible(false);
            }
        });
              
        Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    conn c = new conn();
                    String str = "select * from ticket";
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
