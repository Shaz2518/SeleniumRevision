package miscelleneousTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("John");	
		driver.findElement(By.id("alertbtn")).click();
		
		String accepMsg = driver.switchTo().alert().getText();
		System.out.println(accepMsg);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("name")).sendKeys("John");	
		driver.findElement(By.id("confirmbtn")).click();
		String declineMessage = driver.switchTo().alert().getText();
		System.out.println(declineMessage);
		driver.switchTo().alert().dismiss();
	}

}
