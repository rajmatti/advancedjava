package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Set of dml statements is called Transaction.. 
// Transaction is successful only if all dml statements execute successfully

public class TransactionDemo {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement stmt;
		int cnt=0;	
try {	
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			System.out.println("Database Connection Successfull");
			
			stmt=con.createStatement();
			// By default oracle has auto commit set to true
			con.setAutoCommit(false);
			
			String iqry="insert into departments(department_id,department_name,manager_id,location_id)"
					+ " values(450,'Skill Upgradation1000',121,1500)";
			
			String uqry="UPDATE EMPLOYEES SET LAST_NAME='Milne' WHERE EMPLOYEE_ID=101";
			
			String dqry="delete from departments where departmen_id=420";
			
			int cnt1=stmt.executeUpdate(iqry);
			int cnt2=stmt.executeUpdate(uqry);
			int cnt3=stmt.executeUpdate(dqry);
			
			con.commit(); //commit the transaction
			System.out.println("Transaction Sucessfull");
	}

catch(Exception e)
{
	try
		{
		con.rollback();
		System.out.println("Trasaction is failed");
		}
		catch (Exception ex)
		{
		System.out.println(ex);
		}
}
con.close();
}}
