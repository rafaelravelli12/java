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

public class SearchRoom extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTextField txt_Type;
    private JTable table;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchRoom frame = new SearchRoom();
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

    public SearchRoom() throws SQLException {
        super("SEARCH ROOM");
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel BodyTitle = new JLabel("Search For Room");
        BodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        BodyTitle.setBounds(250, 11, 186, 31);
        contentPane.add(BodyTitle);

        JLabel FormField01 = new JLabel("Room Bed Type:");
        FormField01.setBounds(50, 73, 96, 14);
        contentPane.add(FormField01);
        c1 = new Choice();
        c1.add("Single Bed");
        c1.add("Double Bed");
        c1.setBounds(153, 70, 120, 20);
        contentPane.add(c1);

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
                String SQL = "select * from Room where bed_type = '"+c1.getSelectedItem()+"'";
                String SQL2 = "select * from Room where availability = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
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
