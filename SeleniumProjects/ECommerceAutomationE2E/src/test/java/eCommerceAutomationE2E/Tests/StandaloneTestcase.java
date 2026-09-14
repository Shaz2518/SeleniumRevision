package eCommerceAutomationE2E.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
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
	//String productName = "ZARA COAT 3";

	@Test(dataProvider="getData" , groups="OrderPurchase")
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

		//String productName = "ZARA COAT 3";
		
		ProductCatalogue productCat = landPage.loginPage(input.get("userEmail"), input.get("userPass"));
		List<WebElement> allProduct = productCat.getProduct();
		productCat.addProductToCart(input.get("productName"));
		CartPage cartPage = productCat.goToCartPage();
		boolean match = cartPage.checkIfProductInCart(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkout = cartPage.checkOutOption();
		checkout.addCountryCheckout("india");
		OrderConfirmPage confirm = checkout.placeOrder();
		String message = confirm.confirmPage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrderHistoryTest(String productName) {
		ProductCatalogue productCatalogue = landPage.loginPage("demonslayer@gmail.com", "DemonSlayer123");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.orderDisplay(productName));

	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		
		List<HashMap<String,String>> data = getJSONData(System.getProperty("user.dir") +
				"\\src\\test\\java\\eCommerceAutomationE2E\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0) },{data.get(1)}};
	}

	//@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] {{"demonslayer@gmail.com","DemonSlayer123","ZARA COAT 3" },{"ironman@avengers.com","IronMan123","ADIDAS ORIGINAL"}};
//	}
	
//	@DataProvider
//	public Object[][] getData() {
//		
//		HashMap<String,String> firstuser = new HashMap<String,String>();
//		firstuser.put("userEmail","demonslayer@gmail.com");
//		firstuser.put("userPass", "DemonSlayer123");
//		firstuser.put("productName", "ZARA COAT 3");
//		
//		HashMap<String,String> secondUser = new HashMap<String,String>();
//		secondUser.put("userEmail","ironman@avengers.com");
//		secondUser.put("userPass", "IronMan123");
//		secondUser.put("productName", "ADIDAS ORIGINAL");
//		
//		return new Object[][] {{firstuser },{secondUser}};
//	}
	
	
}
