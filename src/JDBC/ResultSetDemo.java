package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class ResultSetDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost/mydb","root","2059");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from dept");
			displayResults(rs);
			stmt.close();
			con.close();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	} 
	public static void displayResults(ResultSet rs)throws Exception{
		ResultSetMetaData rsmd=rs.getMetaData();
		int cols=rsmd.getColumnCount();
		//print column heading
		for(int i=1;i<cols;i++) {
			if(i<cols)
				System.out.print(rsmd.getColumnName(i)+"\t");
			else
				System.out.println(rsmd.getColumnClassName(i));
		}
		//Print Column Data
		while(rs.next()){
			for(int i=1;i<=cols;i++) {
				if(i<cols)
					System.out.print(rs.getString(i)+"\t");
				else
					System.out.println(rs.getString(i));
			}
		}
	}
}
