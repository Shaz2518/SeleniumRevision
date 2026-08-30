package miscelleneousTopic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutor_Scroll {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;  //Scrolling is a javascript method
		
		//Page Scroll
		js.executeScript("window.scroll(0,500)");
		
		//Table Scroll		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Collect all the items
		int sum =0;
		List<WebElement> amountValues = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0; i<amountValues.size();i++)
		{
			int amount = Integer.parseInt(amountValues.get(i).getText());
			sum = sum + amount;
		}
		System.out.println(sum);
		
		//Compare Sum is correct or not
		String amountStr = driver.findElement(By.cssSelector(".totalAmount")).getText();
		System.out.println(amountStr);
		
		String finalStr = amountStr.split(":")[1].trim();
		int amountValue = Integer.parseInt(finalStr);
				
		Assert.assertEquals(sum, amountValue);
		
		driver.quit();
	}

}
