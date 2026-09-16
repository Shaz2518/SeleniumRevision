package eCommerceAutomationE2E.TestComponents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import eCommerceAutomationE2E.resources.ExtentReportNG;

public class Listeners extends BaseTests implements ITestListener {

	ExtentReports extent = ExtentReportNG.extentReport();
	ExtentTest test;
	String filePath;
	
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
	

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadLocal.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadLocal.get().fail(result.getThrowable());

		// Screenshot
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			threadLocal.get().addScreenCaptureFromPath(filePath, (result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
