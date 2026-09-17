package eCommerceAutomationE2E.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: property.getProperty("browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			if(browserName.contains("headless")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				driver.manage().window().setSize(new Dimension(1440,900)); //Default full screen
			}
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		System.out.println("Selected Browser = " + browserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreenshot(String filePath, WebDriver driver) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		File fileName = new File(System.getProperty("user.dir") + "//reports//" + filePath + ".png");
		FileUtils.copyFile(source, fileName);
		return System.getProperty("user.dir") + "//reports//" + filePath + ".png";
	}

	public List<HashMap<String, String>> getJSONData(String filePath) throws IOException {

		// Convert JSON To String
		String fileDate = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// Convert JSON to HashMap - Jackson DataBind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(fileDate,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage loginLandingPage() throws IOException {
		driver = initializeBrowser();
		landPage = new LandingPage(driver);
		landPage.goToUrl();
		return landPage;
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}

}
