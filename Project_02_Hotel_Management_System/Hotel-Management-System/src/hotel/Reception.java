package hotel;

import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        new Reception();
    }

    public Reception(){
        setBounds(530, 200, 850, 570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250,30,500,470);
        add(l1);

        JButton button01 = new JButton("New Customer Form");
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    NewCustomer custom = new NewCustomer();
                    custom.setVisible(true);
                    setVisible(false);
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        button01.setBounds(10, 30, 200, 30);
        button01.setBackground(Color.BLACK);
        button01.setForeground(Color.WHITE);
        contentPane.add(button01);

        JButton button02 = new JButton("Room");
        button02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Room room = new Room();
                    room.setVisible(true);
                    setVisible(false);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        button02.setBounds(10, 70, 200, 30);
        button02.setBackground(Color.BLACK);
        button02.setForeground(Color.WHITE);
        contentPane.add(button02);

        JButton button03 = new JButton("All Employee Info");
        button03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Employee em = new Employee();
                    em.setVisible(true);
                    setVisible(false);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        button03.setBounds(10, 110, 200, 30);                
        button03.setBackground(Color.BLACK);
        button03.setForeground(Color.WHITE);
        contentPane.add(button03);

        JButton button04 = new JButton("Customer Info");
        button04.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    CustomerInfo customer = new CustomerInfo();
                    customer.setVisible(true);				
                    setVisible(false);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        button04.setBounds(10, 150, 200, 30);
        button04.setBackground(Color.BLACK);
        button04.setForeground(Color.WHITE);
        contentPane.add(button04);

        JButton button05 = new JButton("Manager Info");
        button05.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    ManagerInfo mana = new ManagerInfo();
                    mana.setVisible(true);
                    setVisible(false);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        button05.setBounds(10, 190, 200, 30);
        button05.setBackground(Color.BLACK);
        button05.setForeground(Color.WHITE);
        contentPane.add(button05);

        JButton button06 = new JButton("Check Out");
        button06.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckOut check;
                try {
                    check = new CheckOut();
                    check.setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button06.setBounds(10, 230, 200, 30);
        button06.setBackground(Color.BLACK);
        button06.setForeground(Color.WHITE);
        contentPane.add(button06);

        JButton button07 = new JButton("Update Check Status");
        button07.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    UpdateCheck update = new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        button07.setBounds(10, 270, 200, 30);
        button07.setBackground(Color.BLACK);
        button07.setForeground(Color.WHITE);
        contentPane.add(button07);

        JButton button08 = new JButton("Update Room Status");
        button08.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    UpdateRoom room = new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                }catch(Exception s){
                    s.printStackTrace();
                }
            }
        });
        button08.setBounds(10, 310, 200, 30);
        button08.setBackground(Color.BLACK);
        button08.setForeground(Color.WHITE);
        contentPane.add(button08);

        JButton button09 = new JButton("Pick up Service");
        button09.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                    try{
                        PickUp pick = new PickUp();
                        pick.setVisible(true);
                        setVisible(false);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
            }
        });
        button09.setBounds(10, 350, 200, 30);
        button09.setBackground(Color.BLACK);
        button09.setForeground(Color.WHITE);
        contentPane.add(button09);

        JButton button10 = new JButton("Search Room");
        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchRoom search = new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                }
                catch (Exception ss){
                    ss.printStackTrace();
                }
            }
        });
        button10.setBounds(10, 390, 200, 30);
        button10.setBackground(Color.BLACK);
        button10.setForeground(Color.WHITE);
        contentPane.add(button10);

        JButton button11 = new JButton("Log Out");
        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Login().setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        button11.setBounds(10, 430, 200, 30);
        button11.setBackground(Color.BLACK);
        button11.setForeground(Color.WHITE);
        contentPane.add(button11);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
}
