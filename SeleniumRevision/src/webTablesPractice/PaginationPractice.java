package webTablesPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationPractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		List<WebElement> veggieList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		for(WebElement veggie: veggieList)
		{
			String veg = veggie.getText();
			System.out.println(veg);
		}
	}

}
