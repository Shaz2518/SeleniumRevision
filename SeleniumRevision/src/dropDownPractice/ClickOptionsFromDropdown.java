package dropDownPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOptionsFromDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Click drop down and select 3 Adults, 2 child, and 1 infant
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		// Select 3 adults
		int i = 1;
		while (i < 3) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		// Select 2 Child
		for (int j = 0; j < 2; j++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		//Select 1 infant and done
		driver.findElement(By.id("hrefIncInf")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();

		String optionSelected = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(optionSelected);

		driver.quit();
	}

}
