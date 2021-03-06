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
	private static final long serialVersionUID = 1L;
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
	public boolean removeStudent(Student a_student)
	{
		boolean removed = false;
		
		for(Student student : studentList)
		{
			if(student == a_student){
				studentList.remove(student);
				removed = true;
				break;
			}
		}
		
		return removed;
	}
	/**
	 * adds a student to the student list
	 * @param a_student student object
	 */
	public boolean addStudent(Student a_student)
	{
		return studentList.add(a_student);
	}
	/**
	 * adds a student to the student list
	 * @param studentName name of the student
	 * @parm id unique identifier of the student
	 */
	public boolean addStudent(String studentName, int id)
	{
		return studentList.add(new Student(studentName, id));
	}
	/**
	 * Returns a Student object
	 * @param id unique identifier of the student
	 * @return
	 * 	The student by id, else null if no student is found
	 */
	public Student getStudent(int id)
	{
		for(Student in : studentList)
		{
			if(in.getTechId() == id)
			{
				return in;
			}
		}
		
		return null;
	}
	/**
	 * Returns a Student object
	 * @param studentName name of the student
	 * @return
	 * 	The student by id, else null if no student is found
	 */
	public Student getStudent(String studentName)
	{
		for(Student in : studentList)
		{
			if(in.getName().toUpperCase().equals(studentName.toUpperCase()))
			{
				return in;
			}
		}
		
		return null;
	}
	/**
	 * Writes a StudentCollection Serialized Object to a File
	 * @param a_file_name name of the file to save the student in
	 * @return
	 * 	<b>true</b> if the StudentCollection Object was successfully written,
	 * <b>false</b> if there was an error. 
	 * @throws IOException
	 * 	Throws this error when there is no permissions, or the <i>iostream</i> could not be
	 * 	generated. 
	 */
	public boolean writeToFile(String a_file_name) throws IOException
	{
		boolean written = false;
		try{
			ObjectSerializer.objectWrite(this, a_file_name);
			written = true;
		}
		catch(IOException ioe)
		{
			throw new IOException();
		}
		return written;
	}
	/**
	 * Reads a StudentCollection Object from a file
	 * @param a_file_name name of the file to be read from
	 * @return
	 * 		The generated StudentCollection Object from the file
	 * @throws ClassNotFoundException
	 * 		The file does not contain a StudentCollection Object, Typically a casting error
	 * @throws IOException
	 * 		Throws this error when there is no permissions, or the <i>iostream</i> could not be
	 * 		generated. 
	 */
	public StudentCollection readFromFile(String a_file_name) throws ClassNotFoundException, IOException
	{
		Object collection = (StudentCollection) xmlWriter.objectRead(a_file_name);
		return (StudentCollection) collection;
	}
	
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		
		for(Student in : studentList)
		{
			string.append(in.getName() + "\n");
		}
		
		return string.toString();
	}
}
