package App_code;
/*
 *   Class: ObjectSerializer
 *   Author: Siva Jasthi
 */

/**
 *  ObjectSerializer provides the utility methods
 *    - to encode an object as XML file
 *    - to decode the object from XML file
 *    - to write an object as binary file
 *    - to read an object from the binary file
 *    - to write a string to a text file
 *    - to read a string from a text file
 *
 *  See the html link for more information about the java classes used
 *
 *
 *  Note on XML Encoding:
 *       [1] The class should be public
 *       [2] The class should implement the interface "Serializable"
 *       [2] There should be default constructor
 *       [3] The default constructor should be explictly declared public
 *       [4] All the private and public instance variables should have
 *               explicit set and get methods with proper naming conventions.
 *       [5] Only objects can be persisted; and XMLEncoder uses a process
 *           called "Introspection" to see more details about the object.
 *
 *  Note on Object Encoding:
 *       [1] The class should implement the interface "Serializable"
 *
 */

import java.io.*;
import java.beans.*;
import java.util.*;

public class ObjectSerializer
{
	    /**
	     * For storing an object as XML in a file
	     * For more information, see
	     *   http://java.sun.com/j2se/1.4.2/docs/api/java/beans/XMLEncoder.html
	     **/
	   public static void xmlEncode(Object an_object, String file_name)
	        throws IOException
	   {
          FileOutputStream fos = new FileOutputStream(file_name);
	      XMLEncoder encoder = new XMLEncoder(
		                                 new BufferedOutputStream(fos));
		  encoder.writeObject(an_object);
          encoder.close();
	   }

       /**
	     * For reading an object from a file that contains XML data
	     * For more information, see
		 *   http://java.sun.com/j2se/1.4.2/docs/api/java/beans/XMLDecoder.html
	     **/
	   public static Object xmlDecode(String file_name)
	        throws IOException
	   {
          FileInputStream fis = new FileInputStream(file_name);
	      XMLDecoder decoder = new XMLDecoder(
		                            new BufferedInputStream(fis));
		  Object an_object = decoder.readObject();
          decoder.close();
          return an_object;
	   }


       /**
	     * For storing an object in binary format in a file
	     * For more information, see
	     * http://java.sun.com/j2se/1.4.2/docs/api/java/io/ObjectOutputStream.html
	     **/
	   public static void objectWrite(Object an_object, String file_name)
	        throws IOException
	   {

	      FileOutputStream fos = new FileOutputStream(file_name);
		  ObjectOutputStream oos = new ObjectOutputStream(fos);
		  oos.writeObject(an_object);
		  oos.close();
	   }


	  /**
	   * For reading an object from a file that contains binary data
	   * For more information, see
	   *   http://java.sun.com/j2se/1.4.2/docs/api/java/io/ObjectInputStream.html
	   **/
	   public static Object objectRead(String file_name)
	        throws IOException, ClassNotFoundException
	   {

   	      FileInputStream fis = new FileInputStream(file_name);
		  ObjectInputStream ois = new ObjectInputStream(fis);
		  Object an_object = ois.readObject();
	      ois.close();
          return an_object;
	   }


	   /**
	    * For writing text to a file
	    * One can write the string representation of an object to the file
	    * The string representation can be a comma separated list reflecting the object state
	    */
		static public void textWrite(String a_string, String a_file_name)
		       throws IOException
		{

			// 1. get the file handle from the file name
			 FileWriter output_file_writer = new FileWriter(a_file_name);
			 // 2. get the Print Writer handle
			 PrintWriter output_writer = new PrintWriter(output_file_writer);
			//4. Write something to the file
			 output_writer.println(a_string);
			// 5. finally, close the opened file
			 output_writer.close();
       }

       /**
	     * For writing text to a file
	     * One can write the string representation of an object to the file
	     * The string representation can be a comma separated list reflecting the object state
	     */
		static public String textRead(String a_file_name)
			   throws FileNotFoundException, IOException
		{
			 // for holding the string read from the file
			 StringBuffer contents = new StringBuffer();

			 // for holding the reader; to make visible to finally clause
			 BufferedReader input_reader = null;
			 try
			 {
			     // 1. get the file handle
			     FileReader input_file_reader = new FileReader(a_file_name);
			 	 // 2. get the buffered reader handle
			     input_reader = new BufferedReader(input_file_reader);

			     String line = null;

			     // keep on reading each line in the file until you read null
			     // i.e until you reach the end of the file
			     while (( line = input_reader.readLine()) != null)
			     {
			         contents.append(line);
			         contents.append(System.getProperty("line.separator"));
			     }
			 } // end try

			 catch (FileNotFoundException ex)
			 {
			       ex.printStackTrace();
			 }
			 catch (IOException ex)
			 {
			       ex.printStackTrace();
			 }
			 finally
			 {
			      try
			      {
			         if (input_reader!= null)
 			           input_reader.close();
			       }
			       catch (IOException ex)
			       {
			         ex.printStackTrace();
			       }
			 }
             return contents.toString();
        }

}
