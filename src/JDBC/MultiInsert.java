package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Date;
public class MultiInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/mydb","root","2059");
			String sql="Insert into Student(sname,dob,avgmarks) values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			Scanner in=new Scanner(System.in);
			Date mydate=new Date(0000-00-00);
			boolean flag=true;
			while(flag) {
				System.out.println("Enter Student Name,Dob and Avgmarks");
				String name=in.next();
				String dob=in.next();
				double avg=in.nextDouble();
				pstmt.setString(1,name);
				pstmt.setDate(2,mydate.valueOf(dob));
				pstmt.setDouble(3,avg);
				pstmt.addBatch(sql);
				int rows=pstmt.executeUpdate();
				System.out.println(rows+"rows successfully inserted");
				System.out.println("Want to add another record Y/N : ");
				char another=in.next().charAt(0);
				if(another=='N' || another=='n')
					flag=false;
			}
			pstmt.close();
			con.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}
}
