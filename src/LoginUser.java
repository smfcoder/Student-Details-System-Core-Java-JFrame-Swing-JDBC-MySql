/*
NAME : FEGADE SHREYAS MANOJ
PRN : 1741019
BATCH : B-1
CLASS : LY COMP
AIM : STUDENTS DETAILS SYSTEM USING JAVA SWING JDBC MYSQL DATABASE
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class LoginUser extends JFrame implements ActionListener
{
	Label title = new Label("Student Details System");
	Label title2 = new Label("Student Login");
	Label uname=new Label("User Name:");
	TextField unamet=new TextField();
	Label password=new Label("Password:");
	TextField passwordl=new TextField();

	Button logine=new Button("Login");
	Button cancel=new Button("Back");

	LoginUser()			
	{
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(750,680);
		setLocation(400,160);
		setTitle("Student Details System");
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(102,102,225));
		
		Font font1 =new Font("Verdana",Font.BOLD,20);

		title.setBounds(121,45,521,56);
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		getContentPane().add(title);
		
		title2.setBounds(282,108,280,40);
		//title2.setAlignment(Label.CENTER);
		title2.setFont(new Font("Serif", Font.BOLD, 30));
		getContentPane().add(title2);
		
		
		uname.setBounds(180,250,200,50);
		uname.setFont(font1);
		getContentPane().add(uname);

		unamet.setBounds(400,250,200,50);
		unamet.setFont(font1);
		getContentPane().add(unamet);
		
		password.setBounds(180,350,200,50);
		password.setFont(font1);
		getContentPane().add(password);
		passwordl.setEchoChar('*');
		passwordl.setBounds(400,350,200,50);
		passwordl.setFont(font1);
		getContentPane().add(passwordl);


		logine.setBounds(200,560,100,30);
		logine.setFont(font1);
		logine.setBackground(new Color(225,0,0));
		getContentPane().add(logine);
		logine.addActionListener(this);

		cancel.setBounds(500,560,100,30);
		cancel.setFont(font1);
		cancel.setBackground(new Color(225,0,0));
		getContentPane().add(cancel);
		cancel.addActionListener(this);
		
		JButton signUp = new JButton("Sign Up");
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c_log="stud";
				Registration ra = new Registration(c_log);
				ra.setLocationRelativeTo(null);
				ra.setVisible(true);
				dispose();
			}
		});
		signUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		signUp.setBounds(358, 560, 98, 30);
		getContentPane().add(signUp);
		

	}
	
	public void actionPerformed(ActionEvent e)
	{
	if(e.getActionCommand()=="Login")
	{	
          String s1 = unamet.getText();
          String s2 = passwordl.getText();
          int usid = 0;
          try 
          {
        	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
	          String sql = "SELECT * FROM user;";
              System.out.println(sql);
	          PreparedStatement ps = con.prepareStatement(sql);

              
              ResultSet rs = ps.executeQuery();
              System.out.println(rs);
              int flag=0;
              while (rs.next()) 
              {
                  String usname = rs.getString("Email");
                  String pass = rs.getString("Password");
                  int userId = rs.getInt("id");
                  //System.out.println(usname+pass+userId);
                  //System.out.println(s1+"|"+s2);
                  System.out.println(usname+"|"+s1);
                  if ((s1.equals(usname)) && (s2.equals(pass)))
                  {
                	  flag=1;
                	  usid=userId;
                	  String c_log="stud";
                	  JOptionPane.showMessageDialog(null,"Login Successfull");
                      StudentDash oa = new StudentDash(usid,c_log);
                      //oa.my_update(usid);
                      oa.setLocationRelativeTo(null);
                      oa.setVisible(true);
      				  dispose();
                	  break;
                          // rs.close();
                  }
              }
              if(flag==0)
              {
            	  JOptionPane.showMessageDialog(null,"No user found!.");
              }
              
			}
			catch(Exception err)
			{
				System.out.println(err);
			}
          
		}
        if(e.getActionCommand()=="Back")
		{
			Starting s= new Starting();
			s.setLocationRelativeTo(null);
			s.setVisible(true);
			//Loginemployee lee= new Loginemployee();
			//lee.setVisible(false);
			dispose();
		}
	}


	public static void main(String args[])
	{
		LoginUser le= new LoginUser();
		le.setLocationRelativeTo(null);
		le.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		le.setVisible(true);
	}
}

