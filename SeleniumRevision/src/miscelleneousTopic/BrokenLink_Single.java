package miscelleneousTopic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrokenLink_Single {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Get the URL String
		String linkURL = driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
		
		//Get Status Code >400 Link is Broken
		HttpURLConnection connect = (HttpURLConnection) new URI(linkURL).toURL().openConnection();
		connect.setRequestMethod("HEAD");
		int respCode = connect.getResponseCode();
		System.out.println(respCode);
		if(respCode>400)
		{
			Assert.assertTrue(true);
		}
	}

}
