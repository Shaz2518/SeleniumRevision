package eCommerceAutomationE2E.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import eCommerceAutomationE2E.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productList = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");

	public List<WebElement> getProduct() {
		waitTillElementAppear(productList);
		return products;
	}

	public WebElement getProductName(String productName) {
		WebElement prodName = getProduct().stream()
				.filter(product -> product.findElement(By.cssSelector(".mb-3 h5")).getText().equals(productName))
				.findFirst().orElse(null);
		return prodName;
	}

	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click();
		waitTillElementAppear(toastMsg);
		waitUnitlElementDisappear();

	}

}
