import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
public class SYSGUI {
	JLabel titleText;
	JFrame frame;
	JButton adminB, studentB;
	JPanel panel;
	Font font1;
	
	public SYSGUI() {
		initializeLayout();
		homeScreen();
		
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
	public void studentLoginUI() {
		
	}
	public void studentUI() {
		
	}
	public void adminUI() {
		BregisterStudent.setBounds(600, 250, 300,50);
		BviewAllFull.setBounds(600, 300, 300,50);
		BwriteFull.setBounds(600, 350, 300,50);
		BsortCourses.setBounds(600, 400, 300,50);
		BdisplayCourseInfo.setBounds(600, 450, 300,50);
		Breturn.setBounds(600, 500, 500,50);
		
		
		
		panel.add(BcreateCourse); panel.add(BdeleteCourse); panel.add(BeditCourse); panel.add(BregisterStudent);panel.add(BviewAllFull);panel.add(BwriteFull);
		panel.add(BsortCourses); panel.add(BdisplayCourseInfo); panel.add(Breturn);
		
		BcreateCourse.setVisible(true);
		BdeleteCourse.setVisible(true);
		BeditCourse.setVisible(true);
		BregisterStudent.setVisible(true);
		BviewAllFull.setVisible(true);
		BwriteFull.setVisible(true);
		BsortCourses.setVisible(true);
		BdisplayCourseInfo.setVisible(true);
		Breturn.setVisible(true);
	
	}
	public void adminLoginUI() {
		
		
				 JTextField adminUserName = new JTextField("Username"); //Text fields for admin username and password entry
				 JTextField adminPassword = new JTextField("Password");
				 JButton loginButton = new JButton("Login");
				 
				 panel.add(adminUserName); panel.add(adminPassword); panel.add(loginButton);
				 adminUserName.setBounds(650, 200, 200, 50);
				 adminPassword.setBounds(650, 300, 200, 50);
				 loginButton.setBounds(650, 400, 80, 50);
				 
				 loginButton.setVisible(true);
				 adminUserName.setVisible(true);
				 adminPassword.setVisible(true);
				 String ADMIN_USER = "Admin";
				 String ADMIN_PASS = "Admin001";
				 loginButton.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 if(adminUserName.getText().strip().equals(ADMIN_USER)&&adminPassword.getText().strip().equals(ADMIN_PASS)) {
							 adminUserName.setVisible(false);
							 adminPassword.setVisible(false);
							 loginButton.setVisible(false);
							 adminUI();
					 }}
				 });
				 
				 }
	
	public void homeScreen() {
		adminB = new JButton("Admin Login");
		studentB = new JButton("Student Login");
		adminB.setFont(font1);
		studentB.setFont(font1);
		
		panel.add(adminB); panel.add(studentB);
		adminB.setBounds(650, 500, 200, 100);
		studentB.setBounds(650, 300, 200, 100);
		
		 adminB.addActionListener(new ActionListener() {//User chooses admin on home screen
			 
			 public void actionPerformed(ActionEvent e) {
				 adminB.setVisible(false);
				 studentB.setVisible(false);
				 adminLoginUI();	 
			 }
		 });
		 
	}
}


