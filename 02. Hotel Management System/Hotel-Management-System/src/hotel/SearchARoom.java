package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchARoom extends JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTextField txt_Type;
    private JTable table;
    Choice choice01;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchARoom frame = new SearchARoom();
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

    public SearchARoom() throws SQLException {
        super("Search a Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(530, 200, 700, 500);

        JLabel BodyTitle = new JLabel("Search For Room");
        BodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        BodyTitle.setBounds(250, 11, 186, 31);
        contentPane.add(BodyTitle);

        JLabel FormField01 = new JLabel("Room Bed Type:");
        FormField01.setBounds(50, 73, 96, 14);
        contentPane.add(FormField01);
        choice01 = new Choice();
        choice01.add("Single Bed");
        choice01.add("Double Bed");
        choice01.setBounds(153, 70, 120, 20);
        contentPane.add(choice01);

        JCheckBox checkRoom = new JCheckBox("Only display Available");
        checkRoom.setBounds(400, 69, 205, 23);
        checkRoom.setBackground(Color.WHITE);
        contentPane.add(checkRoom);
        
        table = new JTable();
        table.setBounds(20, 190, 700, 200);
        contentPane.add(table);
        
            JLabel tableLabel01 = new JLabel("Room Number");
            tableLabel01.setBounds(23, 162, 96, 14);
            contentPane.add(tableLabel01);

            JLabel tableLabel02 = new JLabel("Availability");
            tableLabel02.setBounds(175, 162, 120, 14);
            contentPane.add(tableLabel02);

            JLabel tableLabel03 = new JLabel("Clean Status");
            tableLabel03.setBounds(306, 162, 96, 14);
            contentPane.add(tableLabel03);       

            JLabel tableLabel04 = new JLabel("Price");
            tableLabel04.setBounds(458, 162, 46, 14);
            contentPane.add(tableLabel04);

            JLabel tableLabel05 = new JLabel("Bed Type");
            tableLabel05.setBounds(580, 162, 96, 14);
            contentPane.add(tableLabel05);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from Room where bed_type = '"+choice01.getSelectedItem()+"'";
                String SQL2 = "select * from Room where availability = 'Available' AND bed_type = '"+choice01.getSelectedItem()+"'";
                try{			
                    conn c = new conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(checkRoom.isSelected())
                    {	
                        rs = c.s.executeQuery(SQL2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                }catch (SQLException ss)
                {
                    ss.printStackTrace();
                }
            }
        });
        btnSearch.setBounds(200, 400, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        contentPane.add(btnSearch);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(380, 400, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
