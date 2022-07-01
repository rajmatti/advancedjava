package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinDemo {

	public static void main(String[] args) {
		try
		{
			//step 1- Load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step 2- Create Connection Object
			//Oracle service name -- Standard edition - orcl
			//                        Express  edition -xe
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			
			//step 3- Create statement Object
			Statement stmt=con.createStatement();
			
			//step4- Execute Query & store records in result set
			
			String qry="select e.employee_id,e.first_name,e.email,e.manager_id,d.department_name"
			+ " from employees e inner join departments d on e.department_id=d.department_id";
			
			ResultSet rs=stmt.executeQuery(qry);
			
			//Step5 - Traversing in ResultSet & display records
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
			rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			
			//step6- Close the connection
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
