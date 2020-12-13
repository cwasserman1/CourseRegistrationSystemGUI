import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
		CourseData.main();
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
	public void setDefaultLayout(int start,ArrayList<JComponent> compList) {
		int initialY = start;
		for(JComponent i: compList) {
			 i.setBounds(600,initialY,300,50);
			 initialY += 50;
		 }
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
					  System.out.print(k.getCourseName()+" ");
				  }
				  System.out.println();
			 }
		 });
				 
				
				 
				 
			 }
		 });
		BdeleteCourse.addActionListener(new ActionListener() { //Button to delete course
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
				 ArrayList<JComponent> thisScreen = new ArrayList<JComponent>();
				 JTextField delID, delSec;
				 JButton confirmDel, back;
				 back = new JButton("Back");
				 thisScreen.add(back);
				 delID = new JTextField("Course ID");
				 delSec = new JTextField("Course Section Number");
				 confirmDel = new JButton("Confirm Delete");
				 thisScreen.add(back);
				 thisScreen.add(delID); thisScreen.add(delSec); thisScreen.add(confirmDel);
				 
				 setDefaultLayout(100,thisScreen);
				 
				 addComptoPanel(thisScreen);
				 
				 confirmDel.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						mainAdmin.deleteCourse(delID.getText(), delSec.getText());
						System.out.println("Calling mainadmin.deletecourse");
						for(Course i: CourseData.allCourses) {
							System.out.println("Course1: "+ i.getCourseName()+" ");
						}
						 
						 
						
					 }
				 });
				 back.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 
						 setComponentState(thisScreen, false);
						 confirmDel.setVisible(false);
						 back.setVisible(false);
						 adminUI();						 
					 }
				 });
				 
				 
				 
			 }
		 });
		BeditCourse.addActionListener(new ActionListener() { //Button for admin to edit course
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BregisterStudent.addActionListener(new ActionListener() {// Button for admin to register student
			 public void actionPerformed(ActionEvent e) {
				 setComponentState(Adminbuttons, false);
				 ArrayList<JComponent> thisScreen = new ArrayList<JComponent>();
				 JTextField userName, password,fName,lName;
				 JButton register,back;
				 userName = new JTextField("User Name");
				 password = new JTextField("PassWord");
				 fName = new JTextField("First Name");
				 lName = new JTextField("Last Name");
				 register = new JButton("Register"); 
				 back = new JButton("Back");
				 
				 thisScreen.add(userName);  
				 thisScreen.add(password); thisScreen.add(fName); thisScreen.add(lName);
				 thisScreen.add(register);
				 thisScreen.add(back);
				 setDefaultLayout(100,thisScreen);
				 addComptoPanel(thisScreen);
				 setComponentState(Adminbuttons, false);
				 register.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 mainAdmin.registerStudent(userName.getText(), password.getText(), fName.getText(), lName.getText());
					 }
				 });
				 back.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 
						 setComponentState(thisScreen, false);
						 back.setVisible(false);
						 adminUI();						 
					 }
				 });
			 }
		 });
		BviewAllFull.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 ArrayList<JComponent> thisScreen = new ArrayList<JComponent>();
				 JLabel title = new JLabel("Full Courses");
				 JLabel body = new JLabel();
				 JButton back = new JButton("Back");
				 
				 thisScreen.add(title); thisScreen.add(body);thisScreen.add(back);
				 addComptoPanel(thisScreen); 
				 setDefaultLayout(100,thisScreen);
				 body.setText(mainAdmin.viewAllFull());
				 back.addActionListener(new ActionListener() {
 					 public void actionPerformed(ActionEvent e) {
						 
						 setComponentState(thisScreen, false);
						 back.setVisible(false);
						 adminUI();						 
					 }
				 });
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BwriteFull.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 ArrayList<JComponent> thisScreen = new ArrayList<JComponent>();
				 JLabel title = new JLabel("Write a file of the full courses");
				 JTextField body = new JTextField("File Name");
				 JButton back = new JButton("Back");
				 JButton writeFile = new JButton("Write File");
				 
				 thisScreen.add(title); thisScreen.add(body);thisScreen.add(back); thisScreen.add(writeFile);
				 addComptoPanel(thisScreen);
				 
				 setDefaultLayout(100,thisScreen);
				 body.setText(mainAdmin.viewAllFull());
				 writeFile.addActionListener(new ActionListener() {
 					 public void actionPerformed(ActionEvent e) {
						 mainAdmin.writeFull(body.getText());				 
					 }
				 });
				 back.addActionListener(new ActionListener() {
 					 public void actionPerformed(ActionEvent e) {
						 
						 setComponentState(thisScreen, false);
						 back.setVisible(false);
						 adminUI();						 
					 }
				 });
				 setComponentState(Adminbuttons, false);
			 }
		 });
		BsortCourses.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 ArrayList<JComponent> thisScreen = new ArrayList<JComponent>();
				 JButton back = new JButton("Back");
				 mainAdmin.sortCourses();
				 String[] columns = {"Course Name", "Course ID","Course Instructor", "Section Number","Location","Max Capacity"};
				 String[][] currentCourses = new String[CourseData.allCourses.size()][6];
				 for(int i = 0; i<CourseData.allCourses.size();i++) {
					 currentCourses[i][0] = CourseData.allCourses.get(i).getCourseName();
					 currentCourses[i][1] = CourseData.allCourses.get(i).getCourseId();
					 currentCourses[i][2] = CourseData.allCourses.get(i).getCourseInstructor();
					 currentCourses[i][3] = CourseData.allCourses.get(i).getSectionNumber();
					 currentCourses[i][4] = CourseData.allCourses.get(i).getLocation();
					 currentCourses[i][5] = String.valueOf(CourseData.allCourses.get(i).getMaxReg());
					
				 }
				 JTable courseTable = new JTable(currentCourses,columns);
				 thisScreen.add(courseTable);thisScreen.add(back);
				 courseTable.setBounds(400,100, 1000, 750);
				 addComptoPanel(thisScreen);
				 back.setBounds(100, 50, 150, 50);
				 setComponentState(Adminbuttons, false);
				 back.addActionListener(new ActionListener() {
 					 public void actionPerformed(ActionEvent e) {
						 
						 setComponentState(thisScreen, false);
						 back.setVisible(false);
						 adminUI();						 
					 }
				 });
			 }
			 
			 
		 });
		BdisplayCourseInfo.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 setComponentState(Adminbuttons, false);
				 ArrayList<JComponent> thisScreen = new ArrayList<JComponent>();
				 JButton back = new JButton("Back");
				 JButton enter = new JButton("Enter");
				 JTextField courseID = new JTextField("Course ID");
				 JTextField secNum = new JTextField("Section Number");
				 
				 
				 
				 DefaultTableModel model = new DefaultTableModel();
				 model.addColumn("Course Name");
				 model.addColumn("Course ID");
				 model.addColumn("Course Instructor");
				 model.addColumn("Section Number");
				 model.addColumn("Location");
				 model.addColumn("Max Capacity");
				 JTable courseTable = new JTable(model);
				 
				 thisScreen.add(courseID); thisScreen.add(secNum);thisScreen.add(enter); thisScreen.add(back); thisScreen.add(courseTable);
				 addComptoPanel(thisScreen);
				 setDefaultLayout(100,thisScreen);
				 courseTable.setBounds(400,400, 1000, 400);
				 
				 enter.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 
				  model.addRow(mainAdmin.displayCourseInfo(courseID.getText(), secNum.getText()));
			 }
		 });
				 back.addActionListener(new ActionListener() {
 					 public void actionPerformed(ActionEvent e) {
						 
						 setComponentState(thisScreen, false);
						 back.setVisible(false);
						 courseTable.setVisible(false);
						 courseTable.setEnabled(false);
						 adminUI();						 
					 }
				 });
			 }
			 
		 });
		Breturn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 // ,   JTextField course
				 setComponentState(Adminbuttons, false);
				 homeScreen();
			 }
		 });
	}
	public void setComponentState(ArrayList<JComponent> compList, boolean isActive) {
for(JComponent i: compList) {
			i.setOpaque(true);
			i.setVisible(isActive);
			i.setEnabled(isActive);
			
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


