package airline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;

public class AddNewFlight extends JFrame {
      
    public static void main(String[] args){
        new AddNewFlight();
    }   
    
    public AddNewFlight(){
    
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(100,100);        
        setSize(860,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add New Flight");
        
        JLabel SubTitle = new JLabel("Add New Flight");
	SubTitle.setForeground(Color.BLUE);
	SubTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
	SubTitle.setBounds(50, 25, 400, 50);
	add(SubTitle);
        
        JLabel l01 = new JLabel("Company");
        l01.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l01.setBounds(50, 100, 200, 30);
        add(l01);
        JTextField tf01 = new JTextField();
        tf01.setBounds(250, 100, 250, 30);
        add(tf01);
        
        JLabel l02 = new JLabel("Source");
        l02.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l02.setBounds(50, 150, 200, 30);
        add(l02);
        JTextField tf02 = new JTextField();
        tf02.setBounds(250, 150, 250, 30);
        add(tf02);
        
        JLabel l03 = new JLabel("Destination");
        l03.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l03.setBounds(50, 200, 200, 30);
        add(l03);
        JTextField tf03 = new JTextField();
        tf03.setBounds(250, 200, 250, 30);
        add(tf03);

        JLabel l04 = new JLabel("Date");
        l04.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l04.setBounds(50, 250, 200, 30);
        add(l04);
        JTextField tf04 = new JTextField();
        tf04.setBounds(250, 250, 250, 30);
        add(tf04);
        
        JLabel l05 = new JLabel("Time");
        l05.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l05.setBounds(50, 300, 200, 30);
        add(l05);
        JTextField tf05 = new JTextField();
        tf05.setBounds(250, 300, 250, 30);
        add(tf05);
        
        JLabel l06 = new JLabel("Code");
        l06.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l06.setBounds(50, 350, 200, 30);
        add(l06);
        JTextField tf06 = new JTextField();
        tf06.setBounds(250, 350, 250, 30);
        add(tf06);
        
        JLabel l07 = new JLabel("Plane Model");
        l07.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l07.setBounds(50, 400, 200, 30);
        add(l07);
        Choice choice = new Choice();
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from plane");
                while(rs.next()){
                    choice.add(rs.getString("model"));
                }
            }catch(Exception e){ }
        choice.setBounds(250, 400, 150, 20);
        add(choice);
        
        JButton Create = new JButton("SAVE");
        Create.setBounds(250, 450, 150, 30);
        add(Create);
        
        JButton Back = new JButton("Back");
        Back.setBounds(250, 500, 150, 30);
        add(Back);
        
        Create.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String stf01 = tf01.getText();
                String stf02 = tf02.getText();
                String stf03 = tf03.getText();
                String stf04 = tf04.getText();
                String stf05 = tf05.getText();
                String stf06 = tf06.getText();
                String strchoice = choice.getSelectedItem();
                
                try {
                    conn c = new conn();
                    
                    String query = "SELECT executive_class_capacity, popular_class_capacity FROM plane WHERE model = '"+strchoice+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    int executive_class_capacity = 0, popular_class_capacity = 0;
                    if(rs.next()){
                        executive_class_capacity = rs.getInt("executive_class_capacity");
                        popular_class_capacity = rs.getInt("popular_class_capacity");
                    }
                    
                    String str01 = "INSERT INTO flight_info values( '"+stf01+"', '"+stf02+"', '"+stf03+"', '"+stf04+"', '"+stf05+"', '"+stf06+"', '"+strchoice+"', '"+executive_class_capacity+"', '"+popular_class_capacity+"')";
                    c.s.executeUpdate(str01);                 
                    
                    JOptionPane.showMessageDialog(null,"Succesfully Added");
                    setVisible(false);
                    new FlightInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });     
        
        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    setVisible(false);
                    new FlightInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        setVisible(true); 
    }    
}
