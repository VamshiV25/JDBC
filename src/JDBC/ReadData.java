package JDBC;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class ReadData {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
		Statement stmt=con.createStatement();
		String sql="select*from rocket";
		ResultSet rs=stmt.executeQuery("select*from rocket");
		System.out.println("Student Details");
		System.out.println("SID\tSname\tDOB\tAvgmarks");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"
					+rs.getString(3)+"\t"+rs.getString(4));
		}
		stmt.close();
		con.close();
	}
}
