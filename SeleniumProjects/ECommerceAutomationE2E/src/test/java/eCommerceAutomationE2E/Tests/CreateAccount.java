package eCommerceAutomationE2E.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) {
		
		//Invoke Chrome Browser and Navigate to Website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
		//Create Account.
		driver.findElement(By.xpath("//a[@class='btn1']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Tanjiro");
		driver.findElement(By.id("lastName")).sendKeys("Kamado");
		driver.findElement(By.id("userEmail")).sendKeys("demonslayer@gmail.com");
		driver.findElement(By.id("userMobile")).sendKeys("1234455667");
		
		WebElement dropdown = driver.findElement(By.cssSelector(".custom-select"));
		Select dp = new Select(dropdown);
		dp.selectByVisibleText("Student");
		
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		
		String password = "DemonSlayer123";
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("login")).click();
		
		
		
		
	}

}
