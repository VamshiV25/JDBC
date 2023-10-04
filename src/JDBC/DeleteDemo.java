package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.Scanner;
public class DeleteDemo {
	public static void main(String[] args) {
		String sql="Delete from student where avgmarks<?";
		Scanner in=new Scanner(System.in);
		System.out.println("Enter avgmarks criteria to delete");
		double avg=in.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDouble(1,avg);
			int rows=stmt.executeUpdate();
			if(rows>0)
				System.out.println(rows+"row(s) deleted");
			stmt.close();
			con.close();
		}
		catch(Exception exp) {
			System.out.println("Caught : "+exp);
		}
	}
}
