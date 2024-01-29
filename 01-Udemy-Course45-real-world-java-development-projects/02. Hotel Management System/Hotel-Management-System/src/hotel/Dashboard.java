package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("Dashboard");
        setForeground(Color.CYAN);
        setLayout(null);
 	setVisible(true);
        setSize(1950,1090);
        
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);	
            JMenu MenuOption01 = new JMenu("HOTEL MANAGEMENT");
            MenuOption01.setForeground(Color.BLUE);
            menuBar.add(MenuOption01);
                JMenuItem SubMenu01Option01 = new JMenuItem("RECEPTION");
                MenuOption01.add(SubMenu01Option01);
                SubMenu01Option01.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        new Reception();
                    }
                });
            JMenu MenuOption02 = new JMenu("ADMIN");
            MenuOption02.setForeground(Color.RED);
            menuBar.add(MenuOption02);
                JMenuItem SubMenu02Option01 = new JMenuItem("ADD EMPLOYEE");
                MenuOption02.add(SubMenu02Option01);
                SubMenu02Option01.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        try{
                            new AddEmployee().setVisible(true);
                        }catch(Exception e ){}
                    }
                });
                JMenuItem SubMenu02Option02 = new JMenuItem("ADD ROOMS");
                MenuOption02.add(SubMenu02Option02);
                SubMenu02Option02.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        try{
                            new AddRoom().setVisible(true);
                        }catch(Exception e ){}
                    }
                });
                JMenuItem SubMenu02Option03 = new JMenuItem("ADD DRIVERS");
                MenuOption02.add(SubMenu02Option03);
                SubMenu02Option03.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        try{
                            new AddDrivers().setVisible(true);
                        }catch(Exception e ){}
                    }
                });      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);

        JLabel HotelManagementSystem = new JLabel("THE TAJ GROUP WELCOMES YOU");
        HotelManagementSystem.setForeground(Color.WHITE);
        HotelManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        HotelManagementSystem.setBounds(600, 60, 1000, 85);
        NewLabel.add(HotelManagementSystem);                

        getContentPane().setBackground(Color.WHITE);
    }
}
