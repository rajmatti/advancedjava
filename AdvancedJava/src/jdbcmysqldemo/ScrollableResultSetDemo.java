package jdbcmysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

// Java aprogram to demonstrate Scrollable Resultset
// Scrollable Resultset can move cursor in Forward, Backward & Random direction
public class ScrollableResultSetDemo {

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

			//step 3- create an statement object with 2 parameters 
			// Create scrollable Resultset
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery("select * from skills");
			
			System.out.println("******** Display records in Backward Direction ********");
			// reading from bottom to top
			rs.afterLast();
			while(rs.previous()) {
				System.out.println(rs.getInt(1)+" "+rs.getString("name"));
			}
			
			System.out.println("***********Random Fetch**************");
			// move the cursor to 3rd position
			rs.absolute(3);
			System.out.println(rs.getInt(1)+" "+rs.getString("name"));
			System.out.println("*************************************");
			
			// move the cursor to 2nd record using relative() method
			rs.relative(-1);  // rs.relative(5)
			System.out.println(rs.getInt(1)+" "+rs.getString("name"));
			System.out.println("*************************************");
			
			int i=rs.getRow(); // get the cursor position
			System.out.println("Cursor Position : "+i);
			
			//cleanup
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
