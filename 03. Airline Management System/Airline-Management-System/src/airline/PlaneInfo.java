package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class PlaneInfo extends JFrame{

    JTable table;

    public static void main(String[] args){
        new PlaneInfo();
    }
    
    public PlaneInfo(){
        
	setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(860,600);
        setLocation(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Plane Info");
        
	JLabel SubTitle = new JLabel("Plane Info");
	SubTitle.setForeground(Color.BLUE);
	SubTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
	SubTitle.setBounds(30, 30, 400, 50);
        SubTitle.setVerticalAlignment(SwingConstants.CENTER);
	add(SubTitle);
        		       
        JButton Add = new JButton("Add new Plane");
	Add.setBounds(30, 100, 200, 30);
	add(Add);
               
        JButton Show = new JButton("Show All Planes");
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
	
            JLabel Model = new JLabel("Model");
            Model.setFont(new Font("Tahoma", Font.PLAIN, 13));
            Model.setBounds(79, 270, 83, 20);
            add(Model);

            JLabel ExecutiveClassCapacity = new JLabel("Executive Class Capacity");
            ExecutiveClassCapacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
            ExecutiveClassCapacity.setBounds(172, 270, 71, 20);
            add(ExecutiveClassCapacity);

            JLabel PopularClassCapacity = new JLabel("Popular Class Capacity");
            PopularClassCapacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
            PopularClassCapacity.setBounds(297, 270, 103, 20);
            add(PopularClassCapacity);
       
        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddNewPlane();
                setVisible(false);
            }
        });
              
        Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    conn c = new conn();
                    String str = "select * from plane";
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
