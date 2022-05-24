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
		testCaseName = "Login";
		testDescription = "Validating Login Functionality";
		module = "Login module";
		authors = "Shymala";
		category = "Smoke";
	}
		
	@Test(priority = 1)
	public void validateAllTheElements() {
		boolean result = new LoginPage(driver,node)
		.validateAllTheElementsInLoginPage();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 2,dataProvider = "ExcelData")
	public void loginWithValidateCredential(String sUserName,String sPassword) {
		boolean result = new LoginPage(driver,node)
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
		boolean result = new LoginPage(driver,node)
		.enterUserName("Mathan")
		.enterPassword("Testing")
		.clickOnSignInButtonwithInvalidDetails()
		.validateFailureMsg();
		Assert.assertEquals(result, true);
	}

}
