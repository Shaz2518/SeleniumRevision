package autoITPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFilePractice {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".uploader__btn")).click();

		Runtime.getRuntime().exec("C:\\Users\\localadminuser\\Desktop\\SeleniumPractice\\AutoDownload.exe");
		

	}

}
