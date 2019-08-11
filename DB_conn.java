import java.sql.Connection;
import java.sql.DriverManager;

public class DB_conn {
	
	public static Connection getConnection() 
			  throws Exception
			  {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection  conn = DriverManager.getConnection(
						  "jdbc:mysql://localhost:3306/pbl",
						  "root",
						  "123");
				
				
				return conn; 
			  }

}
