package ecommerceWebsite;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleProduct_AddToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String[] productNames = { "Cucumber", "Carrot", "Potato", "Onion" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		Thread.sleep(1000);
		int j=0;

		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < productList.size(); i++) {
			String allProducts = productList.get(i).getText();
			String finalProduct = allProducts.split(" ")[0];
			// System.out.println(finalProduct);
			List<String> productNeeded = Arrays.asList(productNames);
			if (productNeeded.contains(finalProduct)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==productNames.length)
					break;
				}
		}
	}
}