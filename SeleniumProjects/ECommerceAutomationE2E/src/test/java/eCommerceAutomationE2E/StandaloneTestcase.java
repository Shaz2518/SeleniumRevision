package eCommerceAutomationE2E;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import eCommerceAutomationE2E.pageObjects.CartPage;
import eCommerceAutomationE2E.pageObjects.CheckoutPage;
import eCommerceAutomationE2E.pageObjects.LandingPage;
import eCommerceAutomationE2E.pageObjects.OrderConfirmPage;
import eCommerceAutomationE2E.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTestcase {

	public static void main(String[] args) throws InterruptedException {
		// Invoke Chrome Browser and Navigate to Website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String productName = "ZARA COAT 3";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Login Account.
		LandingPage landPage = new LandingPage(driver);
		landPage.goToUrl();
		ProductCatalogue productCat = landPage.loginPage("demonslayer@gmail.com", "DemonSlayer123");

		// Get All the products in list
		
		
		// Iterate through all the product and add product to cart
		productCat.addProductToCart(productName);

		// Go to cart page and check if product is added
		CartPage cartPage = productCat.goToCartPage();
		
		boolean match = cartPage.checkIfProductInCart(productName);
		Assert.assertTrue(match);

		// Place order and confirm order
		CheckoutPage checkout = cartPage.checkOutOption();

		//Add Country and Checkout
		
		OrderConfirmPage confirm = checkout.addCountryCheckout();

		// Check Final Order Page and Confirm
		String message = confirm.confirmPage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

		driver.quit();

	}

}
