package Test;

import java.io.IOException;
import java.lang.reflect.Field;

import App_code.Course;
import App_code.ObjectSerializer;

public class ObjectSerializerTest {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Course course = new Course(0, "title Course", 10, "A");
		
		ObjectSerializer obj = new ObjectSerializer();
		try {
			obj.objectWrite(course, "testXMLFile");
			System.out.println("Saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Object classObject = obj.objectRead("testXMLFile");
			
			System.out.println("Name = " + classObject.getClass().getName());
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
