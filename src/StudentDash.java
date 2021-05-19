/*
NAME : FEGADE SHREYAS MANOJ
PRN : 1741019
BATCH : B-1
CLASS : LY COMP
AIM : STUDENTS DETAILS SYSTEM USING JAVA SWING JDBC MYSQL DATABASE
*/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StudentDash extends JFrame {

	private static int temp_day=0;
	private static String temp_month="";
	private static int temp_year=0;
	private static int flag_logbck=0;
	private JPanel contentPane;
	private JTextField name;
	private JTextField pass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField email;
	private JLabel addrs;
	private JLabel dob;
	private JComboBox date;
	private JTextField full_date;
	private JComboBox month;
	private JComboBox year;
	private JLabel gender;
	private JTextField genTextField;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private static String gend;
	private JLabel newlabel3;
	private JButton btnNewButton;
	private JTextField address;
	private JTextField nationality;
	private JButton editbtn;
	private JButton logoutbtn;
	private JButton backbtn;
	private JTextField userId;
	
	private String dates[]
			= { "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30",
				"31" };
	private String months[]
			= { "Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "July", "Aug",
				"Sup", "Oct", "Nov", "Dec" };
	private String years[]
			= { "1995", "1996", "1997", "1998",
				"1999", "2000", "2001", "2002",
				"2003", "2004", "2005", "2006",
				"2007", "2008", "2009", "2010",
				"2011", "2012", "2013", "2014",
				"2015", "2016", "2017", "2018",
				"2019","2020","2021" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDash frame = new StudentDash();
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
	public StudentDash()
	{
		
	}
	
	public StudentDash(int userId,String c_log) {
		setTitle("Students Details System");
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
		
		lblNewLabel = new JLabel("Student Data");
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
		
		
		full_date = new JTextField();
		full_date.setSize(100, 20);
		full_date.setLocation(128, 196);
		contentPane.add(full_date);
		full_date.setVisible(false);
		full_date.setColumns(20);
		contentPane.add(full_date);
		
		
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
		
		genTextField = new JTextField();
		genTextField.setSize(75, 20);
		genTextField.setLocation(128, 230);
		genTextField.setVisible(false);
		genTextField.setColumns(10);		
		contentPane.add(genTextField);

		
		addrs = new JLabel("Address:");
		addrs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addrs.setBounds(45, 265, 60, 14);
		contentPane.add(addrs);
		
		address = new JTextField();
		address.setSize(80, 20);
		address.setBounds(117, 260, 220, 87);
		contentPane.add(address);
		address.setColumns(10);
		
		
		newlabel3 = new JLabel("Email:");
		newlabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newlabel3.setBounds(45, 122, 73, 19);
		contentPane.add(newlabel3);
		
		email = new JTextField();
		email.setSize(100, 20);
		email.setBounds(128, 123, 209, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
	        System.out.println("Data fetching for Id:"+userId);
	        String sql = "SELECT * FROM user WHERE id="+userId+";";
	        System.out.println(sql);
	        PreparedStatement ps = con.prepareStatement(sql);
			
	        ResultSet rs = ps.executeQuery();
	        System.out.println(rs);
	        while (rs.next())
            {
	        	String usname = rs.getString("Name");
                String uemail = rs.getString("Email");
                String upass = rs.getString("Password");
                int day_dob = rs.getInt("DOB_DAY");
                String month_dob = rs.getString("DOB_MONTH");
                int year_dob = rs.getInt("DOB_YEAR");
                String gen = rs.getString("Gender");
                String addr = rs.getString("Address");
             
                //System.out.println(usname+uemail+upass+day_dob+month_dob+year_dob+gen+addr);
                
                temp_day=day_dob;
                temp_month=month_dob;
                temp_year=year_dob;
                
                
    	        date.setVisible(false);
    	        month.setVisible(false);
    	        year.setVisible(false);
    	        
    	        male.setVisible(false);
    	        female.setVisible(false);
    	        
    	        //System.out.println(uemail.getClass().getName());

    	        name.setText(usname);
                email.setText(uemail);
                pass.setText(upass);
                full_date.setVisible(true);
                full_date.setText(day_dob+"/"+month_dob+"/"+year_dob);
                genTextField.setVisible(true);
               
                genTextField.setText(gen);
                address.setText(addr);
                
                
                
                name.setEditable(false);
                email.setEditable(false);
                pass.setEditable(false);
                full_date.setEditable(false);
                genTextField.setEditable(false);
                address.setEditable(false);
                
                
            }
	        if(c_log=="adm")
	        {
	        	flag_logbck=1;
	        }
	        
	        
		}
		catch(Exception err)
		{
			System.out.println(err);
		}	
		
		editbtn = new JButton("Edit");
		editbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		editbtn.setBounds(100, 438, 89, 23);
		add(editbtn);
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(true);
				editbtn.setEnabled(false);
				name.setEditable(true);
                email.setEditable(true);
                pass.setEditable(true);
                
                full_date.setVisible(false);
                genTextField.setVisible(false);
                
                date.setVisible(true);
    	        month.setVisible(true);
    	        year.setVisible(true);
    	        
    	        male.setVisible(true);
    	        female.setVisible(true);
    	        
    	        if((genTextField.getText()).equals("male")) {
    	        	male.setSelected(true);
    	        }
    	        else {
    	        	female.setSelected(true);
    	        }
                
    	        date.setSelectedItem(Integer.toString(temp_day));
    	        month.setSelectedItem(temp_month);
    	        year.setSelectedItem(Integer.toString(temp_year));
    	        
                address.setEditable(true);
				
			}
		});
		
		

		
//		nationality = new JTextField();
//		nationality.setBounds(117, 385, 220, 20);
//		contentPane.add(nationality);
//		nationality.setColumns(10);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(189, 438, 89, 23);
		add(btnNewButton);
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
					PreparedStatement ps=conn.prepareStatement("UPDATE user SET Name=?,Email=?,Password=?,DOB_DAY=?,DOB_MONTH=?,DOB_YEAR=?,Gender=?,Address=?,Nationality=? WHERE id=?;");
					
					System.out.println(ps);
					ps.setString(1, name.getText());
					ps.setString(2, email.getText());
					ps.setString(3, pass.getText());
					ps.setString(4, date.getSelectedItem().toString());
					ps.setString(5, month.getSelectedItem().toString());
					ps.setString(6, year.getSelectedItem().toString());
					String temp_gender="";
					if(male.isSelected())
					{
						temp_gender="male";
					}
					else
					{
						temp_gender="female";
					}
					
					ps.setString(7, temp_gender);
					
					ps.setString(8, address.getText());
					ps.setString(9, "INDIAN");
					ps.setInt(10, userId);
					System.out.println("UserID to Update:"+userId);
					
					
					int x = ps.executeUpdate();
					if(x > 0) {
						JOptionPane.showMessageDialog(null, "Record Updated Successfully...");
						System.out.println("Registration done successfully..");
						StudentDash oa =new StudentDash(userId,c_log);
	                    oa.setLocationRelativeTo(null);
	                    oa.setVisible(true);
	      				dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable to Update record");
						System.out.println("Registration Failed..");

					}
				
				}
				catch(Exception e1 )
				{
					System.out.println(e1);
				}
			}
		});
		
		if(flag_logbck==1)
		{
			backbtn = new JButton("Back");
			backbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
			backbtn.setBounds(270, 438, 89, 23);
			add(backbtn);
			backbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminDash ad = new AdminDash();
					ad.setLocationRelativeTo(null);
					ad.setVisible(true);
					dispose();
					
				}
			});
		}
		else
		{		
			logoutbtn = new JButton("Logout");
			logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
			logoutbtn.setBounds(270, 438, 89, 23);
			add(logoutbtn);
			logoutbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Starting sa = new Starting();
					sa.setLocationRelativeTo(null);
					sa.setVisible(true);
					dispose();
					
				}
			});
		}
	}

	

}
