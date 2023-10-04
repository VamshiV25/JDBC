package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class Insert2 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Student Name,DOB and Avgmarks");
		String name=in.next();
		String dob=in.next();
		double avg=in.nextDouble();

		String sql="insert into student(sname,dob,avgmarks)"
				+ "Values ('"+name+"','"+dob+"',"+avg+")";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
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
