package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCustomer extends JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField textField02,textField03,textField05,textField07,textField08;
    JComboBox comboBox01;
    JRadioButton NewRadioButton01,NewRadioButton02;
    Choice fieldChoises06;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewCustomer frame = new NewCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NewCustomer() throws SQLException {
        super("NEW CUSTOMER FORM");
        
        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);

        JLabel BodyTitle = new JLabel("NEW CUSTOMER FORM");
        BodyTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        BodyTitle.setBounds(118, 11, 260, 53);
        contentPane.add(BodyTitle);

        // Form
            JLabel FormField01 = new JLabel("ID :");
            FormField01.setBounds(35, 76, 200, 14);
            contentPane.add(FormField01);
            comboBox01 = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
            comboBox01.setBounds(271, 73, 150, 20);
            contentPane.add(comboBox01);

            JLabel FormField02 = new JLabel("Number :");
            FormField02.setBounds(35, 111, 200, 14);
            contentPane.add(FormField02);
            textField02 = new JTextField();
            textField02.setBounds(271, 111, 150, 20);
            contentPane.add(textField02);
            textField02.setColumns(10);

            JLabel FormField03 = new JLabel("Name :");
            FormField03.setBounds(35, 151, 200, 14);
            contentPane.add(FormField03);
            textField03 = new JTextField();
            textField03.setBounds(271, 151, 150, 20);
            contentPane.add(textField03);
            textField03.setColumns(10);

            JLabel FormField04 = new JLabel("Gender :");
            FormField04.setBounds(35, 191, 200, 14);
            contentPane.add(FormField04);
            NewRadioButton01 = new JRadioButton("Male");
            NewRadioButton01.setFont(new Font("Raleway", Font.BOLD, 14));
            NewRadioButton01.setBackground(Color.WHITE);
            NewRadioButton01.setBounds(271, 191, 80, 12);
            add(NewRadioButton01);
            NewRadioButton02 = new JRadioButton("Female");
            NewRadioButton02.setFont(new Font("Raleway", Font.BOLD, 14));
            NewRadioButton02.setBackground(Color.WHITE);
            NewRadioButton02.setBounds(350, 191, 100, 12);
            add(NewRadioButton02);

            JLabel FormField05 = new JLabel("Country :");
            FormField05.setBounds(35, 231, 200, 14);
            contentPane.add(FormField05);
            textField05 = new JTextField();
            textField05.setBounds(271, 231, 150, 20);
            contentPane.add(textField05);
            textField05.setColumns(10);

            JLabel FormField06 = new JLabel("Allocation Room Number :");
            FormField06.setBounds(35, 274, 200, 14);
            contentPane.add(FormField06);
            fieldChoises06 = new Choice();
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from room where availability='Available'");
                while(rs.next()){
                    fieldChoises06.add(rs.getString("room_number"));    
                }
            }catch(Exception e){ }
            fieldChoises06.setBounds(271, 274, 150, 20);
            contentPane.add(fieldChoises06);

            JLabel FormField07 = new JLabel("Checked-In :");
            FormField07.setBounds(35, 316, 200, 14);
            contentPane.add(FormField07);
            textField07 = new JTextField();
            textField07.setBounds(271, 316, 150, 20);
            contentPane.add(textField07);
            textField07.setColumns(10);       

            JLabel FormField08 = new JLabel("Deposit :");
            FormField08.setBounds(35, 359, 200, 14);
            contentPane.add(FormField08);
            textField08 = new JTextField();
            textField08.setBounds(271, 359, 150, 20);
            contentPane.add(textField08);
            textField08.setColumns(10);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                
                String radio = null;
                if(NewRadioButton01.isSelected()){ 
                    radio = "Male";
                }
                else if(NewRadioButton02.isSelected()){ 
                    radio = "Female";
                }

                try{
                    String s1 = (String)comboBox01.getSelectedItem(); 
                    String s2 = textField02.getText();
                    String s3 = textField03.getText();                    
                    String s4 = radio;                
                    String s5 = textField05.getText();
                    String s6 = fieldChoises06.getSelectedItem();
                    String s7 = textField07.getText();
                    String s8 = textField08.getText();

                    String q1 = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                    String q2 = "update room set availability = 'Occupied' where room_number = "+s6;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
                catch(NumberFormatException s){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        buttonAdd.setBounds(100, 430, 120, 30);
        buttonAdd.setBackground(Color.BLACK);
        buttonAdd.setForeground(Color.WHITE);
        contentPane.add(buttonAdd);

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        }); 
        buttonBack.setBounds(260, 430, 120, 30);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        contentPane.add(buttonBack);

        getContentPane().setBackground(Color.WHITE);
    }
}
