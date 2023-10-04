package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class BatchDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost/mydb","root","2059");
			Statement stmt=con.createStatement();
			stmt.addBatch("update emp set sal=sal+500 where empno=7844");
			stmt.addBatch("insert into dept values(50,'ADMIN','MUMBAI'");
			int[] results=stmt.executeBatch();
			for(int i=0;i<results.length;i++) {
				System.out.println(results[i]);
			}
			stmt.close();
			con.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}
}
