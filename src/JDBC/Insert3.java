package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Date;
import java.util.Scanner;
public class Insert3 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter name,dob and avgmarks");
		String name=in.next();
		String dob=in.next();
		double avg=in.nextDouble();
		Date mydate=new Date(0000-00-00);
		String sql="Insert into student(sname,dob,avgmarks)values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,name);
			stmt.setDate(2,mydate.valueOf(dob));
			stmt.setDouble(3,avg);
			int rows=stmt.executeUpdate();
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
