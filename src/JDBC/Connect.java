package JDBC;
import java.sql.*;
public class Connect {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully Loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","2059");
			System.out.println("Connection now opened...");
			con.close();
			System.out.println("Connection now closed...");
		}
		catch(ClassNotFoundException exp) {
			System.out.println("Problem in Loading Driver");
		}
		catch(SQLException exp) {
			System.out.println("Problem in opening connection");
		}
	}
}
