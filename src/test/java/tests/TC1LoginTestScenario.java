package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC1LoginTestScenario extends BaseClass{
	
	@BeforeTest
	public void testSetUp() {
		excelName = "TC001";
	}
		
	@Test(priority = 1)
	public void validateAllTheElements() {
		boolean result = new LoginPage(driver)
		.validateAllTheElementsInLoginPage();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 2,dataProvider = "ExcelData")
	public void loginWithValidateCredential(String sUserName,String sPassword) {
		boolean result = new LoginPage(driver)
		.enterUserName(sUserName)
		.enterPassword(sPassword)
		.clickOnSignInButton()
		.validateWelcomeMsg()
		.clickOnLogOut()
		.validateAllTheElementsInLoginPage();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage(driver)
		.enterUserName("Mathan")
		.enterPassword("Testing")
		.clickOnSignInButtonwithInvalidDetails()
		.validateFailureMsg();
		Assert.assertEquals(result, true);
	}

}
