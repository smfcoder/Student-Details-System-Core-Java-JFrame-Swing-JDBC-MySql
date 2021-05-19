/*
NAME : FEGADE SHREYAS MANOJ
PRN : 1741019
BATCH : B-1
CLASS : LY COMP
AIM : STUDENTS DETAILS SYSTEM USING JAVA SWING JDBC MYSQL DATABASE
*/


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class AdminDash extends JFrame{

	private JPanel contentPane;
	DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model){
        @Override
           public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
               Component component = super.prepareRenderer(renderer, row, column);
               int rendererWidth = component.getPreferredSize().width;
               TableColumn tableColumn = getColumnModel().getColumn(column);
               tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
               return component;
            }
        };
    
    
    
    JLabel userId = new JLabel("Enter User ID: ");
	JTextField userIdText = new JTextField();
	JButton del = new JButton("Delete");
	JButton upd = new JButton("Update");
	JButton crt = new JButton("Create");
	JButton logout = new JButton("Logout");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDash frame = new AdminDash();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Referesh() {  
	   userIdText.setText("");
	}
	/**
	 * Create the frame.
	 */
	public AdminDash() {
		setSize(628,449);
		setLocation(400,160);
		setTitle("Student Details System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setPreferredSize(new Dimension(550, 500));
		setContentPane(contentPane);
		
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		jtbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtbl.setEnabled(false);
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Password");
        model.addColumn("DOB_Day");
        model.addColumn("DOB_Month");
        model.addColumn("DOB_Year");
        model.addColumn("Gender");
        model.addColumn("Address");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM user");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getInt(5),Rs.getString(6),Rs.getInt(7),Rs.getString(8),Rs.getString(9)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        contentPane.add(cnt);
        
        userId.setBounds(200,490,100,50);
		contentPane.add(userId);
		userIdText.setBounds(400,490,100,50);
		userIdText.setColumns(10);
		contentPane.add(userIdText);
		

		crt.setBounds(320,490,100,50);
		contentPane.add(crt);
		
		crt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				String c_log = "adm";
				Registration sd = new Registration(c_log);
				sd.setLocationRelativeTo(null);
	            sd.setVisible(true);
				dispose();
			}
		});
		
		
		upd.setBounds(380,490,100,50);
		contentPane.add(upd);
		
		upd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String s1=userIdText.getText();
				try {
				if(s1!="")
				{
					String c_log = "adm";
					StudentDash sd = new StudentDash(Integer.parseInt(s1),c_log);
					sd.setLocationRelativeTo(null);
	                sd.setVisible(true);
					  dispose();
				}
				}
				catch(Exception err)
				{
					System.out.println("ID not entered");
					JOptionPane.showMessageDialog(null, "Please Enter Valid Student ID"); 
				}
			}
		});
		
		
		del.setBounds(450,490,100,50);
		contentPane.add(del);
		//del.addActionListener(this);
		
		
		
		logout.setBounds(450,500,100,50);
		contentPane.add(logout);
		
		
		del.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e)
		{
			String s1=userIdText.getText();
			try 
			{  
				if(s1!="") {
		        Class.forName("com.mysql.jdbc.Driver");  
		        // establish connection  
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");  
		        Statement statement = con.createStatement();  
		        statement.executeUpdate("DELETE FROM user WHERE id=" + s1 + ";");  
		        JOptionPane.showMessageDialog(null, "Record deleted...");  
		        statement.close();  
		        con.close();  
		        Referesh(); //Calling Referesh() method
		        AdminDash oa = new AdminDash();
		        oa.setLocationRelativeTo(null);
				oa.setVisible(true);
				dispose();
		    } 
			}
			catch (SQLException | ClassNotFoundException err)
			{  
		        JOptionPane.showMessageDialog(null, err);  
		    }
			catch(NullPointerException errnp)
			{
				JOptionPane.showMessageDialog(null, "Please Enter valid Student ID"); 
			}
		}
		});
		
		logout.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e)
			{
				Starting s= new Starting();
				s.setLocationRelativeTo(null);
				s.setVisible(true);
				dispose();
			}
		});
		
	}

}
