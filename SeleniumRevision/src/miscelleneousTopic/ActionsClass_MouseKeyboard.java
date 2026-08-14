package miscelleneousTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass_MouseKeyboard {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		
		//Mouse Actions
		Actions mouseAct = new Actions(driver);
		WebElement hoverEle = driver.findElement(By.id("nav-link-accountList"));
		mouseAct.moveToElement(hoverEle).contextClick().build().perform();
		
		//Add capital letter and select it
		WebElement searchEle = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		mouseAct.moveToElement(searchEle).click().keyDown(Keys.SHIFT).sendKeys("iphone").doubleClick().build().perform();
		
		
		
	}

}
