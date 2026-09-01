package miscelleneousTopic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Screensots {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		//Convert driver object to file object
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Copy screenshot to localfile
		FileUtils.copyFile(src, new File("C:\\Users\\localadminuser\\Downloads\\TestSS.png"));
		
		
		driver.quit();
	}

}
