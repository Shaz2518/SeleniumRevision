package eCommerceAutomationE2E.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerceAutomationE2E.AbstractComponents.AbstractComponents;

public class OrderConfirmPage extends AbstractComponents {

	WebDriver driver;

	public OrderConfirmPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement msgCheck;

	public String confirmPage() {

		return msgCheck.getText();
	}

}
