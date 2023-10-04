package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class UpdateDemo {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter ID to Update");
		int sid=in.nextInt();
		System.out.println("Enter Avgmarks");
		double avg=in.nextDouble();
		String sql="update rocket set avgmarks=? where sid=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setDouble(1,avg);
			stmt.setDouble(2,sid);
			int rows=stmt.executeUpdate();
			if(rows>0)
				System.out.println(rows+" row(s) Successfully Updated");
			stmt.close();
			con.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}
}
