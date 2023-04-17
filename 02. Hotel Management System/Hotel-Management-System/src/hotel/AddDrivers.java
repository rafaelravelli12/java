package hotel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDrivers extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField01,textField02,textField04,textField05, textField07;
    private JComboBox comboBox03, comboBox06;
    JButton buttonAdd, buttonBack;
    Choice c1;

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }

    public AddDrivers() {
        super("ADD DRIVERS");
        setBounds(450, 200, 1000, 500);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        add(l15);
        
        JLabel BodyTitle = new JLabel("Add Drivers");
        BodyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
	BodyTitle.setBounds(194, 10, 120, 22);
	contentPane.add(BodyTitle);
        	        
	JLabel FormField01 = new JLabel("Name");
	FormField01.setForeground(new Color(25, 25, 112));
	FormField01.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField01.setBounds(64, 70, 102, 22);
	contentPane.add(FormField01);
        textField01 = new JTextField();
	textField01.setBounds(174, 70, 156, 20);
	contentPane.add(textField01);
        
	JLabel FormField02 = new JLabel("Age");
	FormField02.setForeground(new Color(25, 25, 112));
	FormField02.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField02.setBounds(64, 110, 102, 22);
	contentPane.add(FormField02);        
        textField02 = new JTextField();
	textField02.setBounds(174, 110, 156, 20);
	contentPane.add(textField02);

	JLabel FormField03 = new JLabel("Gender");
	FormField03.setForeground(new Color(25, 25, 112));
	FormField03.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField03.setBounds(64, 150, 102, 22);
	contentPane.add(FormField03);        
        comboBox03 = new JComboBox(new String[] { "Male", "Female" });
	comboBox03.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox03);

	JLabel FormField04 = new JLabel("Car Company");
	FormField04.setForeground(new Color(25, 25, 112));
	FormField04.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField04.setBounds(64, 190, 102, 22);
	contentPane.add(FormField04);        
        textField04 = new JTextField();
	textField04.setBounds(174, 190, 156, 20);
	contentPane.add(textField04);

        JLabel FormField05 = new JLabel("Car Brand");
	FormField05.setForeground(new Color(25, 25, 112));
	FormField05.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField05.setBounds(64, 230, 102, 22);
	contentPane.add(FormField05);
        textField05 = new JTextField();
	textField05.setBounds(174, 230, 156, 20);
	contentPane.add(textField05);
	
        JLabel FormField06 = new JLabel("Available");
	FormField06.setForeground(new Color(25, 25, 112));
	FormField06.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField06.setBounds(64, 270, 102, 22);
	contentPane.add(FormField06);
        comboBox06 = new JComboBox(new String[] { "Yes", "No" });
	comboBox06.setBounds(176, 270, 154, 20);
	contentPane.add(comboBox06);
        
        JLabel FormField07 = new JLabel("Location");
	FormField07.setForeground(new Color(25, 25, 112));
	FormField07.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField07.setBounds(64, 310, 102, 22);
	contentPane.add(FormField07);
        textField07 = new JTextField();
	textField07.setBounds(174, 310, 156, 20);
	contentPane.add(textField07);
        
	buttonAdd = new JButton("Add");
	buttonAdd.addActionListener(this);
	buttonAdd.setBounds(64, 380, 111, 33);
        buttonAdd.setBackground(Color.BLACK);
        buttonAdd.setForeground(Color.WHITE);
	contentPane.add(buttonAdd);

	buttonBack = new JButton("Back");
	buttonBack.addActionListener(this);
	buttonBack.setBounds(198, 380, 111, 33);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
	contentPane.add(buttonBack);
	
        contentPane.setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{            
            if(ae.getSource() == buttonAdd){
                try{
                    conn c = new conn();
                    String name = textField01.getText();
                    String age = textField02.getText();
                    String gender = (String)comboBox03.getSelectedItem();
                    String company  = textField04.getText();
                    String brand = textField05.getText();
                    String available = (String)comboBox06.getSelectedItem();
                    String location = textField07.getText();
                    String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == buttonBack){
                this.setVisible(false);
            }
        }catch(Exception eee){
        }
    }
}
