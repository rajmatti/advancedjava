package fileiodemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeSerialiseDemo {

	public static void main(String[] args) {
		
		Employee e2=null;
		
		try
		{
			FileInputStream fin=new FileInputStream("d:/javatest/employee.ser");
			ObjectInputStream in=new ObjectInputStream(fin);
			
			e2=(Employee)in.readObject();// deserialising Object employee
			
			in.close();
			fin.close();
			
		}
	catch(Exception e)	
		{
		System.out.println("Employee Not found");
			e.printStackTrace();
		}
		
		System.out.println("******** Deserialised Employee ***************");
		System.out.println("Employee Id :"+e2.number);
		System.out.println("Employee Name :"+e2.name);
		System.out.println("Employee Address :"+e2.address);
		System.out.println("Employee SSN :"+e2.SSN);
	}

}
