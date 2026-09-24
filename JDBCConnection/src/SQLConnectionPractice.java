import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectionPractice {

	public static void main(String[] args) throws SQLException {
		String userName;
		String password;
		
		Connection connect = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/CreditCard",
			    "root",
			    "rootuser123"
			);
		Statement state = connect.createStatement();
		ResultSet result = state.executeQuery("select * from userInfo where cardType = 'AmericanExpress'");
		
		while(result.next())
		{
			 userName = result.getString("userName");
			 password= result.getString("userPass");
			System.out.println("Username: " + userName + "  " + "Password: " + password);
		}

	}

}
