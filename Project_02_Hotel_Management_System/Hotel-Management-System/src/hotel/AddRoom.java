package hotel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField01, textField04;
    private JComboBox comboBox02, comboBox03, comboBox05;
    JButton buttonAdd, buttonBack;
    Choice c1;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

    public AddRoom() {
        super("ADD ROOMS");
        setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        add(l15);
        
        JLabel BodyTitle = new JLabel("Add Rooms");
        BodyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
	BodyTitle.setBounds(194, 10, 120, 22);
	contentPane.add(BodyTitle);

	JLabel FormField01 = new JLabel("Room Number");
	FormField01.setForeground(new Color(25, 25, 112));
	FormField01.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField01.setBounds(64, 70, 102, 22);
	contentPane.add(FormField01);
        textField01 = new JTextField();
	textField01.setBounds(174, 70, 156, 20);
	contentPane.add(textField01);
        
	JLabel FormField02 = new JLabel("Availability");
	FormField02.setForeground(new Color(25, 25, 112));
	FormField02.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField02.setBounds(64, 110, 102, 22);
	contentPane.add(FormField02);        
        comboBox02 = new JComboBox(new String[] { "Available", "Occupied" });
	comboBox02.setBounds(176, 110, 154, 20);
	contentPane.add(comboBox02);

	JLabel FormField03 = new JLabel("Cleaning Status");
	FormField03.setForeground(new Color(25, 25, 112));
	FormField03.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField03.setBounds(64, 150, 102, 22);
	contentPane.add(FormField03);        
        comboBox03 = new JComboBox(new String[] { "Cleaned", "Dirty" });
	comboBox03.setBounds(176, 150, 154, 20);
	contentPane.add(comboBox03);

	JLabel FormField04 = new JLabel("Price");
	FormField04.setForeground(new Color(25, 25, 112));
	FormField04.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField04.setBounds(64, 190, 102, 22);
	contentPane.add(FormField04);
        textField04 = new JTextField();
	textField04.setBounds(174, 190, 156, 20);
	contentPane.add(textField04);

        JLabel FormField05 = new JLabel("Bed Type");
	FormField05.setForeground(new Color(25, 25, 112));
	FormField05.setFont(new Font("Tahoma", Font.BOLD, 14));
	FormField05.setBounds(64, 230, 102, 22);
	contentPane.add(FormField05);
        comboBox05 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	comboBox05.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox05);

	buttonAdd = new JButton("Add");
	buttonAdd.addActionListener(this);
	buttonAdd.setBounds(64, 321, 111, 33);
        buttonAdd.setBackground(Color.BLACK);
        buttonAdd.setForeground(Color.WHITE);
	contentPane.add(buttonAdd);

	buttonBack = new JButton("Back");
	buttonBack.addActionListener(this);
	buttonBack.setBounds(198, 321, 111, 33);
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
                    String room = textField01.getText();
                    String available = (String)comboBox02.getSelectedItem();
                    String status = (String)comboBox03.getSelectedItem();
                    String price  = textField04.getText();
                    String type = (String)comboBox05.getSelectedItem();
                    String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
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
