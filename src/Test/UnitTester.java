package Test;

import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;

import App_code.Course;
import App_code.ObjectSerializer;
import App_code.Student;
import App_code.StudentCollection;

public class UnitTester {

	private static StudentCollection student = new StudentCollection();
	private static ObjectSerializer obj = new ObjectSerializer();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMethod3();
	}
	/**
	 * Adds a list of students and then prints them out
	 */
	public static void TestMethod()
	{
		for(int i = 0; i < 50; i++)
		{
			if(!student.addStudent("Student_" + i, i))
			{
				System.out.println("Error trying to add Student_" + i);
			}
		}
		
		//System.out.println(student);
	}
	/**
	 * Adds a list of courses to a list of students
	 * @precondition
	 * 	TestMethod() must be called first
	 */
	public static void TestMethod2()
	{
		for(int i = 0; i < 50; i++)
		{
			if(student.addStudent(new Student("Student_" + i, i)))
			{
				for(int j = 0; j < 30; j++)
				{
					student.getStudent(i).addCourse(new Course(j, ("course_" + j), j, "A"));
				}
			}
			else
			{
				System.out.println("Error trying to add Student_" + i);
			}
		}
		
		System.out.println(student);
	}
	/**
	 * Tests the ObjectSerializer for students
	 */
	public static void TestMethod3()
	{
		for(int i = 0; i < 50; i++)
		{
			if(student.addStudent(new Student("Student_" + i, i)))
			{
				for(int j = 0; j < 30; j++)
				{
					student.getStudent(i).addCourse(new Course(j, ("course_" + j), j, "A"));
				}
			}
			else
			{
				System.out.println("Error trying to add Student_" + i);
			}
		}
		for(int i = 0; i < 50; i++)
		{
			try
			{
				obj.objectWrite(student.getStudent(i), student.getStudent(i).getName());
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
		
		StudentCollection collection = new StudentCollection();
		
		for(int i = 0; i < 50; i++)
		{
			try
			{
				collection.addStudent((Student)obj.objectRead(("student_" + i)));
			}
			catch(IOException | ClassNotFoundException ex)
			{
				ex.printStackTrace();
			}
		}
		
		System.out.println(collection);
	}
}
