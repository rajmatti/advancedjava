package jdbcmysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// JDBC program to demonstrate PreparedStatement
// Update LastName of the Candidate
public class UpdateDemo {
	
	public static void main(String[] args) {
		
		Connection con;
		PreparedStatement pstmt; // Accepts value at runtime - pre compiled statements
		int cnt=0;
		Scanner scan;
		String qryUpdate;
		ResultSet rs;
		int eid;
		
		// db parameters
		String url       = "jdbc:mysql://localhost:3306/mysqljdbc";
		String user      = "root";
		String password  = "redhat";

		try {
			//step 1- Load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2- Create a connection object and connect to database mysqljdbc
			con = DriverManager.getConnection(url,user,password);
			
			//Query with replacement operator ?
			qryUpdate="UPDATE candidates SET last_name=? WHERE id=?";
			
			pstmt=con.prepareStatement(qryUpdate);
			
			//prepare data for Update
			scan=new Scanner(System.in);
			System.out.println("Enter Employeed Id :");
			eid=scan.nextInt();
			System.out.println("Enter Employee's New last Name :");
			String lname=scan.next();
			
			//passing values to PreparedStatement using Setter Methods
			pstmt.setString(1,lname);
			pstmt.setInt(2,eid);
			
			int rowAffected=pstmt.executeUpdate();
			System.out.println(String.format("Row Updated: %d", rowAffected));
			
			// reuse the PreparedStatement
			lname = "Bush";
            int eid1 = 20;
            pstmt.setString(1, lname);
            pstmt.setInt(2, eid1);
 
            rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
            System.out.println("*********** Display Updated Data*********");
            
            pstmt=con.prepareStatement
            		("select id,first_name,last_name from candidates where id in(?,?)");
          
            pstmt.setInt(1, eid);
            pstmt.setInt(2, 20);
            
            rs=pstmt.executeQuery();
            while(rs.next())
            {
            	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
            }
            con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
