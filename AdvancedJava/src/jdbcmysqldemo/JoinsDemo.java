package jdbcmysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC program to display candidate details & their skills 
//from different tables
public class JoinsDemo {
	
	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		

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
			
			String joinQry="select c.id, first_name, name from candidates c INNER JOIN"
					+ " candidate_skills s on c.id=s.candidate_id INNER JOIN"
					+ " skills sk on s.skill_id=sk.id";
			
			rs=stmt.executeQuery(joinQry);
			System.out.println("Id"+"\t"+"Name"+"\t"+"Skills");
			System.out.println("--------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
