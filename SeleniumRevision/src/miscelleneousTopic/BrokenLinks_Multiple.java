package miscelleneousTopic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks_Multiple {

	public static void main(String[] args) throws IOException, URISyntaxException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Get the URL String
		SoftAssert soft = new SoftAssert();
		List<WebElement> links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link : links)
		{
			String hrefURL = link.getAttribute("href");
			HttpURLConnection connect = (HttpURLConnection) new URI(hrefURL).toURL().openConnection();
			connect.setRequestMethod("HEAD");
			int respCode = connect.getResponseCode();
			System.out.println(respCode);
			if(respCode>400)
			{
				soft.assertTrue(false);
			}
		}
		soft.assertAll();
	}
}


