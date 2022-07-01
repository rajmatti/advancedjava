package jdbcmysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {

		// db parameters
		String url       = "jdbc:mysql://localhost:3306/mysqljdbc";
		String user      = "root";
		String password  = "redhat";

		try {
			//step 1- Load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2- Create a connection object and connect to database mysqljdbc
			Connection con = DriverManager.getConnection(url,user,password);

			//step 3- create an statement object
			Statement stmt = con.createStatement();

			// Execute Query & store records in result set
			// ResultSet is a virtual table
			// By Default ResultSet is Non-SCrollable
			ResultSet rs = stmt.executeQuery("select * from candidates");

			//Step5 - Traversing in ResultSet & display records
			while(rs.next())
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)
				+"\t"+rs.getDate(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));

			//step 6- close the connection
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);

		}

	}

}
