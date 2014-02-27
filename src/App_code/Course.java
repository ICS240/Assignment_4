package App_code;

public class Course {
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

	public void addStudent(Student a_student)
	{
		
	}

	public boolean deleteStudent(Student a_student)
	{
		
	}

	public boolean deleteStudent(int a_tech_id)
	{
		
	}

	public boolean writeToFile()
	{
		
	}

	public StudentCollection readFromFile()
	{
		
	}
}
