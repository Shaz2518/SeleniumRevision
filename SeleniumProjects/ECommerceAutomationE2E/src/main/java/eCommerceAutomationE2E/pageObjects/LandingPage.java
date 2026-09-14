package eCommerceAutomationE2E.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import eCommerceAutomationE2E.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.id("userEmail")).sendKeys("demonslayer@gmail.com");
	@FindBy(id = "userEmail")
	WebElement userEmail;

	// driver.findElement(By.id("userPassword")).sendKeys("DemonSlayer123");
	@FindBy(id = "userPassword")
	WebElement userPassword;

	// driver.findElement(By.id("login")).click();
	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public ProductCatalogue loginPage(String username, String password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalogue productCat = new ProductCatalogue(driver);
		return productCat;
	}
	
	public void goToUrl() {
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	
	public String errorMsg()
	{
		waitTillWebElementAppear(errorMessage);
		return errorMessage.getText();
	}

}
