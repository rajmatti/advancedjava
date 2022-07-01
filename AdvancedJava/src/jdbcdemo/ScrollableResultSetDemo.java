package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableResultSetDemo {

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
		
		//step 3- Create statement Object with scrollable resultset
		Statement stmt=con.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//step4- Execute Query & store records in result set
		ResultSet rs=stmt.executeQuery("select * from departments");

		//Step5 - Traversing in ResultSet & display records
		 // read from bottom to top
		rs.afterLast();
		while(rs.previous())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
					rs.getInt(3)+" "+rs.getInt(4));
		}
		System.out.println("*************************************");
		
		// move the cursor to 10th record
		rs.absolute(10);
		
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
				rs.getInt(3)+" "+rs.getInt(4));
		
		System.out.println("*************************************");
		
		// move the cursor to 5th record using relative
		rs.relative(-5);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
				rs.getInt(3)+" "+rs.getInt(4));
		
		System.out.println("*************************************");
		
		// move to the last record
		rs.last();
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
				rs.getInt(3)+" "+rs.getInt(4));
		
		System.out.println("*************************************");
		int i=rs.getRow();
		System.out.println("Cursor Position : "+i);
		}
		
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
