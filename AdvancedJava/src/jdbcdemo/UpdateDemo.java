package jdbcdemo;

import java.sql.*;
import java.util.Scanner;

class Employee
{
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet res;
	String sqlUpdate;
	
	public Employee() {
		con=null;
	}
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return con;
	}
	
	public void UpdateEmployee()
	{
		System.out.println("************** Update Employees **************");
		try
		{
			con=getConnection();
			sqlUpdate="UPDATE EMPLOYEES SET LAST_NAME=? WHERE EMPLOYEE_ID=?";
			
			ps=con.prepareStatement(sqlUpdate);
			
			 // prepare data for update
			 Scanner s=new Scanner(System.in);
			 System.out.println("enter Employee id:");
			 int eid=s.nextInt();
			 System.out.println("enter employee's new last name :");
			 String lastname=s.next();
			 
			 // passing values to prepared statement using setter methods.
			 ps.setString(1, lastname);
			 ps.setInt(2, eid);
			 
			 int count=ps.executeUpdate();
			 System.out.println(String.format("Row affected : %d", count));
			 
			  // reuse the prepared statement
	            lastname = "Bush";
	            eid = 101;
	            ps.setString(1, lastname);
	            ps.setInt(2, eid);
	 
	            count = ps.executeUpdate();
	            System.out.println(String.format("Row affected %d", count));
			 
		con.close();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
public class UpdateDemo {

	public static void main(String[] args) {
		
		Employee e1=new Employee();
		e1.UpdateEmployee();
		

	}

}
