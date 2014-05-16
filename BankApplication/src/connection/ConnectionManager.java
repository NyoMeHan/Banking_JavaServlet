package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {	

	private static Connection connection = null;

	public static Connection getConnection(){	
		if(connection == null){	
			try{
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team4b_banking","root","password");					
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return connection;
	}//getConnection()
	
	
	public static void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//closeConnection()
}
