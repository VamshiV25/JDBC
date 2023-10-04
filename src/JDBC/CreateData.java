package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class CreateData {
	public static void main(String[] args) {
		String sql="create database if not exists testdb";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully Loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","2059");
			System.out.println("Connection opened...");
			Statement stmt=con.createStatement();
			System.out.println("Database Succefully Created");
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException exp) {
			System.out.println("Problem in Loading Driver");
		}
		catch(SQLException exp) {
			System.out.println("Caught : "+exp);
		}
	}
}
