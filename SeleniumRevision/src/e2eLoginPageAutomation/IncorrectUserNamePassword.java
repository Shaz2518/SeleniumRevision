package e2eLoginPageAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncorrectUserNamePassword {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/localadminuser/Desktop/SeleniumPractice/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Enter username and password and submit
		driver.findElement(By.id("inputUsername")).sendKeys("John");
		driver.findElement(By.name("inputPassword")).sendKeys("john@123");
		driver.findElement(By.className("signInBtn")).click();
		
		//Grab the incorrect password text
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String errorText = driver.findElement(By.className("error")).getText();
		System.out.println(errorText);
		
		driver.quit();
	}

}
