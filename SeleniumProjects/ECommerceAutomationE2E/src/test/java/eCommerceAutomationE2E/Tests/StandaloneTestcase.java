package eCommerceAutomationE2E.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import eCommerceAutomationE2E.pageObjects.OrderPage;
import eCommerceAutomationE2E.pageObjects.ProductCatalogue;

public class StandaloneTestcase extends BaseTests {
	String productName = "ZARA COAT 3";

	@Test
	public void SubmitOrder() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		LandingPage landPage = loginLandingPage();
		ProductCatalogue productCat = landPage.loginPage("demonslayer@gmail.com", "DemonSlayer123");
		List<WebElement> allProduct = productCat.getProduct();
		productCat.addProductToCart(productName);
		CartPage cartPage = productCat.goToCartPage();
		boolean match = cartPage.checkIfProductInCart(productName);
		Assert.assertTrue(match);
		CheckoutPage checkout = cartPage.checkOutOption();
		checkout.addCountryCheckout("india");
		OrderConfirmPage confirm = checkout.placeOrder();
		String message = confirm.confirmPage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landPage.loginPage("demonslayer@gmail.com", "DemonSlayer123");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.orderDisplay(productName));

	}
}
