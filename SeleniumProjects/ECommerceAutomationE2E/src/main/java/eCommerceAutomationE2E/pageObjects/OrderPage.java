package eCommerceAutomationE2E.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import eCommerceAutomationE2E.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderProducts;
	

	public boolean orderDisplay(String productName) {
		boolean prodMatch = orderProducts.stream().anyMatch(cProd -> cProd.getText().equalsIgnoreCase(productName));
		return prodMatch;
	}
	
	

}
