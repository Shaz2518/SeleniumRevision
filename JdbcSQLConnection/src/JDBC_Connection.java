import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class JDBC_Connection {

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
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/loginpagePractise/");
			
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(password);
		}
		
		
			
		
		
		
		
		
	}

}
