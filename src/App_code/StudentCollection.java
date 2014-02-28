package App_code;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Keeps a collection of students
 * 
 * @author Group 3
 * 
 */
public class StudentCollection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8018529335748388453L;
	// list of students in the college
	private ArrayList<Student> studentList;
	private ObjectSerializer xmlWriter;
	/**
	 * Default constructor
	 */
	public StudentCollection() 
	{
		studentList = new ArrayList<Student>();
		xmlWriter = new ObjectSerializer();
	}
	/**
	 * Overloaded Constructor
	 * @param a_file_name name of the XML file
	 * @throws IOException 
	 * @throws ClassNotFoundException
	 */
	public StudentCollection(String a_file_name) throws IOException, ClassNotFoundException
	{
		// need to read through an xml file here
		Object obj = xmlWriter.objectRead(a_file_name);
		
		System.out.println(obj.getClass().toString());
	}
	/**
	 * removes a student
	 * @param techId unique identifier of the student
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
	
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		
		for(Student student : studentList)
		{
			string.append(student);
		}
		
		return string.toString();
	}
}
