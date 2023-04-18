package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PickUp extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTable table;
    Choice fieldChoises05;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PickUp frame = new PickUp();
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

    public PickUp() throws SQLException {
        super("PICK UP SERVICE");
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel BodyTitle = new JLabel("Pick Up Service");
        BodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        BodyTitle.setBounds(90, 11, 158, 25);
        contentPane.add(BodyTitle);
        
        //Form
            JLabel FormField01 = new JLabel("Type of Car");
            FormField01.setBounds(32, 97, 89, 14);
            contentPane.add(FormField01);
            fieldChoises05 = new Choice();
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from driver");
                while(rs.next()){
                    fieldChoises05.add(rs.getString("brand"));    
                }
            }catch(Exception e){ }
            fieldChoises05.setBounds(123, 94, 150, 25);
            contentPane.add(fieldChoises05);
        
        table = new JTable();
        table.setBounds(0, 233, 800, 250);
        contentPane.add(table);
        
            JLabel tableLabel01 = new JLabel("Name");
            tableLabel01.setBounds(24, 208, 46, 14);
            contentPane.add(tableLabel01);

            JLabel tableLabel02 = new JLabel("Age");
            tableLabel02.setBounds(165, 208, 46, 14);
            contentPane.add(tableLabel02);

            JLabel tableLabel03 = new JLabel("Gender");
            tableLabel03.setBounds(264, 208, 46, 14);
            contentPane.add(tableLabel03);

            JLabel tableLabel04 = new JLabel("Company");
            tableLabel04.setBounds(366, 208, 80, 14);
            contentPane.add(tableLabel04);

            JLabel tableLabel05 = new JLabel("Brand");
            tableLabel05.setBounds(486, 208, 105, 14);
            contentPane.add(tableLabel05);

            JLabel tableLabel06 = new JLabel("Available");
            tableLabel06.setBounds(600, 208, 86, 14);
            contentPane.add(tableLabel06);

            JLabel tableLabel07 = new JLabel("Location");
            tableLabel07.setBounds(700, 208, 73, 14);
            contentPane.add(tableLabel07);
            
        JButton buttonDisplay = new JButton("Display");
        buttonDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SQL = "select * from driver where brand = '"+fieldChoises05.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (SQLException ss)
                {
                    ss.printStackTrace();
                }
            }
        });
        buttonDisplay.setBounds(200, 500, 120, 30);
        buttonDisplay.setBackground(Color.BLACK);
        buttonDisplay.setForeground(Color.WHITE);
        contentPane.add(buttonDisplay);

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        buttonBack.setBounds(420, 500, 120, 30);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        contentPane.add(buttonBack);

        getContentPane().setBackground(Color.WHITE);
    }
}
