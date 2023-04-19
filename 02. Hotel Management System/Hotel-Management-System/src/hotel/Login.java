package hotel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel FormField01,FormField02;
    JTextField answerField01;
    JPasswordField answerField02;
    JButton button01,button02;

    public static void main(String[] arg){
        new Login();
    }
     
    Login(){
        super("Login");
        setLayout(null);
        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

        //Form
            FormField01 = new JLabel("Username");
            FormField01.setBounds(40,20,100,30);
            add(FormField01);
            answerField01 = new JTextField();
            answerField01.setBounds(150,20,150,30);
            add(answerField01);

            FormField02 = new JLabel("Password");
            FormField02.setBounds(40,70,100,30);
            add(FormField02);
            answerField02 = new JPasswordField();
            answerField02.setBounds(150,70,150,30);
            add(answerField02);
        
        button01 = new JButton("Login");
        button01.setBounds(40,140,120,30);
        button01.setFont(new Font("serif",Font.BOLD,15));
        button01.addActionListener(this);
        button01.setBackground(Color.BLACK);
        button01.setForeground(Color.WHITE);
        add(button01);

        button02 = new JButton("Cancel");
        button02.setBounds(180,140,120,30);
        button02.setFont(new Font("serif",Font.BOLD,15));
        button02.addActionListener(this);        
        button02.setBackground(Color.BLACK);
        button02.setForeground(Color.WHITE);
        add(button02);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);        
        
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button01){
            try{
                conn c1 = new conn();
                String u = answerField01.getText();
                String v = answerField02.getText();
                String q = "select * from login where username='"+u+"' and password='"+v+"'";
                ResultSet rs = c1.s.executeQuery(q); 
                if(rs.next()){ 
                    new Dashboard().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == button02){
            System.exit(0);
        }
    }   
}
