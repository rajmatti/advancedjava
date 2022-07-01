package jdbcdemo;

import java.sql.*;
public class CallableDemo {
	
	Connection con;
	CallableStatement cstmt;
	ResultSet rs;
	
	public CallableDemo() {
		con=null;
	}
	
	public void getConnection()
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
		
	}



	public static void main(String[] args) {
		

	}

}
