package App_code;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Student Class holds courseList, name of the student, and a unique identifier
 * 
 * @author Group 3
 *
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2972997513722401418L;
	// list of courses the student has taken
	private ArrayList<Course> courseList;
	// name of the student
	private String name;
	// unique id of the student
	private int techId;
	/**
	 * Default constructor
	 */
	public Student()
	{
		name = null;
		techId = 0;
		courseList = new ArrayList<Course>();
	}
	/**
	 * Getter method
	 * @return
	 * 	All the courses the student has taken
	 */
	public ArrayList<Course> getCourseList()
	{
		return courseList;
	}
	/**
	 * Setter method
	 * @param courses list of courses to save
	 */
	public void setCourseList(ArrayList<Course> courses)
	{
		courseList = courses;
	}
	/**
	 * Getter method
	 * @return
	 * 	the name of the student
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Setter method
	 * @param a_name name of the student
	 */
	public void setName(String a_name)
	{
		name = a_name;
	}
	/**
	 * Getter method
	 * @return
	 * 	returns the unique identifier of the student
	 */
	public int getTechId()
	{
		return techId;
	}
	/**
	 * Setter method
	 * @param techID Unique identifier of the student
	 */
	public void setTechId(int techID)
	{
		techId = techID;
	}
	/**
	 * Adds a course to the Student
	 * @param a_course the course to be added
	 */
	public void addCourse(Course a_course)
	{
		courseList.add(a_course);
	}
	/**
	 * Deletes a course
	 * @param a_course course to be deleted
	 * @return
	 * 	returns true if the student if the course was successfully removed. Else, false.
	 */
	public boolean deleteCourse(Course a_course)
	{
		return courseList.remove(a_course);
	}
	/**
	 * Deletes a course
	 * @param course_id unique identifier of the course
	 * @return
	 * 	returns true if the student if the course was successfully removed. Else, false.
	 */
	public boolean deleteCourse(int course_id)
	{
		boolean deleted = false;
		
		for(Course course : courseList)
		{
			if(course.getCourseId() == course_id)
			{
				deleted = courseList.remove(course);
				break;
			}
		}
		
		return deleted;
	}
	/**
	 * Calculates the total GPA of the student
	 * @return
	 */
	public double calculateGPA()
	{
		int total = 0;
		
		for(Course course : courseList)
		{
			switch(course.getGrade())
			{
				case "A":
					total += 4.00;
					break;
				case "A-":
					total += 3.70;
					break;
				case "B+":
					total += 3.33;
					break;
				case "B":
					total += 3.00;
					break;
				case "B-":
					total += 2.70;
					break;
				case "C+":
					total += 2.30;
					break;
				case "C":
					total += 2.00;
					break;
				case "C-":
					total += 1.70;
					break;
				case "D+":
					total += 1.30;
					break;
				case "D":
					total += 1.00;
					break;
				case "D-":
					total += 0.70;
			}
		}
		
		return (total/courseList.size());
	}
	
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		string.append("ID: " + techId);
		string.append("Name: " + name);
		
		for(Course course : courseList)
		{
			string.append("course: " + course);
			string.append("\n");
		}
		
		return string.toString();
	}
}
