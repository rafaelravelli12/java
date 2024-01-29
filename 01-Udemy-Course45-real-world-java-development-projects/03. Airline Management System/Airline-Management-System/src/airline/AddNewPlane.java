package airline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddNewPlane extends JFrame {
    
    public static void main(String[] args){
        new AddNewPlane();
    }   
    
    public AddNewPlane(){
    
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(100,100);
        setSize(860,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add New Plane");
        
        JLabel SubTitle = new JLabel("Add New Plane");
	SubTitle.setForeground(Color.BLUE);
	SubTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
	SubTitle.setBounds(50, 25, 400, 50);
	add(SubTitle);
        
        JLabel l01 = new JLabel("Model");
        l01.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l01.setBounds(50, 100, 200, 30);
        add(l01);
        JTextField tf01 = new JTextField();
        tf01.setBounds(250, 100, 250, 30);
        add(tf01);
        
        JLabel l02 = new JLabel("Executive Class Capacity");
        l02.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l02.setBounds(50, 150, 200, 30);
        add(l02);
        JTextField tf02 = new JTextField();
        tf02.setBounds(250, 150, 250, 30);
        add(tf02);
        
        JLabel l03 = new JLabel("Popular Class Capacity");
        l03.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l03.setBounds(50, 200, 200, 30);
        add(l03);
        JTextField tf03 = new JTextField();
        tf03.setBounds(250, 200, 250, 30);
        add(tf03);
        
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
                try {
                    conn c = new conn();
                    String str = "INSERT INTO plane values( '"+stf01+"', '"+stf02+"', '"+stf03+"')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Succesfully Added");
                    setVisible(false);
                    new PlaneInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });     
        
        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    setVisible(false);
                    new PlaneInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        setVisible(true); 
    }    
}
