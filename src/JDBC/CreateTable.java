package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
	public static void main(String[] args) {
		String sql="Create table STUDENT\r\n (sid integer primary key auto_increment,\r\n"
				+ "sname varchar(25)not null,dob date,avgmarks float)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully Loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
			Statement stmt=con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Table Succefully Created");
			stmt.close();
			con.close();
		}
		catch(Exception exp) {
			System.out.println("Caught : "+exp);
		}
	}
}
