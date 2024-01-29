package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCustomerStatus extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private JLabel BodyTitle, FormField01, FormField02, FormField03, FormField04, FormField05, FormField06;
    private JPanel contentPane;
    private JTextField textField02, textField03, textField04, textField05, textField06;
    Choice choice01;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCustomerStatus frame = new UpdateCustomerStatus();
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

    public UpdateCustomerStatus() throws SQLException {
        super("Update Customer Status");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(500, 200, 950, 500);
        
        BodyTitle = new JLabel("Check-In Details");
        BodyTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        BodyTitle.setBounds(124, 11, 222, 25);
        contentPane.add(BodyTitle);        

        // Form
            FormField01 = new JLabel("ID:");
            FormField01.setBounds(25, 88, 46, 14);
            contentPane.add(FormField01);
            choice01 = new Choice();
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from customer");
                while(rs.next()){
                    choice01.add(rs.getString("number"));    
                }
            }catch(Exception e){ }
            choice01.setBounds(248, 85, 140, 20);
            contentPane.add(choice01);

            FormField02 = new JLabel("Room Number :");
            FormField02.setBounds(25, 129, 107, 14);
            contentPane.add(FormField02);
            textField02 = new JTextField();
            textField02.setBounds(248, 126, 140, 20);
            contentPane.add(textField02);

            FormField03 = new JLabel("Name : ");
            FormField03.setBounds(25, 174, 97, 14);
            contentPane.add(FormField03);
            textField03 = new JTextField();
            textField03.setBounds(248, 171, 140, 20);
            contentPane.add(textField03);
            textField03.setColumns(10);

            FormField04 = new JLabel("Checked-in :");
            FormField04.setBounds(25, 216, 107, 14);
            contentPane.add(FormField04);
            textField04 = new JTextField();
            textField04.setBounds(248, 216, 140, 20);
            contentPane.add(textField04);
            textField04.setColumns(10);

            FormField05 = new JLabel("Amount Paid (Rs) : ");
            FormField05.setBounds(25, 261, 107, 14);
            contentPane.add(FormField05);
            textField05 = new JTextField();
            textField05.setBounds(248, 258, 140, 20);
            contentPane.add(textField05);
            textField05.setColumns(10);

            FormField06 = new JLabel("Pending Amount (Rs) : ");
            FormField06.setBounds(25, 302, 150, 14);
            contentPane.add(FormField06);
            textField06 = new JTextField();
            textField06.setBounds(248, 299, 140, 20);
            contentPane.add(textField06);
            textField06.setColumns(10);

        JButton button01 = new JButton("Check");
        button01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String s1 = choice01.getSelectedItem();
                    conn c = new conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where number = "+s1);

                    while(rs1.next()){
                        textField02.setText(rs1.getString("room_number"));    
                        textField03.setText(rs1.getString("name"));    
                        textField04.setText(rs1.getString("status"));    
                        textField05.setText(rs1.getString("deposit"));    
                    }
                }catch(Exception ee){}

                try{
                    String total = "";
                    conn c  = new conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+textField02.getText());
                    while(rs2.next()){
                        total = rs2.getString("price"); 
                    }
                    String paid = textField05.getText();
                    int pending = Integer.parseInt(total)- Integer.parseInt(paid);
                    textField06.setText(Integer.toString(pending));
                }catch(Exception ee){}
            }
        });
        button01.setBounds(56, 378, 89, 23);
        button01.setBackground(Color.BLACK);
        button01.setForeground(Color.WHITE);
        contentPane.add(button01);
        
        JButton button02 = new JButton("Update");
        button02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) { 
                try{
                    conn c = new conn();

                    String s1 = choice01.getSelectedItem();
                    String s2 = textField02.getText();  
                    String s3 = textField03.getText();  
                    String s4 = textField04.getText();  
                    String s5 = textField05.getText();  

                    c.s.executeUpdate("update customer set room_number = '"+s2+"', name = '"+s3+"', status = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");

                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(Exception ee){
                    System.out.println(ee);
                }              
            }
        });
        button02.setBounds(168, 378, 89, 23);
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
        button03.setBounds(281, 378, 89, 23);
        button03.setBackground(Color.BLACK);
        button03.setForeground(Color.WHITE);
        contentPane.add(button03); 
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450,70,476,270);
        add(l1);        

        getContentPane().setBackground(Color.WHITE);
    }
}
