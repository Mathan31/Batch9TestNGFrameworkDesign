package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC1LoginTestScenario extends BaseClass{
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		boolean result = new LoginPage()
		.validateAllTheElementsInLoginPage();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 2)
	public void loginWithValidateCredential() {
		boolean result = new LoginPage()
		.enterUserName("Mathan")
		.enterPassword("Testing123")
		.clickOnSignInButton()
		.validateWelcomeMsg()
		.clickOnLogOut()
		.validateAllTheElementsInLoginPage();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.enterUserName("Mathan")
		.enterPassword("Testing")
		.clickOnSignInButtonwithInvalidDetails()
		.validateFailureMsg();
		Assert.assertEquals(result, true);
	}

}
