package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseData {

	public static void main(String[] args) throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cust","root","root"
				);
		Statement stat = conn.createStatement();
		String query = "select * from cust";
		ResultSet result = stat.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+ result.getString(3)+"\t"+ result.getString(4));
			
		}
		conn.close();
	}

}
