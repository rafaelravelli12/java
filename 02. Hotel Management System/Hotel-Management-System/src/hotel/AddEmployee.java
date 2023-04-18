package hotel;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame{
    
    JTextField textField01,textField02,textField05,textField06,textField07,textField08;
    JComboBox comboBox04;
    
    public static void main(String[] args){
        new AddEmployee();
    }

    public AddEmployee(){
        super("ADD EMPLOYEE DETAILS");
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        //Form
            JLabel FormField01 = new JLabel("NAME");
            FormField01.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField01.setBounds(60, 30, 150, 27);
            add(FormField01);
            textField01 = new JTextField();
            textField01.setBounds(200, 30, 150, 27);
            add(textField01);                 

            JLabel FormField02 = new JLabel("AGE");
            FormField02.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField02.setBounds(60, 80, 150, 27);
            add(FormField02);
            textField02 = new JTextField();
            textField02.setBounds(200, 80, 150, 27);
            add(textField02);

            JLabel FormField03 = new JLabel("GENDER");
            FormField03.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField03.setBounds(60, 120, 150, 27);
            add(FormField03);
            JRadioButton NewRadioButton01 = new JRadioButton("MALE");
            NewRadioButton01.setBackground(Color.WHITE);
            NewRadioButton01.setBounds(200, 120, 70, 27);
            add(NewRadioButton01);
            JRadioButton NewRadioButton02 = new JRadioButton("FEMALE");
            NewRadioButton02.setBackground(Color.WHITE);
            NewRadioButton02.setBounds(280, 120, 70, 27);
            add(NewRadioButton02);

            JLabel FormField04 = new JLabel("JOB");
            FormField04.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField04.setBounds(60, 170, 150, 27);
            add(FormField04);
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            comboBox04 = new JComboBox(course);
            comboBox04.setBackground(Color.WHITE);
            comboBox04.setBounds(200,170,150,30);
            add(comboBox04);

            JLabel FormField05 = new JLabel("SALARY");
            FormField05.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField05.setBounds(60, 220, 150, 27);
            add(FormField05);
            textField05 = new JTextField();
            textField05.setBounds(200, 220, 150, 27);
            add(textField05);

            JLabel FormField06 = new JLabel("PHONE");
            FormField06.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField06.setBounds(60, 270, 150, 27);
            add(FormField06);
            textField06 = new JTextField();
            textField06.setBounds(200, 270, 150, 27);
            add(textField06);

            JLabel FormField07 = new JLabel("AADHAR");
            FormField07.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField07.setBounds(60, 320, 150, 27);
            add(FormField07);
            textField07 = new JTextField();
            textField07.setBounds(200, 320, 150, 27);
            add(textField07);

            JLabel FormField08 = new JLabel("EMAIL");
            FormField08.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FormField08.setBounds(60, 370, 150, 27);
            add(FormField08);
            textField08 = new JTextField();
            textField08.setBounds(200, 370, 150, 27);
            add(textField08);

        JButton ButtonPost = new JButton("SAVE");
        ButtonPost.setBounds(200, 420, 150, 30);
        ButtonPost.setBackground(Color.BLACK);
        ButtonPost.setForeground(Color.WHITE);
        add(ButtonPost);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410,80,480,410);
        add(image);
        
        ButtonPost.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String name = textField01.getText();
                String age = textField02.getText();
                String gender = null;
                    if(NewRadioButton01.isSelected()){
                        gender = "male";
                    }else if(NewRadioButton02.isSelected()){
                        gender = "female";
                    }
                String job = (String)comboBox04.getSelectedItem();
                String salary = textField05.getText();
                String phone = textField06.getText();
                String aadhar = textField07.getText();
                String email = textField08.getText();
                
                try {
                    conn c = new conn();
                    String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Employee Added");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSize(900,600);
        setVisible(true);
        setLocation(530,200);
    }    
}
