package jdbcmysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// JDBC Program to delete an Candidate
public class DeleteDemo {
	
	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		int cnt=0;
		Scanner scan;
		
		// db parameters
		String url       = "jdbc:mysql://localhost:3306/mysqljdbc";
		String user      = "root";
		String password  = "redhat";

		try {
			//step 1- Load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2- Create a connection object and connect to database mysqljdbc
			con = DriverManager.getConnection(url,user,password);
			
			scan=new Scanner(System.in);
			System.out.println("Enter LastName of the Candidate to be Deleted: ");
			String lname=scan.next();
			
			String delQry="delete from candidates where last_name like \'"+lname+"\'";
			
			stmt=con.createStatement();
			cnt=stmt.executeUpdate(delQry);
			
			if(cnt>0) {
				System.out.println("Records Deleted :"+cnt);
			}
			else {
				System.out.println("Record Not Found");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
