import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
public class SYSGUI {
	JLabel titleText;
	JFrame frame;
	JButton adminB, studentB,Alogin;
	JTextField adminUser, adminPassword;
	JPanel panel;
	Font font1;
	
	public SYSGUI() {
		initializeLayout();
		loginUI();
		
	}
	public void initializeLayout()
	{
		font1 = new Font("SansSerif", Font.BOLD, 20);
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1920,1080);
		panel.setBackground(Color.cyan);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		titleText = new JLabel();
		titleText.setText("Course Registration System");
		titleText.setBounds(600, 50, 300,30);
		titleText.setFont(font1);
		panel.add(titleText);
		//panel.setVisible(true);
		frame.add(panel);
		frame.setSize(1920,1080);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	public void loginUI() {
		adminB = new JButton("Student Login");
		studentB = new JButton("Admin Login");
		adminB.setFont(font1);
		studentB.setFont(font1);
		panel.add(adminB);
		panel.add(studentB);
		adminB.setBounds(650, 500, 200, 100);
		studentB.setBounds(650, 300, 200, 100);;
		
		
	}
	public void studentLoginUI() {
		
	}
	public void studentUI() {
		
	}
	public void adminUI() {
		Alogin.setVisible(false);
	}
	public void adminLoginUI() {
		Alogin = new JButton("Login");
		Alogin.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String ADMIN_USER = "Admin";
				 String ADMIN_PASS = "Admin001";
				 if(adminUser.getText().strip().equals(ADMIN_USER)&&adminPassword.getText().strip().equals(ADMIN_PASS)) {
				 adminUI();
			 }}
		 });
		
	}
	public void buttons() {
		 adminB.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 studentB.setVisible(false);
				 adminLoginUI();				 
			 }
		 });
		 
	}
}


