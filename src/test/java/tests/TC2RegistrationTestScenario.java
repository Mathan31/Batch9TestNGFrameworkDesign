package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC2RegistrationTestScenario extends BaseClass{
	
	@Test(priority = 1)
	public void validateAllTheElements() {
		boolean result = new LoginPage()
		.clickOnRegistrationLink()
		.verifyAllTheFields();
		Assert.assertEquals(result, true);
		new RegistrationPage().clickOnUILogo();
	}
	
	@Test(priority = 2)
	public void newUserRegistrationWithMandatoryFields() {
		boolean result = new LoginPage()
		.clickOnRegistrationLink()
		.enterFirstName("CredoSystemz")
		.selectTitle("Mr")
		.selectGender("Male")
		.enterUserName("Credo001"+getRandomIntNumber(100,10000))
		.enterEmailAddress("credo.systemz"+getRandomIntNumber(100,10000)+"@credo.com")
		.enterPassword("Testing123")
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
