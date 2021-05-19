
/*
NAME : FEGADE SHREYAS MANOJ
PRN : 1741019
BATCH : B-1
CLASS : LY COMP
AIM : STUDENTS DETAILS SYSTEM USING JAVA SWING JDBC MYSQL DATABASE
*/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField pass;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField email;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JLabel gender;
	private JRadioButton female;
	private ButtonGroup gengp;
	private String gend;
	private JRadioButton male;
	private JLabel add;
	private JLabel newlabel3;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	private String dates[]
			= { "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30",
				"31" };
	private String months[]
			= { "Jan", "feb", "Mar", "Apr",
				"May", "Jun", "July", "Aug",
				"Sup", "Oct", "Nov", "Dec" };
	private String years[]
			= { "1995", "1996", "1997", "1998",
				"1999", "2000", "2001", "2002",
				"2003", "2004", "2005", "2006",
				"2007", "2008", "2009", "2010",
				"2011", "2012", "2013", "2014",
				"2015", "2016", "2017", "2018",
				"2019" };
	private JTextField address;
	private JTextField nationality;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration()
	{
		
	}
	
	
	public Registration(String c_log) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		name = new JTextField();
		name.setBounds(128, 82, 209, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(128, 158, 209, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(160, 27, 177, 30);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 85, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(45, 159, 73, 14);
		contentPane.add(lblNewLabel_2);
		dob = new JLabel("DOB:");
		dob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dob.setSize(73, 20);
		dob.setLocation(45, 195);
		contentPane.add(dob);

		date = new JComboBox(dates);
		date.setFont(new Font("Arial", Font.PLAIN, 15));
		date.setSize(50, 20);
		date.setLocation(128, 196);
		contentPane.add(date);

		month = new JComboBox(months);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setSize(60, 20);
		month.setLocation(189, 196);
		contentPane.add(month);

		year = new JComboBox(years);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setSize(60, 20);
		year.setLocation(259, 196);
		contentPane.add(year);
		
		gender = new JLabel("Gender:");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gender.setSize(100, 20);
		gender.setLocation(45, 229);
		contentPane.add(gender);

		male = new JRadioButton("Male");
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gend="male";
			}
		});
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSize(75, 20);
		male.setLocation(128, 230);
		
		contentPane.add(male);

		female = new JRadioButton("Female");
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gend="female";
			}
		});
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		female.setSize(80, 20);
		female.setLocation(227, 230);
		
		contentPane.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);
		
		
		newlabel3 = new JLabel("Email:");
		newlabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newlabel3.setBounds(45, 122, 73, 19);
		contentPane.add(newlabel3);
		
		email = new JTextField();
		email.setBounds(128, 123, 209, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		add = new JLabel("Address:");
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.setBounds(45, 265, 60, 14);
		contentPane.add(add);
		
		address = new JTextField();
		address.setBounds(117, 260, 220, 87);
		contentPane.add(address);
		address.setColumns(10);	
			
		
	
		btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(189, 438, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
					PreparedStatement ps=conn.prepareStatement("insert into user(Name,Email,Password,DOB_DAY,DOB_MONTH,DOB_YEAR,Gender,Address,Nationality) values(?,?,?,?,?,?,?,?,?);");
					ps.setString(1, name.getText());
					ps.setString(2, email.getText());
					ps.setString(3, pass.getText());
					ps.setString(4, date.getSelectedItem().toString());
					ps.setString(5, month.getSelectedItem().toString());
					ps.setString(6, year.getSelectedItem().toString());
					ps.setString(7, gend);
					
					ps.setString(8, address.getText());
					ps.setString(9, "INDIAN");
					
					int flag1=0,flag2=0,flag3=0;
					if(name.getText()!=null && email.getText()!=null && pass.getText()!=null && date.getSelectedItem()!=null && month.getSelectedItem()!=null && year.getSelectedItem()!=null && gend!=null && address.getText()!=null)
					{
						flag1 = 1;
					}
					
					String s = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
					Pattern emailPattern = Pattern.compile(s);
					Matcher m = emailPattern.matcher(email.getText());
					if(m.matches())
					{
						flag2=1;
					}
					
					
					String sql = "SELECT * FROM user;";
		            System.out.println(sql);
			        PreparedStatement crr = conn.prepareStatement(sql);
		            ResultSet res = crr.executeQuery();
		            //System.out.println(rs);
		            
		            while (res.next()) 
		              {
		                  String us_email = res.getString("Email");
		                  if((email.getText()).equals(us_email)) {
		                	  flag3=0;
		                	  JOptionPane.showMessageDialog(null, "Email already registered");
		                	  break;
		                  }
		                  else 
		                  {
		                	flag3=1;  
		                  }
		              }
		            if(flag1==1 && flag2==1 && flag3==1) 
		            {
						int x = ps.executeUpdate();
						if(x > 0) {
							JOptionPane.showMessageDialog(null, "Record Added...");
							System.out.println("Registration done successfully..");
							if(c_log=="adm")
							{
								AdminDash ad = new AdminDash();
								ad.setLocationRelativeTo(null);
								ad.setVisible(true);
								dispose();
							}
							else
							{
								LoginUser la = new LoginUser();
								la.setLocationRelativeTo(null);
								la.setVisible(true);
								dispose();
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Unable to add record.Please Enter valid Details or Email is already registered");
							System.out.println("Registration Failed..");
							LoginUser la = new LoginUser();
							la.setLocationRelativeTo(null);
							la.setVisible(true);
							dispose();
	
						}
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Unable to add record.Please Enter all the details");
						System.out.println("Registration Failed..");
						LoginUser la = new LoginUser();
						la.setLocationRelativeTo(null);
						la.setVisible(true);
						dispose();
		            }
				}catch(Exception e1 ) {
					System.out.println(e1);
				}
			}
		});


		
//		nationality = new JTextField();
//		nationality.setBounds(117, 385, 220, 20);
//		contentPane.add(nationality);
//		nationality.setColumns(10);
		
	}

	

}
