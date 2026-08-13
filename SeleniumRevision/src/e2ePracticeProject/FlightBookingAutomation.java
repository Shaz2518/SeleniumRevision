package e2ePracticeProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingAutomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Autosuggestion Dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("Uni");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for (WebElement option : options) {
			String country = option.getText();
			if (country.equalsIgnoreCase("United States (USA)")) {
				option.click();
			}
		}
		System.out.println(driver.findElement(By.id("autosuggest")).getText());

		// Select On-way trip and check if return date checkpoint is disabled
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("Return Date is Enabled");
		} else
			System.out.println("Return date is Disabled");

		// Select From and To destination
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='PNQ']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']"))
				.click();

		// Select current date, 5 Adults and USD Currency and Select family and friends
		// checkpoint and click on search
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click(); // Current date
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 5 Adults
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		WebElement selectOption = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); // USD Currency
		Select dropdownOption = new Select(selectOption);
		dropdownOption.selectByValue("USD");

		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		driver.findElement(By.cssSelector("input[name='ctl00$mainContent$btn_FindFlights']")).click();

	}

}
