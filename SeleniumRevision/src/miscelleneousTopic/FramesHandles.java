package miscelleneousTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");

		// Check Frame Size and move to the required frame
		int frameSize = driver.findElements(By.tagName("iframe")).size();
		System.out.println(frameSize);
		WebElement frameLoc = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameLoc);

		// Perform drag and drop action with mouse
		Actions dragAndDropAct = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		dragAndDropAct.dragAndDrop(source, target).build().perform();

		// Switch back to main window
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Draggable")).click();

	}

}
