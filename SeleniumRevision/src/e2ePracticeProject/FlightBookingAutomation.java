package e2ePracticeProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightBookingAutomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Autosuggestion Dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("Uni");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for(WebElement option: options)
		{
			String country = option.getText();
			if(country.equalsIgnoreCase("United States (USA)"))
			{
				option.click();
			}
		}
	    System.out.println(driver.findElement(By.id("autosuggest")).getText());
		
		
	}

}
