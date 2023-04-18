package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
    Connection conn = null;
    private JLabel tableLabel01, tableLabel02, tableLabel03, tableLabel04, tableLabel05, tableLabel06, tableLabel07, tableLabel08;
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerInfo frame = new CustomerInfo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void close()
    {
        this.dispose();
    }

    public CustomerInfo() throws SQLException {
        super("CUSTOMER INFO");
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        contentPane.add(table);

            tableLabel01 = new JLabel("ID");
            tableLabel01.setBounds(31, 11, 46, 14);
            contentPane.add(tableLabel01);

            tableLabel02 = new JLabel("Number");
            tableLabel02.setBounds(150, 11, 46, 14);
            contentPane.add(tableLabel02);

            tableLabel03 = new JLabel("Name");
            tableLabel03.setBounds(270, 11, 65, 14);
            contentPane.add(tableLabel03);

            tableLabel04 = new JLabel("Gender");
            tableLabel04.setBounds(360, 11, 46, 14);
            contentPane.add(tableLabel04);

            tableLabel05 = new JLabel("Country");
            tableLabel05.setBounds(480, 11, 46, 14);
            contentPane.add(tableLabel05);

            tableLabel06 = new JLabel("Room");
            tableLabel06.setBounds(600, 11, 46, 14);
            contentPane.add(tableLabel06);

            tableLabel07 = new JLabel("Check-in Status");
            tableLabel07.setBounds(680, 11, 100, 14);
            contentPane.add(tableLabel07);

            tableLabel08 = new JLabel("Deposit");
            tableLabel08.setBounds(800, 11, 100, 14);
            contentPane.add(tableLabel08);
                
        JButton button01 = new JButton("Load Data");
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    conn c  = new conn();
                    String displayCustomersql = "select * from Customer";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        button01.setBounds(300, 510, 120, 30);
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
        button02.setBounds(450, 510, 120, 30);
        button02.setBackground(Color.BLACK);
        button02.setForeground(Color.WHITE);
        contentPane.add(button02);

        getContentPane().setBackground(Color.WHITE);
    }
}
