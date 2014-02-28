package App_code;

import java.io.Serializable;

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// unique identifier for the course
	private int courseId;
	// title of the course
	private String title;
	// number of credits the course is worth
	private int numberOfCredits;
	// grade of the course
	private String grade;
	/**
	 * Default constructor
	 */
	public Course()
	{
		title = grade = null;
		numberOfCredits = courseId = 0;
	}
	/**
	 * Overloaded Constructor
	 * @param courseID unique identifier of the course
	 * @param courseTitle title of the course
	 * @param credits number of credits the course is worth
	 * @param courseGrade grade the student got in the course
	 */
	public Course(int courseID, String courseTitle, int credits, String courseGrade)
	{
		courseId = courseID;
		title = courseTitle;
		numberOfCredits = credits;
		grade = courseGrade;
	}
	/**
	 * Getter method
	 * @return
	 * 	returns the unique course identifier
	 */
	public int getCourseId()
	{
		return courseId;
	}
	/**
	 * Setter method
	 * @param courseID Unique identifier of the course
	 * 	
	 */
	public void setCourseId(int courseID)
	{
		courseId = courseID;
	}
	/**
	 * Getter method
	 * @return
	 * 	Gets the title of the course
	 */
	public String getCourseTitle()
	{
		return title;
	}
	/**
	 * setter method
	 * @param courseTitle title of the course
	 */
	public void setCourseTitle(String courseTitle)
	{
		title = courseTitle;
	}
	/**
	 * Getter method
	 * @return
	 * 	gets the number of credits for the course
	 */
	public int getNumOfCredits()
	{
		return numberOfCredits;
	}
	/**
	 * Setter method
	 * @param numOfCredits number of credits the course is worth
	 */
	public void setNumOfCredits(int numOfCredits)
	{
		numberOfCredits = numOfCredits;
	}
	/**
	 * Getter method
	 * @return
	 * 	the grade of the course
	 */
	public String getGrade()
	{
		return grade;
	}
	/**
	 * Setter method
	 * @param courseGrade grade of the course
	 */
	public void setGrade(String courseGrade)
	{
		grade = courseGrade;
	}
	/**
	 * 
	 * @param a_student
	 */
	public void addStudent(Student a_student)
	{
		// is this really needed?
	}
	/**
	 * 
	 * @param a_student
	 * @return
	 */
	public boolean deleteStudent(Student a_student)
	{
		return true;
	}
	/**
	 * 
	 * @param a_tech_id
	 * @return
	 */
	public boolean deleteStudent(int a_tech_id)
	{
		return true;
	}
	/**
	 * 
	 * @return
	 */
	public boolean writeToFile()
	{
		return true;
	}
	/**
	 * 
	 * @return
	 */
	public StudentCollection readFromFile()
	{
		return new StudentCollection();
	}
	
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		
		string.append("\t Course ID: " + courseId);
		string.append("\t Title: " + title);
		string.append("\t Number of credits: " + numberOfCredits);
		string.append("\t Grade: " + grade);
		
		return string.toString();
	}
}