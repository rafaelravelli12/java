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

public class ManagerInfo extends JFrame {
    
    Connection conn = null;
    private JLabel tableLabel01, tableLabel02, tableLabel03, tableLabel04, tableLabel05, tableLabel06, tableLabel07, tableLabel08;
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerInfo frame = new ManagerInfo();
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

    public ManagerInfo() throws SQLException {
        super("MANAGER INFO");

        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contentPane.add(table);
        
            tableLabel01 = new JLabel("Name");
            tableLabel01.setBounds(41, 11, 46, 14);
            contentPane.add(tableLabel01);

            tableLabel02 = new JLabel("Age");
            tableLabel02.setBounds(159, 11, 46, 14);
            contentPane.add(tableLabel02);

            tableLabel03 = new JLabel("Gender");
            tableLabel03.setBounds(273, 11, 46, 14);
            contentPane.add(tableLabel03);

            tableLabel04 = new JLabel("Job");
            tableLabel04.setBounds(416, 11, 86, 14);
            contentPane.add(tableLabel04);

            tableLabel05 = new JLabel("Salary");
            tableLabel05.setBounds(536, 11, 86, 14);
            contentPane.add(tableLabel05);

            tableLabel06 = new JLabel("Phone");
            tableLabel06.setBounds(656, 11, 86, 14);
            contentPane.add(tableLabel06);

            tableLabel07 = new JLabel("Aadhar");
            tableLabel07.setBounds(786, 11, 86, 14);
            contentPane.add(tableLabel07);

            tableLabel08 = new JLabel("Email");
            tableLabel08.setBounds(896, 11, 86, 14);
            contentPane.add(tableLabel08);
            
        JButton button01 = new JButton("Load Data");
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String displayCustomersql = "select * from Employee where job = 'Manager'";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        button01.setBounds(350, 500, 120, 30);
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
        button02.setBounds(510, 500, 120, 30);
        button02.setBackground(Color.BLACK);
        button02.setForeground(Color.WHITE);
        contentPane.add(button02);

        getContentPane().setBackground(Color.WHITE);
    }
}
