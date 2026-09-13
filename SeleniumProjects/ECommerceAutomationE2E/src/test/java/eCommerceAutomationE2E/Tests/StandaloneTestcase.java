package eCommerceAutomationE2E.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import eCommerceAutomationE2E.TestComponents.BaseTests;
import eCommerceAutomationE2E.pageObjects.CartPage;
import eCommerceAutomationE2E.pageObjects.CheckoutPage;
import eCommerceAutomationE2E.pageObjects.LandingPage;
import eCommerceAutomationE2E.pageObjects.OrderConfirmPage;
import eCommerceAutomationE2E.pageObjects.ProductCatalogue;

public class StandaloneTestcase extends BaseTests {

	@Test
	public void SubmitOrder() throws IOException, InterruptedException {
			
		String productName = "ZARA COAT 3";
		LandingPage landPage = loginLandingPage();
		

		
		
		ProductCatalogue productCat = landPage.loginPage("demonslayer@gmail.com", "DemonSlayer123");
		List<WebElement> allProduct = productCat.getProduct();

		// Iterate through all the product and add product to cart
		productCat.addProductToCart(productName);

		// Go to cart page and check if product is added
		CartPage cartPage = productCat.goToCartPage();
		boolean match = cartPage.checkIfProductInCart(productName);
		Assert.assertTrue(match);

		// Place order and confirm order //Add Country and Checkout
		CheckoutPage checkout = cartPage.checkOutOption();
		checkout.addCountryCheckout("india");
		OrderConfirmPage confirm = checkout.placeOrder();

		// Check Final Order Page and Confirm
		String message = confirm.confirmPage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

	}

}
