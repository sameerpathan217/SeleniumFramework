package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataNonselectquery {

	public static void main(String[] args) throws Throwable {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cust","root","root");
		
		Statement stat = conn.createStatement();
		String query = "insert into cust (first,last,address)values('sam','pathan','kallam')";
		int result = stat.executeUpdate(query);
		
		if(result==1) {
			System.out.println("Table Created");
		}else {
			System.out.println("Not Created");
		}
		conn.close();

	}

}
