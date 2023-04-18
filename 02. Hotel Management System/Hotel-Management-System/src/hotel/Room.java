package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Room extends JFrame {
    
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel tableLabel01, tableLabel02, tableLabel03, tableLabel04, tableLabel05;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Room frame = new Room();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Room() throws SQLException {
        super("ROOM");
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500,0,600,600);
        add(l1);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        contentPane.add(table);
        
            tableLabel01 = new JLabel("Room Number");
            tableLabel01.setBounds(12, 15, 90, 14);
            contentPane.add(tableLabel01);        
        
            tableLabel02 = new JLabel("Availability");
            tableLabel02.setBounds(119, 15, 69, 14);
            contentPane.add(tableLabel02);

            tableLabel03 = new JLabel("Clean Status");
            tableLabel03.setBounds(216, 15, 76, 14);
            contentPane.add(tableLabel03);

            tableLabel04 = new JLabel("Price");
            tableLabel04.setBounds(330, 15, 46, 14);
            contentPane.add(tableLabel04);

            tableLabel05 = new JLabel("Bed Type");
            tableLabel05.setBounds(417, 15, 76, 14);
            contentPane.add(tableLabel05);

        JButton button01 = new JButton("Load Data");
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String displayCustomersql = "select * from Room";
                    //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        button01.setBounds(100, 470, 120, 30);
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
        button02.setBounds(290, 470, 120, 30);
        button02.setBackground(Color.BLACK);
        button02.setForeground(Color.WHITE);
        contentPane.add(button02);

        getContentPane().setBackground(Color.WHITE);
    } 
}
