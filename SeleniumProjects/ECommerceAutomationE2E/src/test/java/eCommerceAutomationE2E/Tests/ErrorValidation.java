package eCommerceAutomationE2E.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import eCommerceAutomationE2E.TestComponents.BaseTests;
import eCommerceAutomationE2E.pageObjects.LandingPage;

public class ErrorValidation extends BaseTests {

	@Test
	public void SubmitOrder() throws IOException, InterruptedException {
			
		
		LandingPage landPage = loginLandingPage();
				
		landPage.loginPage("demonslayer@gmail.com", "DemonSlayer12");
		Assert.assertEquals(landPage.errorMsg(), "Incorrect email or password.");
		
		
		

	}

}
