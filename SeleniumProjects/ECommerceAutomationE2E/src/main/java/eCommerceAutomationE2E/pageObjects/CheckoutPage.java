package eCommerceAutomationE2E.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import eCommerceAutomationE2E.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement dropDownValue;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement dropDownValueSelected;
	
	@FindBy(css=".btnn")
	WebElement checkoutBtn;
	
	By dropDownOp = By.cssSelector(".ta-results");
	
	public void addCountryCheckout(String countryName)
	{
		Actions act = new Actions(driver);
		act.sendKeys(dropDownValue, countryName).build().perform();
		waitTillElementAppear(dropDownOp);
		dropDownValueSelected.click();
		
		
	}
	
	public OrderConfirmPage placeOrder()
	{
		checkoutBtn.click();
		return new OrderConfirmPage(driver);
	}

}
