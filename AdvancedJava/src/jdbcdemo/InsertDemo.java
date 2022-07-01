package jdbcdemo;

import java.sql.*;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			
			stmt=con.createStatement();
			
			String insertQry="insert into departments(department_id,department_name,manager_id,location_id)"
					+ " values(440,'Skill Upgradation',121,1500)";
			
			int rowcnt=stmt.executeUpdate(insertQry); // executeUpdate() is used for DML ops
			
			if(rowcnt>0)
			{
				System.out.println("Record Inserted Successfully");
			}
			
			// counting total no. of records in table
			String str1 = "select count(department_id) from departments";
			rs=stmt.executeQuery(str1)  ; 
			while(rs.next())
			{
				cnt=rs.getInt(1);}
			System.out.println("Total no. of records is: "+cnt);
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
