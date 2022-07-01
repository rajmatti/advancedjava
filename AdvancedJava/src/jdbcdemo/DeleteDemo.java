package jdbcdemo;

import java.sql.*;
public class DeleteDemo {

	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		int cnt=0;
		
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			
			stmt=con.createStatement();
			
			cnt=stmt.executeUpdate("delete from departments where department_id=420");
			if(cnt>0)
			{
				System.out.println("Records Deleted: "+cnt);
			}
			else
			{
				System.out.println("Record Not Found");
			}
			con.close();
}
catch(Exception e)
{
	System.out.println(e);
}
		
		

	}

}
