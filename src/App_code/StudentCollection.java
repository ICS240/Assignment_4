package App_code;

import java.util.ArrayList;

public class StudentCollection {
	// list of students in the college
	private ArrayList<Student> studentList;
	/**
	 * Default constructor
	 */
	public StudentCollection()
	{
		studentList = new ArrayList<Student>();
	}
	/**
	 * Overloaded Constructor
	 * @param a_file_name name of the XML file
	 */
	public StudentCollection(String a_file_name)
	{
		// need to read through an xml file here
	}
	/**
	 * removes a student
	 * @param techId unique identifier of the studnet
	 * @returns
	 * 	true if the student was successfully removed
	 */
	public boolean removeStudent(int techId)
	{
		boolean removed = false;
		
		for(Student student : studentList)
		{
			if(student.getTechId() == techId)
			{
				removed = studentList.remove(student);
				break;
			}
		}
		
		return removed;
	}
	/**
	 * removes a student
	 * @param studentName name of the student to be removed
	 * @returns
	 * 	true if the student was successfully removed
	 */
	public boolean removeStudent(String studentName)
	{
		boolean removed = false;
		
		for(Student student : studentList)
		{
			if(student.getName().equals(studentName))
			{
				removed = studentList.remove(student);
				break;
			}
		}
		
		return removed;
	}
}
