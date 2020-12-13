import java.util.ArrayList;

public interface IStudent {
	public ArrayList<String[]> viewOpenCourses();
	public void enrollInCourse(String courseID, String sectionNumber);
	public void dropCourse(String courseId, String sectionNumber);
	public void viewCurrentReg();
	}
