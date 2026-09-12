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

import eCommerceAutomationE2E.pageObjects.LandingPage;
import eCommerceAutomationE2E.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTestcase {

	public static void main(String[] args) {
		// Invoke Chrome Browser and Navigate to Website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String productName = "ZARA COAT 3";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Login Account.
		LandingPage landPage = new LandingPage(driver);
		landPage.goToUrl();
		landPage.loginPage("demonslayer@gmail.com", "DemonSlayer123");

		// Get All the products in list
		ProductCatalogue productCat = new ProductCatalogue(driver);
		List<WebElement> allProducts = productCat.getProduct();
		

		// Iterate through all the product and add product to cart
		productCat.addProductToCart(productName);

		// Click Add to cart and wait till the product is added to cart.
		
		// Go to cart page and check if product is added
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProd = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean prodMatch = cartProd.stream().anyMatch(cProd -> cProd.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(prodMatch);

		// Place order and confirm order
		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build()
				.perform();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));

		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".btnn")).click();

		// Check Final Order Page and Confirm
		String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));

		driver.quit();

	}

}
