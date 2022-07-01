package fileiodemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//Program to create a text based file
public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		Writer w=new FileWriter("d:/javatest/data.txt");
		try
		{
			//w=new FileWriter("d:/javatest/data.txt");
			//String content="She Sells Sea Shells In the Sea.";
			String content="Java Programming Guide by James Gosling";
			
			w.write(content); // write contents into file
			
			
			System.out.println("Character Data Written to File");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			w.close();
		}

	}

}
