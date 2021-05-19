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

public class Starting extends JFrame implements ActionListener
{
	Label title = new Label("Students Details System");
	//Label title2 =new Label("OWNER");
	Button logino= new Button("Admin Login");
	Button logine= new Button("Student Login");
	Button Exist= new Button("Exit");
	
	
	Label dev = new Label("Developed By : Shreyas Fegade");
	Starting()
	{
		setSize(750,680); 
		setLocation(400,160);
		setTitle("Students Details System");
		JLabel label = new JLabel();
		setContentPane(label);
		getContentPane().setLayout(null);
		setBackground(Color.GREEN);
		title.setBounds(180,50,380,40);
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		getContentPane().add(title);
		dev.setBackground(Color.GREEN);
		dev.setAlignment(Label.CENTER);
//		title2.setBounds(300,110,150,40);
//		title2.setFont(new Font("Serif", Font.BOLD, 30));
//		add(title2);
		
		dev.setBounds(150, 560, 400, 30);
		dev.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(dev);
		
		
		
		logino.setBounds(250,200,200,60);
		getContentPane().add(logino);
		logino.addActionListener(this);

		logine.setBounds(250,300,200,60);
		getContentPane().add(logine);
		logine.addActionListener(this);

		Exist.setBounds(250,400,200,60);
		getContentPane().add(Exist);
		Exist.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="Admin Login")
		{   
			LoginAdmin lo=new LoginAdmin();
			lo.setLocationRelativeTo(null);
			lo.setVisible(true);
			dispose();
			//setVisible(false);
		}


		if(e.getActionCommand()=="Student Login")
		{
			LoginUser le=new LoginUser();
			le.setLocationRelativeTo(null);
			le.setVisible(true);
			dispose();
			//setVisible(false);
		
		
		}
		if(e.getActionCommand()=="Exit")
		{
			System.exit(0);
		}
	}

	
	public static void main(String args[])
	{
		Starting s= new Starting();
		s.setLocationRelativeTo(null);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
	}
}

