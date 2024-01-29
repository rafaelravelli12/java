package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoomStatus extends JFrame {
Connection conn = null;

PreparedStatement pst = null;

    private JLabel BodyTitle, FormField01, FormField02, FormField03;
    private JPanel contentPane;
    private JTextField textField02, textField03;
    private JTextField txt_Ava;
    private JTextField txt_Status;
    private JTextField txt_Room;
    Choice choice01;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateRoomStatus frame = new UpdateRoomStatus();
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

    public UpdateRoomStatus() throws SQLException {
        super("Update Room Status");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(530, 200, 1000, 450);

        BodyTitle = new JLabel("Update Room Status");
        BodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        BodyTitle.setBounds(85, 11, 206, 34);
        contentPane.add(BodyTitle);
            
        //Form
            FormField01 = new JLabel("Room Number");
            FormField01.setBounds(27, 87, 90, 14);
            contentPane.add(FormField01);
            choice01 = new Choice();
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from room");
                while(rs.next()){
                    choice01.add(rs.getString("room_number"));
                }
            }catch(Exception e){ }
            choice01.setBounds(160, 84, 140, 20);
            contentPane.add(choice01);

            FormField02 = new JLabel("Availability:");
            FormField02.setBounds(27, 187, 90, 14);
            contentPane.add(FormField02);
            textField02 = new JTextField();
            textField02.setBounds(160, 184, 140, 20);
            contentPane.add(textField02);
            textField02.setColumns(10);       

            FormField03 = new JLabel("Clean Status:");
            FormField03.setBounds(27, 240, 90, 14);
            contentPane.add(FormField03);
            textField03 = new JTextField();
            textField03.setBounds(160, 237, 140, 20);
            contentPane.add(textField03);
            textField03.setColumns(10);

        JButton button01 = new JButton("Check");
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String s1 = choice01.getSelectedItem();
                    conn c = new conn();
                    ResultSet rs1 = c.s.executeQuery("select * from room where room_number = "+s1);

                    while(rs1.next()){
                        textField02.setText(rs1.getString("availability")); 
                        textField03.setText(rs1.getString("clean_status")); 
                    }
                }catch(Exception ee){}
            }
        });
        button01.setBounds(120, 315, 89, 23);
        button01.setBackground(Color.BLACK);
        button01.setForeground(Color.WHITE);
        contentPane.add(button01);

        JButton button02 = new JButton("Update");
        button02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
                try{
                    conn c = new conn();
                    String s1 = choice01.getSelectedItem();

                    String str = "update room set clean_status = '"+textField03.getText()+"' where room_number = "+s1;
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Update Successful");

                    new Reception().setVisible(true);
                    setVisible(false);
                }catch (Exception ee){
                        ee.printStackTrace();
                }
            }
        });
        button02.setBounds(60, 355, 89, 23);
        button02.setBackground(Color.BLACK);
        button02.setForeground(Color.WHITE);
        contentPane.add(button02);

        JButton button03 = new JButton("Back");
        button03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        button03.setBounds(180, 355, 89, 23);
        button03.setBackground(Color.BLACK);
        button03.setForeground(Color.WHITE);
        contentPane.add(button03);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,80,600,250);
        add(l1);

        getContentPane().setBackground(Color.WHITE);
    }
}
