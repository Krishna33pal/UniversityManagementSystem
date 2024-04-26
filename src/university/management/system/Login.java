package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton cancel,login;
    JTextField tfusername,tfpassword;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(70, 50, 150, 40);
        lblusername.setFont(new Font("Serif",Font.BOLD,17));
         add(lblusername);
        tfusername = new JTextField();
        tfusername.setBounds(150, 50, 200, 40);
        add(tfusername);
       
        
        
        // ab password ke liye banayege
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(70, 100, 100, 40);
        lblpassword.setFont(new Font("Serif",Font.BOLD,17));
        add(lblpassword);
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 100, 200, 40);
        add(tfpassword);
        
      
        // ab button banayege login button
        login = new JButton("Login");
        login.setBounds(60, 170, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("TAMOHA",Font.BOLD,16));
        add(login);
        
        
        // ab cancel button banayege
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 170, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("TAMOHA",Font.BOLD,16));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        
        
        setSize(800,450);
        setLocation(250,200);
        setVisible(true);
        
    }
    
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
           String username = tfusername.getText();
           String password = tfpassword.getText();
           
           
           // my sql code
           
           
     String query = "select * from login where username = '"+username+"' and password = '"+password+"'";      
       
     try{
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery(query);
         if(rs.next()){
             setVisible(false);
             new Project();
         }else{
             JOptionPane.showMessageDialog(null, "Invalid Username & Password");
             setVisible(false);
         }
         
         // connection close ho chuka hain.
        c.s.close();
     }catch(Exception e){
         e.printStackTrace();
     }
           
           
           
        }else if(ae.getSource() == cancel){
           setVisible(false); 
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
