package invokingBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserInvoke {

	public static void main(String[] args) {
		
		//Create a webdriver object
		WebDriver driver = new ChromeDriver();
		
		//Open URL and get the Title and URL Link and close browser
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		String url= driver.getCurrentUrl();
		System.out.println(url);
		
		driver.close();
		
	}

}
