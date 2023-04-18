package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame{
    
    Connection conn = null;
    PreparedStatement pst = null;
    private JLabel tableLabel01, tableLabel02;
    private JPanel contentPane;
    private JTextField textField01;
    Choice choice01;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOut frame = new CheckOut();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void close(){
        this.dispose();
    }

    public CheckOut() throws SQLException {
        super("CHECK OUT");

        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 294);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(300,0,500,225);
        add(l1);

        JLabel BodyTitle = new JLabel("Check Out");
        BodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        BodyTitle.setBounds(70, 11, 140, 35);
        contentPane.add(BodyTitle);

        tableLabel01 = new JLabel("Customer number:");
        tableLabel01.setBounds(20, 85, 120, 14);
        contentPane.add(tableLabel01);
        choice01 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                choice01.add(rs.getString("number"));
            }
        }catch(Exception e){ }
        choice01.setBounds(140, 82, 150, 20);
        contentPane.add(choice01);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l2 = new JButton(i6);
        l2.setBounds(300,82,20,20);
        add(l2);
        l2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    conn c = new conn();
                    String number = choice01.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where number = "+number);

                    if(rs.next()){
                        textField01.setText(rs.getString("room_number"));    
                    }
                }catch(Exception e){ }
            }
        });

        tableLabel02 = new JLabel("Room Number:");
        tableLabel02.setBounds(20, 132, 120, 20);
        contentPane.add(tableLabel02);
        textField01 = new JTextField();
        textField01.setBounds(140, 132, 150, 20);
        contentPane.add(textField01);

        JButton button01 = new JButton("Check Out");
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = choice01.getSelectedItem();
                String s1 = textField01.getText();
                String deleteSQL = "Delete from customer where number = "+id;
                String q2 = "update room set availability = 'Available' where room_number = "+s1;
                String q3 = "update room set clean_status = 'Unclean' where room_number = "+s1;

                conn c = new conn();
                try{
                    c.s.executeUpdate(deleteSQL);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "Check Out Successful");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        button01.setBounds(50, 200, 100, 25);
        button01.setBackground(Color.BLACK);
        button01.setForeground(Color.WHITE);
        contentPane.add(button01);

        JButton button02 = new JButton("Back");
        button02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        button02.setBounds(160, 200, 100, 25);
        button02.setBackground(Color.BLACK);
        button02.setForeground(Color.WHITE);
        contentPane.add(button02);


        getContentPane().setBackground(Color.WHITE);
    }
}
