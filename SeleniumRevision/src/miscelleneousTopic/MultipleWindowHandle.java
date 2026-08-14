package miscelleneousTopic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		Thread.sleep(2000);
		
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String username = text.split("at")[1].split("with")[0].trim();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(username);
		
		
		
	}

}
