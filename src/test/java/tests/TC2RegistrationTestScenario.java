package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC2RegistrationTestScenario extends BaseClass{
	
	@BeforeTest
	public void testSetUp() {
		excelName = "TC002";
		testCaseName = "Registration";
		testDescription = "Validating Registration Functionality";
		module = "Registration module";
		authors = "Thilo";
		category = "Sanity";
	}
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		boolean result = new LoginPage(driver,node)
		.clickOnRegistrationLink()
		.verifyAllTheFields();
		Assert.assertEquals(result, true);
		new RegistrationPage(driver,node).clickOnUILogo();
	}
	
	@Test(priority = 2,dataProvider = "ExcelData")
	public void newUserRegistrationWithMandatoryFields(String fName,String title,String gender,String uName,String email,String password) {
		boolean result = new LoginPage(driver,node)
		.clickOnRegistrationLink()
		.enterFirstName(fName)
		.selectTitle(title)
		.selectGender(gender)
		.enterUserName(uName+getRandomIntNumber(100,10000))
		.enterEmailAddress(email+getRandomIntNumber(100,10000)+"@credo.com")
		.enterPassword(password)
		.clickRegisterButton()
		.verifyUserRegistration()
		.clickOnLogin()
		.validateAllTheElementsInLoginPage();
		Assert.assertEquals(result, true);
	}
	
	public static int getRandomIntNumber(int min, int max) {
		Random ran = new Random();
		int ranInt = ran.nextInt((max - min) + 1) + min;
		return ranInt;
	}
	
	//@Test(priority = 3)
	public void newUserRegistrationWithMandatoryAndOptionalFields() {
		
	}

}
