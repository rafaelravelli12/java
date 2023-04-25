package airline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;

public class AddNewTicket extends JFrame {
    
    public static void main(String[] args){
        new AddNewTicket();
    }   
    
    public AddNewTicket(){
    
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(100,100);
        setSize(860,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add New Ticket");
        
        JLabel SubTitle = new JLabel("Add New Ticket");
	SubTitle.setForeground(Color.BLUE);
	SubTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
	SubTitle.setBounds(50, 25, 400, 50);
	add(SubTitle);
        
        JLabel l01 = new JLabel("Passenger Name");
        l01.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l01.setBounds(50, 100, 200, 30);
        add(l01);
        JTextField tf01 = new JTextField();
        tf01.setBounds(250, 100, 250, 30);
        add(tf01);
        
        JLabel l02 = new JLabel("Fight Code");
        l02.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l02.setBounds(50, 150, 200, 30);
        add(l02);
        Choice choice = new Choice();
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from flight_info");
                while(rs.next()){
                    choice.add(rs.getString("code"));
                }
            }catch(Exception e){ }
        choice.setBounds(250, 150, 250, 30);
        add(choice);
        
        JLabel l03 = new JLabel("Chair Class");
        l03.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l03.setBounds(50, 200, 200, 30);
        add(l03);
        String course[] = {"Executive","Popular"};
        JComboBox comboBox = new JComboBox(course);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(250, 200, 250, 30);
        add(comboBox);
        
        JButton Create = new JButton("SAVE");
        Create.setBounds(250, 450, 150, 30);
        add(Create);
        
        JButton Back = new JButton("Back");
        Back.setBounds(250, 500, 150, 30);
        add(Back);
        
        Create.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String stf01 = tf01.getText();
                String strchoice = choice.getSelectedItem();
                String strcomboBox = (String)comboBox.getSelectedItem();
                try {
                    conn c = new conn();
                    String str = "INSERT INTO ticket values( '"+stf01+"','"+strchoice+"','"+strcomboBox+"')";
                    c.s.executeUpdate(str);
                    if (strcomboBox.equals("Executive")){
                        String str02 = "update flight_info set remaining_executive_chairs=remaining_executive_chairs-1 where code='"+strchoice+"'";
                        c.s.executeUpdate(str02);
                    }
                    else if (strcomboBox.equals("Popular")){
                        String str02 = "update flight_info set remaining_popular_chairs=remaining_popular_chairs-1 where code='"+strchoice+"'";
                        c.s.executeUpdate(str02);
                    }
                    else {}
                    JOptionPane.showMessageDialog(null,"Succesfully Added");
                    setVisible(false);
                    new TicketPurchase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });     
        
        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    setVisible(false);
                    new TicketPurchase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        setVisible(true); 
    }    
}
