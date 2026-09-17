package eCommerceAutomationE2E.Tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import eCommerceAutomationE2E.TestComponents.BaseTests;
import eCommerceAutomationE2E.pageObjects.CartPage;
import eCommerceAutomationE2E.pageObjects.LandingPage;
import eCommerceAutomationE2E.pageObjects.ProductCatalogue;
import eCommerceAutomationE2E.TestComponents.RetryFailure;

public class ErrorValidation extends BaseTests {
	
	String productName ="ZARA COAT 3";
	@Test(groups={"ErrorHandling"}, retryAnalyzer = RetryFailure.class )
	public void LoginErrorValidation() throws IOException, InterruptedException {
		
		LandingPage landPage = loginLandingPage();
		landPage.loginPage("demons@gmail.com", "DemonSlayer12");
		Assert.assertEquals(landPage.errorMsg(), "Incorrect  or password.");
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException
	{
		ProductCatalogue productCat = landPage.loginPage("demonslayer@gmail.com", "DemonSlayer123");
		//List<WebElement> allProduct = productCat.getProduct();
		productCat.addProductToCart(productName);
		CartPage cartPage = productCat.goToCartPage();
		boolean match = cartPage.checkIfProductInCart("ZARA COAT 2");
		Assert.assertFalse(match);
	}

}
