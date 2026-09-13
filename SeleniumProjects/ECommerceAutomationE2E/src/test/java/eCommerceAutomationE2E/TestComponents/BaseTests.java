package eCommerceAutomationE2E.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import eCommerceAutomationE2E.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	public WebDriver driver;
	public LandingPage landPage;

	public WebDriver initializeBrowser() throws IOException {
		Properties property = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\eCommerceAutomationE2E\\resources\\GlobalData.properties");
		property.load(file);

		String browserName = property.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Firefox invoke code
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge invoke code
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	@BeforeMethod
	public LandingPage  loginLandingPage() throws IOException {
		driver = initializeBrowser();
		landPage = new LandingPage(driver);
		landPage.goToUrl();
		return landPage ;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
