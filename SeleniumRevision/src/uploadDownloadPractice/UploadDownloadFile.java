package uploadDownloadPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownloadFile {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Download File.
		WebElement downloadFile = driver.findElement(By.cssSelector("#downloadButton"));
		downloadFile.click();
		
		//Upload File.
		WebElement uploadFile = driver.findElement(By.cssSelector("input[type='file']"));
		Thread.sleep(5000);
		uploadFile.sendKeys("C:\\Users\\localadminuser\\Desktop\\ProjectFiles\\download.xlsx");
		
		
		//Wait for toast message to appear and disapper
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		By toastMsg = By.className("Toastify__toast-body");
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastMsg));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastMsg));
		
		WebElement price = driver.findElement(By.xpath("//div[text()='Apple']/parent::div/parent::div//div[@id='cell-4-undefined']"));
		String applePrice = price.getText();
		Assert.assertEquals("345", applePrice);

	}

}
