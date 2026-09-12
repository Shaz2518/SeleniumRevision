package eCommerceAutomationE2E.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import eCommerceAutomationE2E.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement cartProdName;

	public boolean checkIfProductInCart(String productName) {
		boolean prodMatch = cartProducts.stream().anyMatch(cProd -> cProd.getText().equalsIgnoreCase(productName));
		return prodMatch;
	}
	
	public CheckoutPage checkOutOption()
	{
		cartProdName.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
		
	}

}
