package jdbcmysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// JDBC Program to Insert Records into Table
public class InsertDemo {

	public static void main(String[] args) {

		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;

		// db parameters
		String url       = "jdbc:mysql://localhost:3306/mysqljdbc";
		String user      = "root";
		String password  = "redhat";

		try {
			//step 1- Load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2- Create a connection object and connect to database mysqljdbc
			con = DriverManager.getConnection(url,user,password);

			//step 3- create an statement object
			stmt = con.createStatement();

			String insertQry="insert into skills(name) values('Google Cloud')";

			//executeUpdate() method is used for DML operations - insert, update, delete
			cnt=stmt.executeUpdate(insertQry);

			if(cnt>0)
			{
				System.out.println("Record Inserted Successfully");
			}

			rs=stmt.executeQuery("select * from skills");

			System.out.println("******** Display Skills Table ********");

			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString("name"));
			}

			System.out.println("----------------------------------------");
			//count total no. of records in table
			String a="select count(id) from skills";

			rs=stmt.executeQuery(a);

			// Traverse in Resultset
			while(rs.next())
			{
				cnt=rs.getInt(1);
			}
			System.out.println("Total No. of Records is : "+cnt);

			con.close();
		}

		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
