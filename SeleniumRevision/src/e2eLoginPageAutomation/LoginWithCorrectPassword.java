package e2eLoginPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithCorrectPassword {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/localadminuser/Desktop/SeleniumPractice/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		String name = "John";
		String password = getPassword(driver);
		
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
		
		//Enter name Email Phone and Click login
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		driver.findElement(By.cssSelector(".signInBtn")).click();
		
		//Get Login Message and compare the desire output
		Thread.sleep(1000);
			
		String usernameString = driver.findElement(By.xpath("//div/h2")).getText();
		String username =usernameString.split(" ")[1].split(",")[0];
		System.out.println(username);
		if(username.equalsIgnoreCase(name))
		{
			System.out.println("Correct username");
		}
		else System.out.println("Error");
//		
		String text = "You are successfully logged in.";
		String loginText = driver.findElement(By.tagName("p")).getText();
		if(text == loginText)
		{
			System.out.println("Congratulation, " + username);
		}
		else System.out.println("Login failed");

	}
	
	public static String getPassword(WebDriver driver)
	{
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String passwordString = driver.findElement(By.cssSelector(".infoMsg")).getText();
		
		String[] passwordTrim = passwordString.split("'");
		String finalPassword = passwordTrim[1].split("'")[0];
		return finalPassword;
		
		
		
	}

}
