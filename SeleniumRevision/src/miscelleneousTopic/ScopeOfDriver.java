package miscelleneousTopic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeOfDriver {

	public static void main(String[] args) {
		
		//Get count of all links in the webpage.
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		int pageLink = driver.findElements(By.tagName("a")).size();
		System.out.println("Page Link: " + pageLink);
		
		//Get count of links in footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footerLinks = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Footer Links: " + footerLinks);
		
		//Get count of links in particular column
		WebElement footerCol =footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int footerColLinks = footerCol.findElements(By.tagName("a")).size();
		System.out.println("Footer Column Links: " + footerColLinks);
		
		//Click on each link
		for(int i=1; i<footerColLinks;i++)
		{
			String linkClick= Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerCol.findElements(By.tagName("a")).get(i).sendKeys(linkClick);
		}
		
		//Get title of each tab
		System.out.println("======PAGE TITLE======");
		Set<String> windowsOpen = driver.getWindowHandles();
		Iterator<String> it = windowsOpen.iterator();
		
		while(it.hasNext())
		{
			String pageTitle = driver.switchTo().window(it.next()).getTitle();
			System.out.println(pageTitle);
		}
		
	}

}
