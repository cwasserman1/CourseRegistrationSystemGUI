import java.util.*;
import java.io.*;
public class Admin extends User implements IAdmin{

	public Admin(String username, String password, String fname, String lname) {
		super(username, password, fname, lname);
	}

	@Override
	public void createCourse(String courseName, String courseId, String courseInstructor, String sectionNumber, String location, int maxReg) {
		CourseData.addCourse(courseName, courseId, courseInstructor, sectionNumber, location, maxReg);
	}

	@Override
	public void deleteCourse(String courseId, String sectionNumber) {//Deletes desired course
		
		
		CourseData.removeCourse(courseId, sectionNumber);
		
	}

	@Override
	public void editCourse() {//Allows user to edit either the instructor or the location of the course
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the following information about the course you would like to edit");
			System.out.println("Course ID");
			String ID = sc.nextLine();
			System.out.println("Section Number");
			String sectionNumber = sc.nextLine();
			
			
			for(Course i: CourseData.getAllCourses()) {
				if(i.getCourseId().equals(ID)&&i.getSectionNumber().equals(sectionNumber)) {
					System.out.println("What details would you like to edit?");
					System.out.println("1. Instructor \n 2. Location");
					String resp = sc.nextLine();
					switch(Integer.parseInt(resp)) {
					case 1:
						System.out.println("New instructor name: ");
						resp = sc.nextLine();
						CourseData.allCourses.get(CourseData.allCourses.indexOf(i)).setCourseInstructor(resp);
						break;
					case 2:
						System.out.println("New Location name: ");
						resp = sc.nextLine();
						CourseData.allCourses.get(CourseData.allCourses.indexOf(i)).setLocation(resp);
						
						break;
					
					}
				}
				}
				}catch(Exception e) {
					System.out.println(e);}}
		

	@Override
	public String[] displayCourseInfo(String courseId, String sectionNumber) {//Displays desired course info
		String[] targetCourse = new String[6];
		for(Course i: CourseData.getAllCourses()) {
			if(i.getCourseId().equals(courseId)&&i.getSectionNumber().equals(sectionNumber)) {
				targetCourse[0] = CourseData.allCourses.get(0).getCourseName();
				targetCourse[1] = CourseData.allCourses.get(0).getCourseId();
				 targetCourse[2] = CourseData.allCourses.get(0).getCourseInstructor();
				 targetCourse[3] = CourseData.allCourses.get(0).getSectionNumber();
				 targetCourse[4] = CourseData.allCourses.get(0).getLocation();
				 targetCourse[5] = String.valueOf(CourseData.allCourses.get(0).getMaxReg());
				
				
				}
			}
		return targetCourse;
		
	}

	@Override
	public void registerStudent(String username, String password, String fname, String lname) {//Registers a new student into the system
		
		CourseData.addStudent(username,password,fname,lname);
		
	}

	
	
	

	@Override
	public void Exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String viewAllFull() {//Allows admin to view all full courses
		String list_of_full = "";
		for(Course i: CourseData.allCourses) {
			if(i.checkFull())
				list_of_full +=i;
		}
		return list_of_full;
	}

	@Override
	public void writeFull(String fileName) {// Makes a .txt file of full courses
		
		
		try {
			FileWriter writer = new FileWriter(fileName);
			for(Course i: CourseData.getAllCourses()) {
				if(i.checkFull()==true) {
					writer.write("Name: "+i.getCourseName()+"\nID:"+i.getCourseId()+"\n Instructor: "+i.getCourseInstructor()+ "\n  Section Number: "+i.getSectionNumber());
					writer.write("Location"+i.getLocation()+"\n Max Capacity: "+i.getMaxReg()+"Current number enrolled: "+ i.getCurrentReg());
					
				}
				
			}
			writer.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}


	@Override
	public void sortCourses() {//Displays courses sorted from highest to lowest capacity
	ArrayList<Course> allCoursesCopy = new ArrayList<Course>();
	allCoursesCopy.addAll(CourseData.getAllCourses());
	Collections.sort(allCoursesCopy,(c1, c2) -> c1.getCurrentReg()-c2.getCurrentReg());
	int count = 0;
	String result = "";
	

}
}