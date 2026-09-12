package eCommerceAutomationE2E;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTestcase {

	public static void main(String[] args) {
		// Invoke Chrome Browser and Navigate to Website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		String productName = "ZARA COAT 3";

		// Login Account.
		driver.findElement(By.id("userEmail")).sendKeys("demonslayer@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("DemonSlayer123");
		driver.findElement(By.id("login")).click();

		// Get All the products in list
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		// Iterate through all the product and get desired product
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector(".mb-3 h5")).getText().equals(productName))
				.findFirst().orElse(null);
		
		//Click Add to cart and wait till the product is added to cart.
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//Go to cart page and check if product is added
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProd = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean prodMatch = cartProd.stream().anyMatch(cProd->cProd.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(prodMatch);
		
		//Place order and confirm order
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".btnn")).click();
		
		//Check Final Order Page and Confirm
		String confirmMsg= driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		
		driver.quit();
		

	}

}
