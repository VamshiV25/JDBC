package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Insert1 {
	public static void main(String[] args) {
		String sql="Insert into student values(9001,'SMITH','2000-12-17',85.98)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
			Statement stmt=con.createStatement();
			int rows=stmt.executeUpdate(sql);
			if(rows>0)
			System.out.println(rows+" row(s) inserted");
			stmt.close();
			con.close();
		}
		catch(Exception exp) {
			System.out.println("Caught : "+exp);
		}
	}

}
