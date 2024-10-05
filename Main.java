package RealEstate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class GetConnection
{
	Connection con;
	GetConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/realestate";
		String userName = "root";
		String password = "ponnu0123";
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(url, userName, password);

	}
}

public class Main extends Thread{

	public static void main(String[] args) throws InterruptedException {
		
		new RealEstatePortal();
		

	}

}