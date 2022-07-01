package jdbcmysqldemo;
// JDBC program to demonstrate CallableStatement
// Callable statement is used to call  Stored Procedures and functions.

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class CallableDemo {
	
	Connection con;
	CallableStatement cstmt;
	ResultSet rs;
	
	String url;
	String user ;
	String password ;
	
	CallableDemo()
	{
		// db parameters
		url       = "jdbc:mysql://localhost:3306/mysqljdbc";
		user      = "root";
		password  = "redhat";
	}
	
	void createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);

		}catch(Exception e) { e.printStackTrace();}
	}
	
	public void getSkills(int candidateId) {
		try {
			String query="{ call get_candidate_skill(?) }";
			
			// CallableStatement calling StoredProcedure
			cstmt=con.prepareCall(query); 
			cstmt.setInt(1, candidateId);
			
			rs=cstmt.executeQuery();
			  while (rs.next()) {
		             System.out.println(String.format("%s - %s",
		                     rs.getString("first_name") + " "
		                     + rs.getString("last_name"),
		                     rs.getString("skill")));
			}
			  con.close();
		}catch(Exception e) { e.printStackTrace();}
	}

	public static void main(String[] args) {
		
		CallableDemo cd1=new CallableDemo();
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Candidate Id to display Skills :");
		int cid=scan.nextInt();
		scan.close();
		
		cd1.createConnection();
		cd1.getSkills(cid);
		
		

	}

}
