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
	ArrayList<JComponent> Adminbuttons, CreCourseScreen,delCourseScreen,editCourseScreen,regStScreen,viewFullScreen,writeFullScreen,sortScreen,displayInfoScreen;
	JButton BcreateCourse, BdeleteCourse, BeditCourse, BregisterStudent, BviewAllFull, BwriteFull, BsortCourses, BdisplayCourseInfo, Breturn, enterCourse;
	JTextField cName, cId, cInstr,cLoc,sSecNum,cCap;
	String ADMIN_USER,ADMIN_PASS;
	Admin mainAdmin;
	public SYSGUI() {
		initializeLayout();
		homeScreen();
		
		
	}
	public void initializeLayout()
	{
		mainAdmin = new Admin(ADMIN_USER,ADMIN_PASS,"admin","admin");
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
		
		
		BcreateCourse = new JButton("Create course");
		BdeleteCourse = new JButton("Delete course");
		BeditCourse = new JButton("Edit course");
		BregisterStudent = new JButton("Register student");
		BviewAllFull = new JButton("View full courses");
		BwriteFull = new JButton("Write file of full courses");
		BsortCourses = new JButton("Sort Courses");
		BdisplayCourseInfo = new JButton("Display info for course");
		Breturn = new JButton("Return to home");
		Adminbuttons = new ArrayList<JComponent>();
		CreCourseScreen = new ArrayList<JComponent>();
		
		
		
		Adminbuttons.add(BcreateCourse);
		Adminbuttons.add(BdeleteCourse);
		Adminbuttons.add(BeditCourse);
		Adminbuttons.add(BregisterStudent);
		Adminbuttons.add(BviewAllFull);
		Adminbuttons.add(BwriteFull);
		Adminbuttons.add(BsortCourses);
		Adminbuttons.add(BdisplayCourseInfo);
		Adminbuttons.add(Breturn);
		
		cName = new JTextField("Course Name"); 
		cId = new JTextField("Course ID");
		cInstr = new JTextField("Course Instructor");
		cLoc = new JTextField("Course Location");
		sSecNum = new JTextField("Course Section Number");
		cCap = new JTextField("Max Capacity");
		enterCourse = new JButton("Confirm Add");
		
		CreCourseScreen.add(cName);
		CreCourseScreen.add(cId);
		CreCourseScreen.add(cInstr);
		CreCourseScreen.add(cLoc);
		CreCourseScreen.add(sSecNum);
		CreCourseScreen.add(cCap);
		CreCourseScreen.add(enterCourse);
		
		int initialY = 100;
		for(JComponent i: Adminbuttons) {
			i.setBounds(600,initialY,300,50);
			i.setVisible(false);
			initialY+=50;
		}	
		frame.add(panel);
		panel.add(titleText);
		
		frame.setSize(1920,1080);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	public void studentLoginUI() {
		
	}
	public void studentUI() {
		
	}
	public void adminUI() {
	
		
		addComptoPanel(Adminbuttons);
		
		setComponentState(Adminbuttons, true);
		BcreateCourse.addActionListener(new ActionListener() { //Button to Create a course
			
			
			
			 public void actionPerformed(ActionEvent e) {
					JButton back = new JButton("Back");
					back.setBounds(600,450,150,50);
					panel.add(back);
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							back.setVisible(false);
							setComponentState(CreCourseScreen, false);
							adminUI();
						}
					});
				 int initialY = 100;
				 
				 for(JComponent i: CreCourseScreen) {
					 i.setBounds(600,initialY,300,50);
					 initialY += 50;
				 }
				 
				 setComponentState(Adminbuttons, false);
				 
				 addComptoPanel(CreCourseScreen);
				 
				 setComponentState(CreCourseScreen, true);
				 enterCourse.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) { //Button to confirm add course
				 
				  mainAdmin.createCourse(cName.getText(), cId.getText(), cInstr.getText(), sSecNum.getText(), cLoc.getText(), Integer.parseInt(cCap.getText()));
				  for(Course k: CourseData.allCourses) {
					  System.out.println(k.getCourseName());
				  }
			 }
		 });
				 
				
				 
				 
			 }
		 });
		BdeleteCourse.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 setComponentState(Adminbuttons, false);
				 
			 }
		 });
		BeditCourse.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BregisterStudent.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BviewAllFull.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BwriteFull.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BsortCourses.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BwriteFull.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
		Breturn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
	}
	public void setComponentState(ArrayList<JComponent> compList, boolean isActive) {
for(JComponent i: compList) {
			
			i.setVisible(isActive);
			
		}
	}
	public void addComptoPanel(ArrayList<JComponent> comp) {
		for(JComponent i: comp) {
			panel.add(i);
		}
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
				 ADMIN_USER = "Admin";
				 ADMIN_PASS = "Admin001";
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
				 adminUI(); //Should be AdminLoginUI() 
			 }
		 });
		 
	}
}


