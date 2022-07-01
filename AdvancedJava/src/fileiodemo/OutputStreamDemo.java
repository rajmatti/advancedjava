package fileiodemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Java program to demonstrate DataOutputStream
//This program uses try-with-resources. It requires JDK 7 or later.
public class OutputStreamDemo {

	public static void main(String[] args) throws IOException  {
		//writing data using output stream
		try( DataOutputStream dout=new DataOutputStream
				(new FileOutputStream("d:/javatest/data1.txt")))
				{
					dout.writeDouble(5000.50);
					dout.writeInt(345);
					dout.writeBoolean(true);
					dout.writeChar('B');
				}
		catch(FileNotFoundException ex)
		{
			System.out.println("Cannot open output file"+ex);
		}
		
		// reading data back using input stream
		try( DataInputStream din=new DataInputStream
				(new FileInputStream("d:/javatest/data1.txt")))
		{
			double a=din.readDouble();
			int b=din.readInt();
			boolean c=din.readBoolean();
			char d=din.readChar();
			
			System.out.println("Values : "+a+" "+b+" "+c+" "+d);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Cannot Open Input File"+ex);
		}
	}

}
