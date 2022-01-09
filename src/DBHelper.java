import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private  String userName="root";
	private  String userPassword="Cocomix_gok1";
	private  String dataBase="world";
	private  String myDbUrl="jdbc:mysql://127.0.0.1:3306/"+dataBase+"?useSSL=false";
	
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(myDbUrl,userName,userPassword);
		
	}
	
	public void showErrorMessage(SQLException exception) {
		
		System.out.println("Error message: "+exception.getMessage());
		System.out.println("Error code :"+exception.getErrorCode());
	}
}
